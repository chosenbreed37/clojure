(ns fwpd.functional)

; use recursion instead iterating and mutating variables

; use function composition instead of mutating class attributes

(def character
    {:name "Smooches McCutes"
     :attributes {:intelligence 10
                  :strength 4
                  :dexterity 5}})

(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(defn spell-slots
    [char]
    (int (inc (/ (c-int char) 2))))

(def spell-slots-comp (comp int inc #(/ % 2) c-int))

(defn two-comp
    [f g]
    (fn [& args]
        (f (apply g args))))
