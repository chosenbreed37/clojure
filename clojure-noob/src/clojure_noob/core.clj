(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!"))

(do (println "xxx no prompt here! yyy")
    (+ 1 3))

; basic function definition
(defn square
    "Takes a number and returns its square"
    [n]
    (* n n))

; factorial
(defn factorial
    "Returns the factorial of a given number"
    [n]
    (if (= n 1)
        1
        (* n (factorial (dec n)))))
(defn factorial2
    "Returns the factorial of a given number"
    [n]
    (loop [current n accumulator 1]
        (if (= current 0)
            accumulator
            (recur (dec current) (* accumulator current)))))
(def asym-hobbit-body-parts [{:name "head" :size 3}
                           {:name "left-eye" :size 1}
                           {:name "left-ear" :size 1}
                           {:name "mouth" :size 1}
                           {:name "nose" :size 1}
                           {:name "neck" :size 2}
                           {:name "left-shoulder" :size 3}
                           {:name "left-upper-arm" :size 3}
                           {:name "chest" :size 10}
                           {:name "back" :size 10}
                           {:name "left-forearm" :size 3}
                           {:name "abdomen" :size 6}
                           {:name "left-kidney" :size 1}
                           {:name "left-hand" :size 2}
                           {:name "left-knee" :size 2}
                           {:name "left-thigh" :size 4}
                           {:name "left-lower-leg" :size 3}
                           {:name "left-achilles" :size 1}
                            {:name "left-foot" :size 2}])

(defn match-part
    "Expects a map with :name and :size. Returns another map with :name and :size"
    [part]
    (let [{name :name size :size} part]
        { :name (clojure.string/replace name #"^left-" "right-") :size size }))

(defn match-parts
    "Expects a vector of maps with :name and :size"
    [parts]
    (loop [remaining parts final []]
        (if (empty? remaining)
            final
            (let [[part & remaining'] remaining]
                (recur remaining'
                    (into final (set [part (match-part part)])))))))

(defn match-parts2
    "Expects a vector of maps with :name and :size"
    [parts]
    (reduce (fn [final part]
                (into final (set [part (match-part part)])))
            [] parts))
