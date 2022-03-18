(ns mywallet.model)

(def entry {:id              1
            :description     "Salário de janeiro"
            :status          "confirmed"
            :amount          1000
            :date            "2022-02-04"})

(def create-user-account [{:id 0 :fin-institutions [] :patrimony 0 entries: [entry]}])
