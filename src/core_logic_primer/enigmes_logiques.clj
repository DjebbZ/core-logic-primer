(ns enigmes-logiques
  (:require [clojure.core.logic :as l])
  (:require [clojure.core.logic.fd :as fd]))

;; Enigmes logiques

;; http://enigmatik.epikurieu.com/enigmes/logique/tag.fhtm
;; L'âge du père et du fils
;; Un père et un fils ont à eux deux 36 ans.
;; Sachant que le père a 30 ans de plus que le fils,
;; quel est l'âge du fils ?

(l/run* [fils]
    (l/fresh [pere]
       (fd/in pere fils (fd/interval 36))
       (fd/+ pere fils 36)
       (fd/+ fils 30 pere)))



;; ===============================================



;; http://www.enygmatik.com/40-enigmes-Niveau-3-Un-age-incalculable.html
;; #40 Niveau 3 - Un age incalculable

;; J'ai 2 fois l'age que tu avais quand j'avais l'age que tu as aujourd'hui.
;; Quand tu auras l'age que j'ai aujourd'hui, la somme de nos 2 age sera 90 ans.

;; Quel est mon age ?



;; ===============================================



;; http://enigmes.info/enigmes-logiques/2
;; Qui élève les poissons ?
;; Il y a 5 maisons alignées de couleurs différentes.
;; Dans chaque maison vit une personne de nationalité différente.
;; Chaque personne boit une boisson, fume un type de cigarettes et élève un animal différent.
;; Pouvez-vous dire qui élève les poissons, sachant que :

;;     l'anglais vit dans la maison rouge.
;;     le suédois élève des chiens.
;;     le danois boit du thé.
;;     la maison verte est juste à gauche de la maison blanche.
;;     le propriétaire de la maison verte du café.
;;     le fumeur de pall mall élève des oiseaux.
;;     le propriétaire de la maison jaune fume des dunhills.
;;     l'homme qui vit dans la maison du centre boit du lait.
;;     le norvégien vit dans la première maison.
;;     l'homme qui fume des blends vit à coté de celui qui élève des chats.
;;     la personne qui élève des chevaux vit à coté du fumeur de dunhills.
;;     l'homme qui fume des blue masters boit de la bière.
;;     l'allemand fume des princes.
;;     le norvégien vit à coté de la maison bleue.
;;     l'homme qui fume des blends à un voisin qui boit de l'eau.

;; Ce fameux casse tête fut posé par Albert Einstein (1879 - 1955). Selon lui, 98% des gens sont incapables de le résoudre.



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
