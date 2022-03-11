(ns mywallet.menu
  (:require [clojure.string :as str]))

(defn menu [{:keys [prompt options]}]
  (let [options       (map (fn [o idx]
                             (if (string? o)
                               {:id (str (inc idx)) :text o}
                               o)) options (range))
        valid-options (set (map :id options))]
    (loop []
      (when prompt
        (println)
        (println prompt)
        (println))
      (doseq [{:keys [id text]} options]
        (println (str " [" id "]") text))
      (println)
      (println "or press <enter> to cancel")

      (let [in (str/trim (read-line))]
        (cond (= in "")
              :cancelled

              (not (valid-options in))
              (do
                (println (format "\n-- Invalid option '%s'!" in))
                (recur))

              :else
              (first (filter #(= in (:id %)) options)))))))