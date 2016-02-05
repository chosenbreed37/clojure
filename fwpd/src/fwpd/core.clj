(ns fwpd.core)
(def filename "suspects.csv")
(def vamp-keys [:name :glitter-index])
(defn str->int
    [str]
    (Integer. str))

(def conversions {:name identity :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
    "Parse CSV file"
    [string]\r
    (map #(clojure.string/split % #",") (clojure.string/split string #"\r\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

; Exercises
; 1. Change glitter-filter to return a list of names
(defn glitter-filter
    [minimum-glitter records]
    (map #(:name %)
        (filter #(>= (:glitter-index %) minimum-glitter) records)))

; 2. Write a function 'append' to add to the list of suspects
(defn append-suspect
    [new-suspect usual-suspects]
    (conj usual-suspects new-suspect))

; 3. Validate that :name and :glitter-index are present in the record to append
(defn key->bool [key] (fn [record] (if (key record) true false)))

(defn valid-record?
    [keys record]
    (reduce (fn [acc current] (and acc current)) true
        (map #(% record)
            (map #(key->bool %) vamp-keys))))

; 4. Write a file to out the map to csv
(defn out-map [filename mapified2]

    (spit filename (reduce (fn [acc curr]
                                (str acc curr))
                            ""
                            (map #(str (:name %) ", " (:glitter-index %) "\r\n") mapified2))))
