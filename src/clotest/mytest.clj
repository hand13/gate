(ns clotest.mytest)
(defn size [x] (let [[_ & m] x]
                 (if (empty? m)
                   1
                   (+ 1 (size m))
                   )
                 )
  )
(defn god [x] (let [x2 (* 2 x)] (* 100 x2)))
(defn mymap
  [f m] (into (empty m) (for [[k v] m]
                          [k (f v)])))
(defn -main [& args]
  (println (size [1 12]))
  (println (god 20))
  (:require 'clojure.string)
  (println (clojure.string/lower-case "Test"))
  (println "testing"))
