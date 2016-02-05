; go through a collection of mappings and increment the values
(defn incrementBy1 [items]
    (reduce (fn [new-map [key val]]
                (assoc new-map key (inc val)))
                {}
                items))

; go through a collection of mappings and filter values greater than a given number
(defn greaterThan [items value]
    (reduce (fn [new-map [key val]]
                (if (> val value)
                    (assoc new-map key val)
                    new-map))
                    {}
                    items))
                    
