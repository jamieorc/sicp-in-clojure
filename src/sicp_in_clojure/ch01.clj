(ns sicp-in-clojure.ch01
  (:require [clojure.contrib.math :as math]))

;; Exercise 1.3.
;; Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.
(defn add-squares-of-2-largest-of-3 [x y z]
  (let [a (if (> x y) x y)
	b (if (= a x) y x)
	c (if (> b z) b z)]
    (+ (* a a) (* c c))))

;; Exercise 1.8.
;; Create a function to implement Newton's method for cube roots, where
;; y is an approximation of the cube root:
;; ((x/y*y) + 2y) / 3
(defn find-cube-root [num, precision]
  (loop [x num
	 y 1]
    (let [result (float (/ (+ (* 2 y) (float (/ x (* y y)))) 3))]
      (println (str "result: " (float result)))
      (if (> precision (math/abs (- result y)))
	(float result)
	(recur x result)))))
	       
    
