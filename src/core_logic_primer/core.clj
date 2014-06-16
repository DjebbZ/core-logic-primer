(ns core-logic-primer.core
  (:use [clojure.core.logic]))

(run* [q]
  (== q true))

(run* [a b]
  (== a 2)
  (!= b 1)
  (== a b))

(run* [q]
  (membero q [1 2 3])
  (membero q [2 3 4]))

(run* [q]
  (== q {:a 1 :b 2}))

(run* [q]
  (== {:a q :b 2} {:a 1 :b 2}))

(run* [q]
  (== 1 q))
; is the same than
(run* [q]
  (== q 1))

(run* [q]
  (== q '(1 2 3)))
; is the same as
(run* [q]
  (== q (list 1 2 3)))
; is the same as
(run* [q]
  (== q (quote (1 2 3))))

(run* [q]
  (== q 1)
  (== q 2))

(run* [q]
  (membero q [1 2 3])
  (membero q [3 4 5]))

(run* [q]
  (fresh [a]
     (membero a [1 2 3])
     (membero q [3 4 5])
     (== a q)))

(run* [q]
  (conde
   [succeed]))

(run* [q]
  (conde
   [succeed succeed succeed succeed]))

(run* [q]
  (conde
   [succeed fail succeed succeed]))


(run* [q]
  (conde
   [succeed]
   [succeed]
   [fail]))

(run* [q]
  (conde
   [succeed (== q 1)]))

(run* [q]
  (conde
   [(== q 1) (== q 2)]))

(run* [q]
  (conde
   [(== q 1)]
   [(== q 2)]))


(run* [q]
  (conso 1 [2 3] q))

(run* [q]
  (conso q [2 3] [1 2 3]))

(run* [q]
  (conso 1 [2 q] [1 2 3]))

(run* [q]
  (resto [1 2 3 4] q))

(run* [q]
  (membero q [1 2 3]))

