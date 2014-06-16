(ns relations-problems
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




;; Qui est la mère de Frank ?



;; Définir une relation parent :
;;
;; INDICE :
;; Un parent est un père OU une mère



;; Qui sont les parents de Michael ?



;; Définir une relation grand-parent :
;;
;; INDICE :
;; Un grand-parent est le parent du parent d'un enfant !



;; Qui sont les petits enfants de Vito ?



;; Trouvez les couples distincts de parents




