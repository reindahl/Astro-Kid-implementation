; p 
;   
;   
;   
;   
; g 
; ¤ 
;   


(define (problem prob03-Astro)
 (:domain Astro)
 (:objects
  player-01 - player
  pos-00-00 - location
  pos-01-00 - location
  pos-02-00 - location
  pos-00-01 - location
  pos-01-01 - location
  pos-02-01 - location
  pos-00-02 - location
  pos-01-02 - location
  pos-02-02 - location
  pos-00-03 - location
  pos-01-03 - location
  pos-02-03 - location
  pos-00-04 - location
  pos-01-04 - location
  pos-02-04 - location
  pos-00-05 - location
  pos-01-05 - location
  pos-02-05 - location
  pos-00-06 - location
  pos-01-06 - location
  pos-02-06 - location
  pos-00-07 - location
  pos-01-07 - location
  pos-02-07 - location
 )
 (:init
  (= (total-cost) 0)
  (at player-01 pos-01-00)
  (ground brown pos-01-06)
  (clear pos-00-00)
  (relativ-dir pos-00-00 pos-01-00 right)
  (relativ-dir pos-00-00 pos-00-01 down)
  (clear pos-00-01)
  (relativ-dir pos-00-01 pos-01-01 right)
  (relativ-dir pos-00-01 pos-00-00 up)
  (relativ-dir pos-00-01 pos-00-02 down)
  (clear pos-00-02)
  (relativ-dir pos-00-02 pos-01-02 right)
  (relativ-dir pos-00-02 pos-00-01 up)
  (relativ-dir pos-00-02 pos-00-03 down)
  (clear pos-00-03)
  (relativ-dir pos-00-03 pos-01-03 right)
  (relativ-dir pos-00-03 pos-00-02 up)
  (relativ-dir pos-00-03 pos-00-04 down)
  (clear pos-00-04)
  (relativ-dir pos-00-04 pos-01-04 right)
  (relativ-dir pos-00-04 pos-00-03 up)
  (relativ-dir pos-00-04 pos-00-05 down)
  (clear pos-00-05)
  (relativ-dir pos-00-05 pos-01-05 right)
  (relativ-dir pos-00-05 pos-00-04 up)
  (relativ-dir pos-00-05 pos-00-06 down)
  (clear pos-00-06)
  (relativ-dir pos-00-06 pos-01-06 right)
  (relativ-dir pos-00-06 pos-00-05 up)
  (relativ-dir pos-00-06 pos-00-07 down)
  (clear pos-00-07)
  (relativ-dir pos-00-07 pos-01-07 right)
  (relativ-dir pos-00-07 pos-00-06 up)
  (boarder pos-00-07)
  (relativ-dir pos-01-00 pos-00-00 left)
  (relativ-dir pos-01-00 pos-02-00 right)
  (relativ-dir pos-01-00 pos-01-01 down)
  (clear pos-01-01)
  (relativ-dir pos-01-01 pos-00-01 left)
  (relativ-dir pos-01-01 pos-02-01 right)
  (relativ-dir pos-01-01 pos-01-00 up)
  (relativ-dir pos-01-01 pos-01-02 down)
  (clear pos-01-02)
  (relativ-dir pos-01-02 pos-00-02 left)
  (relativ-dir pos-01-02 pos-02-02 right)
  (relativ-dir pos-01-02 pos-01-01 up)
  (relativ-dir pos-01-02 pos-01-03 down)
  (clear pos-01-03)
  (relativ-dir pos-01-03 pos-00-03 left)
  (relativ-dir pos-01-03 pos-02-03 right)
  (relativ-dir pos-01-03 pos-01-02 up)
  (relativ-dir pos-01-03 pos-01-04 down)
  (clear pos-01-04)
  (relativ-dir pos-01-04 pos-00-04 left)
  (relativ-dir pos-01-04 pos-02-04 right)
  (relativ-dir pos-01-04 pos-01-03 up)
  (relativ-dir pos-01-04 pos-01-05 down)
  (clear pos-01-05)
  (relativ-dir pos-01-05 pos-00-05 left)
  (relativ-dir pos-01-05 pos-02-05 right)
  (relativ-dir pos-01-05 pos-01-04 up)
  (relativ-dir pos-01-05 pos-01-06 down)
  (relativ-dir pos-01-06 pos-00-06 left)
  (relativ-dir pos-01-06 pos-02-06 right)
  (relativ-dir pos-01-06 pos-01-05 up)
  (relativ-dir pos-01-06 pos-01-07 down)
  (clear pos-01-07)
  (relativ-dir pos-01-07 pos-00-07 left)
  (relativ-dir pos-01-07 pos-02-07 right)
  (relativ-dir pos-01-07 pos-01-06 up)
  (boarder pos-01-07)
  (clear pos-02-00)
  (relativ-dir pos-02-00 pos-01-00 left)
  (relativ-dir pos-02-00 pos-02-01 down)
  (clear pos-02-01)
  (relativ-dir pos-02-01 pos-01-01 left)
  (relativ-dir pos-02-01 pos-02-00 up)
  (relativ-dir pos-02-01 pos-02-02 down)
  (clear pos-02-02)
  (relativ-dir pos-02-02 pos-01-02 left)
  (relativ-dir pos-02-02 pos-02-01 up)
  (relativ-dir pos-02-02 pos-02-03 down)
  (clear pos-02-03)
  (relativ-dir pos-02-03 pos-01-03 left)
  (relativ-dir pos-02-03 pos-02-02 up)
  (relativ-dir pos-02-03 pos-02-04 down)
  (clear pos-02-04)
  (relativ-dir pos-02-04 pos-01-04 left)
  (relativ-dir pos-02-04 pos-02-03 up)
  (relativ-dir pos-02-04 pos-02-05 down)
  (clear pos-02-05)
  (relativ-dir pos-02-05 pos-01-05 left)
  (relativ-dir pos-02-05 pos-02-04 up)
  (relativ-dir pos-02-05 pos-02-06 down)
  (clear pos-02-06)
  (relativ-dir pos-02-06 pos-01-06 left)
  (relativ-dir pos-02-06 pos-02-05 up)
  (relativ-dir pos-02-06 pos-02-07 down)
  (clear pos-02-07)
  (relativ-dir pos-02-07 pos-01-07 left)
  (relativ-dir pos-02-07 pos-02-06 up)
  (boarder pos-02-07)
 )
 (:goal (and
   (at player-01 pos-01-05)
  )
 )
 (:metric minimize (total-cost))
)
