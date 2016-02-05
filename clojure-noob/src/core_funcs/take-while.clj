(def readings [{:day 1 :temperature 7}
    {:day 2 :temperature 9}
    {:day 3 :temperature 5}
    {:day 4 :temperature 7}
    {:day 5 :temperature 9}
    {:day 6 :temperature 3}
    {:day 7 :temperature 5}
    {:day 8 :temperature 7}
    {:day 9 :temperature 9}
    {:day 10 :temperature 3}
    {:day 11 :temperature 9}
    {:day 12 :temperature 9}
    {:day 13 :temperature 9}
    {:day 14 :temperature 9}
    {:day 15 :temperature 9}
    {:day 16 :temperature 9}
    {:day 17 :temperature 9}
    ])
; take available entries as long as the temperature is < 9
(take-while #(< (:temperature %) 9) readings)

; take all entries with temperature < 9
(filter #(< (:temperature %) 9) readings)

; list the days with temperature readings < 9
(defn lessThan
    [items n]
    (filter #(< (:temperature %) n) items))

(map #(:day %) (lessThan readings 9))
