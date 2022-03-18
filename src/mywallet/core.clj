(ns mywallet.core
  (:use [clojure pprint])
  (:require [mywallet.menu :as mw.menu]))

(println "Initializing system...")

(def options []
  ["Add new bank account" "Add new credit card" {:id "o" :text "Other"}])

(mw.menu/menu {:prompt "What do you want to do?"
               :options options})
