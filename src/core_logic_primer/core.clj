(ns core-logic-primer.core
  (:use [clojure.core.logic]))

(run* [q]
  (== q true))

(run* [a b]
  (== a 2)
  (logic/!= b 1)
  (== a b))

(run* [q]
  (logic/membero q [1 2 3])
  (logic/membero q [2 3 4]))

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
  (logic/membero q [1 2 3])
  (logic/membero q [3 4 5]))

(run* [q]
  (logic/fresh [a]
     (logic/membero a [1 2 3])
     (logic/membero q [3 4 5])
     (== a q)))

(run* [q]
  (logic/conde
   [logic/succeed]))

(run* [q]
  (logic/conde
   [logic/succeed logic/succeed logic/succeed logic/succeed]))

(run* [q]
  (logic/conde
   [logic/succeed logic/fail logic/succeed logic/succeed]))


(run* [q]
  (logic/conde
   [logic/succeed]
   [logic/succeed]
   [logic/fail]))

(run* [q]
  (logic/conde
   [logic/succeed (== q 1)]))

(run* [q]
  (logic/conde
   [(== q 1) (== q 2)]))

(run* [q]
  (logic/conde
   [(== q 1)]
   [(== q 2)]))


(run* [q]
  (logic/conso 1 [2 3] q))

(run* [q]
  (logic/conso q [2 3] [1 2 3]))

(run* [q]
  (logic/conso 1 [2 q] [1 2 3]))

(run* [q]
  (logic/resto [1 2 3 4] q))

(run* [q]
  (logic/membero q [1 2 3]))

