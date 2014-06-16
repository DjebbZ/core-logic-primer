(ns relations-facts
  (:require [clojure.core.logic :as l])
  (:require [clojure.core.logic.pldb :as pldb]))

(pldb/db-rel father Father Child)
(pldb/db-rel mother Mother Child)

(def parents (pldb/db [father 'Vito 'Michael]
                      [father 'Vito 'Sonny]
                      [father 'Vito 'Fredo]
                      [father 'Michael 'Anthony]
                      [father 'Michael 'Mary]
                      [father 'Sonny 'Vicent]
                      [father 'Sonny 'Francesca]
                      [father 'Sonny 'Kathryn]
                      [father 'Sonny 'Frank]
                      [father 'Sonny 'Santino]

                      [mother 'Carmela 'Michael]
                      [mother 'Carmela 'Sonny]
                      [mother 'Carmela 'Fredo]
                      [mother 'Kay 'Mary]
                      [mother 'Kay 'Anthony]
                      [mother 'Sandra 'Francesca]
                      [mother 'Sandra 'Kathryn]
                      [mother 'Sandra 'Frank]
                      [mother 'Sandra 'Santino]))

;; Qui sont les enfants de Vito ?

(pldb/with-db parents
  (l/run* [q]
    (father 'Vito q)))

;; Qui est la mère de Frank ?

(pldb/with-db parents
  (l/run* [q]
    (mother q 'Frank)))

;; Définir une relation parent :
;; Un parent est un père OU une mère

(defn parento [p child]
  (l/conde
   [(father p child)]
   [(mother p child)]))

;; Qui sont les parents de Michael ?

(pldb/with-db parents
  (l/run* [q]
        (parent q 'Michael)))

;; Définir une relation grand-parent :
;; Un grand-parent est le parent du parent d'un enfant !

(defn grand-parento [gparent child]
  (l/fresh [q]
       (parent gparent q)
       (parent q child)))

;; Qui sont les petits enfants de Vito ?

(pldb/with-db parents
  (l/run* [q]
      (grand-parent 'Vito q)))

;; Trouvez les couples distincts de parents

(distinct (pldb/with-db parents
  (l/run* [q]
      (l/fresh [p m c]
           (l/== q [p m])
           (mother m c)
           (father p c)))))


