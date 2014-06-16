(ns integramme-exercice
  (:require [clojure.core.logic :as l])
  (:require [clojure.core.logic.pldb :as pldb]))



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
