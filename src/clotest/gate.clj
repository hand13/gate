(ns clotest.gate)
;base gate
(defn gand [m] (if (empty? m) 0 (if (= 1 (first m)) (if (empty? (rest m)) 1 (gand (rest m))) 0)))
(defn ggor [m] (if (empty? m) 1 (if (= 1 (first m)) 1 (if (empty? (rest m)) 0 (ggor (rest m))))))
(defn gnot [m] (if (= 0 m) 1 0))
(defn xor [a b] (ggor [(gand [(gnot a) b]) (gand [a (gnot b)])]))

;add
(defn half-add [a b] (let [x (xor a b) y (gand [a b])] [x y]))
(defn flag-add [a b flag]
  (let [x (first (half-add a b))
        y (last (half-add a b))]
    (if (= 0 flag)
      [x y]
      [(gnot x) (xor x y)])))
; ax  1111 list           bx 0000 list align

(defn full-add [a b flag]
  (if (or (empty? a) (empty? b))
    [flag]
    (let [[x y] (flag-add (first a) (first b) flag)]
      (conj (full-add (rest a) (rest b) y) x))))

(defn co-add [a b]
  (let [x (reverse a) y (reverse b)]
    (full-add x y 0)))

(defn l-shift-1 [x] (conj (rest x) 0))


(defn -main [& args]
  (println (co-add [1 0] [1 0]))
  (println (l-shift-1 [0 1 1 1])))
