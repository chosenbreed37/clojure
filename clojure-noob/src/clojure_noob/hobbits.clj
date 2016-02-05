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
