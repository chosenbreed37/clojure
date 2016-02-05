; sum of even numbers in the fibonacci sequence that are less than 4000000
(defn sum [items]
    (reduce (fn [acc curr] (+ acc curr)) 0 items))

(defn fib [max]
    (loop [curr []]
        (if (empty? curr)
            (recur [3 2 1])
            (let [[a b & t] curr]
                (if (> a max)
                    (cons b t)
                    (recur (concat [(+ a b) a b] t)))))))

(defn euler2 [max]
    (sum (filter #(zero? (mod % 2)) (fib max))))
