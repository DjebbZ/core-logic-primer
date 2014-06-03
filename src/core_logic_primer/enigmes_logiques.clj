(ns enigmes-logiques.core
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
