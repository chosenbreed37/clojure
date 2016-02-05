(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats [numbers] (map #(% numbers) [sum count avg]))

; mapping with maps ;-)
(def entities [
    {:id "jt" :name "Justin Timberlake"}
    {:id "jlaw" :name "Jennifer Lawrence"}
    {:id "jlo" :name "Jennifer Lopez"}
    ])

(defn extract-names [items] (map :name items))
