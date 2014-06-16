(ns enigmes-logiques-problems
  (:require [clojure.core.logic :as l])
  (:require [clojure.core.logic.fd :as fd]))

;; Enigmes logiques

;; http://enigmatik.epikurieu.com/enigmes/logique/tag.fhtm
;; L'âge du père et du fils
;; Un père et un fils ont à eux deux 36 ans.
;; Sachant que le père a 30 ans de plus que le fils,
;; quel est l'âge du fils ?



;; ===============================================



;; http://www.enygmatik.com/40-enigmes-Niveau-3-Un-age-incalculable.html
;; #40 Niveau 3 - Un age incalculable

;; J'ai 2 fois l'age que tu avais quand j'avais l'age que tu as aujourd'hui.
;; Quand tu auras l'age que j'ai aujourd'hui, la somme de nos 2 age sera 90 ans.

;; Quel est mon age ?



;; ===============================================



;; cKanren: miniKanren with Constraints
;; http://www.schemeworkshop.org/2011/papers/Alvis2011.pdf

;; Standard cryptarithmetic problem
;; Finding the correct letter values to satisay the following equation

;;     S E N D
;; +   M O R E
;; -----------
;;   M O N E Y

;; Each letter represents a different digit in the range 0 through 9,
;; and the two leading digits S and M should be nonzero.

