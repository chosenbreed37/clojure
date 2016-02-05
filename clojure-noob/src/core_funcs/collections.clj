(empty? [])

(count '(1 2 3))

(into {} (map #(* 2 %) [ 1 2 3 ]))

(conj [0] 1 2 3)
;=> [0 1 2 3]

(conj [0] [1])
;=> [0 [1]]

(defn my-into
    [target additions]
    (apply conj target additions))

(defn switch
    [condition]
    (condp = condition
        :warn "Mmm"
        :error "Boom boom"))
