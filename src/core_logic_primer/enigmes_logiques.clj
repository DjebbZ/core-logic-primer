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

(l/run* [q]
    (l/fresh [mon-age ton-age]
        (fd/in q mon-age ton-age (fd/interval 90))
        (fd/eq
           (= (* 4 ton-age) (* 3 mon-age))
           (= (- (* 3 mon-age) ton-age) 90))
        (l/== q mon-age)))



;; ===============================================



;; http://enigmesetdevinettes.com/enigme/enigme-einstein/
;; Enigme Einstein – Le problème d’Einstein
;; Dans l’exemple des cinq maisons, il y a un énoncé et 14 indices.
;; Cinq hommes de nationalité et de professions différentes habitent avec leur animal préféré
;; cinq maisons de couleurs différentes où ils boivent leur boisson préférée.

;; L’Anglais habite la maison rouge.
;; L’Espagnol adore son chien.
;; L’Islandais est ingénieur.
;; On boit du café dans la maison verte.
;; La maison verte est située immédiatement à gauche de la maison blanche.
;; Le sculpteur possède un âne.
;; Le diplomate habite la maison jaune.
;; Le Norvégien habite la première maison à gauche.
;; Le médecin habite la maison voisine de celle où demeure le propriétaire du renard.
;; La maison du diplomate est voisine de celle où il y a un cheval.
;; On boit du lait dans la maison du milieu.
;; Le Slovène boit du thé.
;; Le violoniste boit du jus d’orange.
;; Le Norvégien demeure à côté de la maison bleue.

;; Cette fameuse énigme d’Einstein aurait été inventée par Albert Einstein lorsqu’il était encore enfant.
;; Selon la légende, Einstein aurait aussi dit que seulement 2% de la population était capable de résoudre cette énigme.



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

(l/run* [q]
    (l/fresh [s e n d m o r y]
         (fd/in e n d o r y (fd/interval 0 9))
         (fd/in s m (fd/interval 1 9))
         (fd/distinct [s e n d m o r y])
         (fd/eq
              (= (+ (+ (* s 1000) (* e 100) (* n 10) d)
                    (+ (* m 1000) (* o 100) (* r 10) e))
                 (+ (* m 10000) (* o 1000) (* n 100) (* e 10) y)))
         (l/== q [s e n d "" m o r e "" m o n e y])))
