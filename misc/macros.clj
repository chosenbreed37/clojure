(defn criticize-code
    [criticism code]
    `(println ~criticism (quote ~code)))

(defmacro code-critic
    [bad good]
    `(do ~@(map #(apply criticize-code %)
        [["Great squid of Madrid, this is bad code:" bad]
        ["Sweet gorilla of Manila, this is good code:" good]])))
