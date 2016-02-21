; euler # 5
; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

(defn divisiblyBy [n m]
    (loop [divisor m]
        (if (= divisor 1)
            true
            (if (pos? (mod n divisor))
                false
                (recur (dec divisor))))))

(defn euler5 [n]
    (loop [curr n]
        (if (divisiblyBy curr n)
            curr
            (recur (+ curr n)))))
