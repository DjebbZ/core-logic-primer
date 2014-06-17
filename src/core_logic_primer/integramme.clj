(ns integramme-exercice
  (:require [clojure.core.logic :as l])
  (:require [clojure.core.logic.pldb :as pldb])
  (:require [clojure.tools.macro :as macro]))



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

;; Qui boit de l’eau ?
;; Qui élève le zèbre ?

;; Cette fameuse énigme d’Einstein aurait été inventée par Albert Einstein lorsqu’il était encore enfant.
;; Selon la légende, Einstein aurait aussi dit que seulement 2% de la population était capable de résoudre cette énigme.

;; Solutions from https://github.com/swannodette/logic-tutorial#zebras

(l/defne righto [x y l]
  ([_ _ [x y . _]])
  ([_ _ [_ . ?r]] (righto x y ?r)))

(defn nexto [x y l]
  (l/conde
   ((righto x y l))
   ((righto y x l))))

(defn zebrao [hs]
  (macro/symbol-macrolet [_ (l/lvar)]
     (l/all
      (l/== [_ _ [_ _ 'lait _ _] _ _] hs)
      (l/firsto hs ['norvegien _ _ _ _])
      (nexto ['norvegien _ _ _ _] [_ _ _ _ 'bleue] hs)
      (righto [_ _ _ _ 'blanche] [_ _ _ _ 'verte] hs)
      (l/membero ['anglais _ _ _ 'rouge] hs)
      (l/membero [_ 'diplomate _ _ 'jaune] hs)
      (l/membero ['espagnol _ _ 'chien _] hs)
      (l/membero [_ _ 'cafe _ 'verte] hs)
      (l/membero ['slovene _ 'the _ _] hs)
      (l/membero [_ 'violoniste 'jus-orange _ _] hs)
      (l/membero ['islandais 'ingenieur _ _ _] hs)
      (l/membero [_ 'sculpteur _ 'ane _] hs)
      (nexto [_ 'diplomate _ _ _] [_ _ _ 'cheval _] hs)
      (nexto [_ 'medecin _ _ _] [_ _ _ 'renard _] hs)
      )))

(l/run 1 [q](zebrao q))

;; This version just answers the questions precisely

(defn zebrao [q]
  (macro/symbol-macrolet [_ (l/lvar)]
     (l/fresh [hs buveur-eau eleveur-zebre]
      (l/== [_ _ [_ _ 'lait _ _] _ _] hs)
      (l/firsto hs ['norvegien _ _ _ _])
      (nexto ['norvegien _ _ _ _] [_ _ _ _ 'bleue] hs)
      (righto [_ _ _ _ 'blanche] [_ _ _ _ 'verte] hs)
      (l/membero ['anglais _ _ _ 'rouge] hs)
      (l/membero [_ 'diplomate _ _ 'jaune] hs)
      (l/membero ['espagnol _ _ 'chien _] hs)
      (l/membero [_ _ 'cafe _ 'verte] hs)
      (l/membero ['slovene _ 'the _ _] hs)
      (l/membero [_ 'violoniste 'jus-orange _ _] hs)
      (l/membero ['islandais 'ingenieur _ _ _] hs)
      (l/membero [_ 'sculpteur _ 'ane _] hs)
      (nexto [_ 'diplomate _ _ _] [_ _ _ 'cheval _] hs)
      (nexto [_ 'medecin _ _ _] [_ _ _ 'renard _] hs)
      (l/membero [buveur-eau _ 'eau _ _] hs)
      (l/membero [eleveur-zebre _ _ 'zebre _] hs)
      (l/== q {:buveur-eau buveur-eau :eleveur-zebre eleveur-zebre}))))

(l/run 1 [q] (zebrao q))


(pldb/db-rel person nat job drink animal color pos)

(def people
  (macro/symbol-macrolet [_ (l/lvar)]
       (pldb/db [person 'norvégien _ _ _ _]
                [person 'anglais _ _ _ 'rouge]
                [person 'espagnol _ _ 'chien _]
                [person _ _ 'café _ 'verte]
                [person _ 'sculpteur _ 'âne _]
                [person _ 'diplomate _ _ 'jaune]
                [person 'slovene _ 'thé _ _]
                [person _ 'violoniste 'jus-orange _ _]
                [person 'islandais 'ingenieur _ _ _])))

(pldb/with-db people
  (l/run* [q]
       (person q (l/lvar) 'thé (l/lvar) (l/lvar))))

