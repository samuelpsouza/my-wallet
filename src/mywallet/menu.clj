(ns mywallet.menu
  (:require [clojure.string :as str]))

(defn print-beautiful-prompt [prompt]
  (do
    (println)
    (println prompt)
    (println)))

(defn print-menu-options [options]
  (doseq [{:keys [id text]} options]
    (println (str " [" id "]") text)))

(defn menu [{:keys [prompt options]}]
  (let [options (map (fn [o idx]
                       (if (string? o)
                         {:id (str (inc idx)) :text o}
                         o)) options (range))
        valid-options (set (map :id options))]
    (loop []
      (when prompt
        (print-beautiful-prompt prompt))
      (print-menu-options options)
      (print-beautiful-prompt "or press <enter> to cancel")

      (let [in (str/trim (read-line))]
        (cond (= in "")
              :cancelled

              (not (valid-options in))
              (do
                (println (format "\n-- Invalid option '%s'!" in))
                (recur))

              :else
              (first (filter #(= in (:id %)) options)))))))