(ns sicp-in-clojure.ch01)

;; Exercise 1.3.
;; Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.
(defn add-squares-of-2-largest-of-3 [x y z]
  (let [a (if (> x y) x y)
	b (if (> x z) x z)]
    (+ (* a a) (* b b))))

