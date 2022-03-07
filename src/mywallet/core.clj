(ns mywallet.core
  (:use clojure.pprint))

(def investments [])

(def investment {:id 1 :tipo "renda-fixa" :name "Tesouro direto"})
(def investment-two {:id 2 :tipo "renda-fixa" :name "Tesouro direto"})

(defn add-investment [investments new-investment]
  "Add a new investment to an investment's collection"
  (conj investments new-investment))

(defn print-investments [investments]
  (map pprint investments))

(def investments (add-investment investments investment))
(def investments (add-investment investments investment-two))

(print-investments investments)