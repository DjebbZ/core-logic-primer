(ns enigmes-logiques
  (:require [clojure.core.logic :as l])
  (:require [clojure.core.logic.pldb :as pldb]))

(pldb/db-rel father Father Child)
(pldb/db-rel mother Mother Child)

(def fathers (pldb/db [father 'Vito 'Michael]
                      [father 'Vito 'Sonny]
                      [father 'Vito 'Fredo]
                      [father 'Michael 'Anthony]
                      [father 'Michael 'Mary]
                      [father 'Sonny 'Vicent]
                      [father 'Sonny 'Francesca]
                      [father 'Sonny 'Kathryn]
                      [father 'Sonny 'Frank]
                      [father 'Sonny 'Santino]))

(def mothers (pldb/db [mother 'Carmela 'Michael]
                      [mother 'Carmela 'Sonny]
                      [mother 'Carmela 'Fredo]
                      [mother 'Kay 'Mary]
                      [mother 'Kay 'Anthony]
                      [mother 'Sandra 'Francesca]
                      [mother 'Sandra 'Kathryn]
                      [mother 'Sandra 'Frank]
                      [mother 'Sandra 'Santino]))

(pldb/with-db fathers
  (l/run* [q]
    (father 'Vito q)))

(pldb/with-db mothers
  (l/run* [q]
    (mother q 'Frank)))
