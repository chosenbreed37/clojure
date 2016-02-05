; the sum of multiples of 3 or 5 less than 1000
(defn sum [items]
    (reduce (fn [acc curr] (+ acc curr)) 0 items))

(defn euler1
    "Compute the sum of multiples of 3 or 5 up to n"
    [n]
    (sum (filter #(or (zero? (mod % 3))
                    (zero? (mod % 5)))
                        (range 1 n))
