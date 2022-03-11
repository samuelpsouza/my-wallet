(ns mywallet.core
  (:use [clojure pprint])
  (:require [mywallet.model :as mw.model])
  (:require [mywallet.menu :as mw.menu]))

(mw.menu/menu {:prompt "What do you want to do?"
       :options ["Add new bank account" "Add new credit card" {:id "o" :text "Other"}]})
