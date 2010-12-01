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
	       
;; Exercise 1.11.  A function f is defined by the rule that
;;   f(n) = n if n < 3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n >= 3.
;; Write a procedure that computes f by means of a recursive process.
;; Write a procedure that computes f by means of an iterative process.
;; 1:(1) 1
;; 2:(2) 2
;; 3:(4) 2 + 2*1
;; 4:(11) f(3) + 2*2 + 3*1
;;         4     4     3
;; 5:(25) f(4) + 2*f(3) + 3*2
;;         11    8        6
;; 6:(59) f(5) + 2*f(4) + 3*f(3)
;;         25    22       12
;; 7:(142) f(6) + 2*f(5) + 3*f(4)
;;          59    50       33

(defn ex-1-11-recursive [n]
  (if (< n 3)
    n
    (+ (ex-1-11-recursive (- n 1)) (* 2 (ex-1-11-recursive (- n 2))) (* 3 (ex-1-11-recursive (- n 3))))))

(defn ex-1-11-iterative [n]
  (loop [x 2 y 2 z 0 count n]
    (if (= count 2)
      x
      (recur (+ x y z) (* 2 x) (* (/ y 2) 3) (- count 1)))))
