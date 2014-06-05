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


;; http://enigmes.info/enigmes-logiques/2
;; Qui élève les poissons ?
;; Il y a 5 maisons alignées de couleurs différentes.
;; Dans cha;; ue maison vit une personne de nationalité différente.
;; Cha;; ue personne boit une boisson, fume un type de cigarettes et élève un animal différent.
;; Pouvez-vous dire ;; ui élève les poissons, sachant ;; ue :

;;     l'anglais vit dans la maison rouge.
;;     le suédois élève des chiens.
;;     le danois boit du thé.
;;     la maison verte est juste à gauche de la maison blanche.
;;     le propriétaire de la maison verte du café.
;;     le fumeur de pall mall élève des oiseaux.
;;     le propriétaire de la maison jaune fume des dunhills.
;;     l'homme ;; ui vit dans la maison du centre boit du lait.
;;     le norvégien vit dans la première maison.
;;     l'homme ;; ui fume des blends vit à coté de celui ;; ui élève des chats.
;;     la personne ;; ui élève des chevaux vit à coté du fumeur de dunhills.
;;     l'homme ;; ui fume des blue masters boit de la bière.
;;     l'allemand fume des princes.
;;     le norvégien vit à coté de la maison bleue.
;;     l'homme ;; ui fume des blends à un voisin ;; ui boit de l'eau. 

;; Ce fameux casse tête fut posé par Albert Einstein (1879 - 1955). Selon lui, 98% des gens sont incapables de le résoudre.
