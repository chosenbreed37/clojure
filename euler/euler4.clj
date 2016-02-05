; Project Euler #4
; Largest palindrome product
; A palindromic number reads the same both ways.
; The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
; Find the largest palindrome made from the product of two 3-digit numbers.

(defn power [b e]
    (reduce (fn [curr acc] (* curr acc)) 1 (replicate e b)))

(defn palindromic [n]
    (let [a (str n)]
        (= (clojure.string/reverse a) a)))

(defn products [ns]
    (loop [curr ns acc []]
        (if (empty? curr)
            acc
            (let [[h & t] curr]
                (recur t (concat (map #(* h %) curr) acc))))))

(defn euler4 [digits]
    (let [m (power 10 (dec digits)) n (power 10 digits)]
        (last (filter #(palindromic %) (sort (products (range m n)))))))
