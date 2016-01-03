;          
; gwpr#    
; ¤¤¤¤#    
;     ¤¤b¤ 
;       ¤  
;          


(define (problem prob20-Astro)
 (:domain Astro)
 (:objects
  player-01 - player
  pos-00-00 - location
  pos-01-00 - location
  pos-02-00 - location
  pos-03-00 - location
  pos-04-00 - location
  pos-05-00 - location
  pos-06-00 - location
  pos-07-00 - location
  pos-08-00 - location
  pos-09-00 - location
  pos-00-01 - location
  pos-01-01 - location
  pos-02-01 - location
  pos-03-01 - location
  pos-04-01 - location
  pos-05-01 - location
  pos-06-01 - location
  pos-07-01 - location
  pos-08-01 - location
  pos-09-01 - location
  pos-00-02 - location
  pos-01-02 - location
  pos-02-02 - location
  pos-03-02 - location
  pos-04-02 - location
  pos-05-02 - location
  pos-06-02 - location
  pos-07-02 - location
  pos-08-02 - location
  pos-09-02 - location
  pos-00-03 - location
  pos-01-03 - location
  pos-02-03 - location
  pos-03-03 - location
  pos-04-03 - location
  pos-05-03 - location
  pos-06-03 - location
  pos-07-03 - location
  pos-08-03 - location
  pos-09-03 - location
  pos-00-04 - location
  pos-01-04 - location
  pos-02-04 - location
  pos-03-04 - location
  pos-04-04 - location
  pos-05-04 - location
  pos-06-04 - location
  pos-07-04 - location
  pos-08-04 - location
  pos-09-04 - location
  pos-00-05 - location
  pos-01-05 - location
  pos-02-05 - location
  pos-03-05 - location
  pos-04-05 - location
  pos-05-05 - location
  pos-06-05 - location
  pos-07-05 - location
  pos-08-05 - location
  pos-09-05 - location
  robot0 - robot
 )
 (:init
  (= (total-cost) 0)
  (at player-01 pos-03-01)
  (ladder pos-05-01)
  (ladder pos-05-02)
  (at robot0 pos-04-01)
  (facing robot0 right)
  (ground brown pos-01-02)
  (ground brown pos-02-02)
  (ground brown pos-03-02)
  (ground brown pos-04-02)
  (ground brown pos-05-03)
  (ground brown pos-06-03)
  (ground brown pos-07-04)
  (ground brown pos-08-03)
  (button blue pos-07-03)
  (gate blue pos-02-01)
  (closed pos-02-01)
  (clear pos-02-01)
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
  (boarder pos-00-05)
  (clear pos-01-00)
  (relativ-dir pos-01-00 pos-00-00 left)
  (relativ-dir pos-01-00 pos-02-00 right)
  (relativ-dir pos-01-00 pos-01-01 down)
  (clear pos-01-01)
  (relativ-dir pos-01-01 pos-00-01 left)
  (relativ-dir pos-01-01 pos-02-01 right)
  (relativ-dir pos-01-01 pos-01-00 up)
  (relativ-dir pos-01-01 pos-01-02 down)
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
  (boarder pos-01-05)
  (clear pos-02-00)
  (relativ-dir pos-02-00 pos-01-00 left)
  (relativ-dir pos-02-00 pos-03-00 right)
  (relativ-dir pos-02-00 pos-02-01 down)
  (relativ-dir pos-02-01 pos-01-01 left)
  (relativ-dir pos-02-01 pos-03-01 right)
  (relativ-dir pos-02-01 pos-02-00 up)
  (relativ-dir pos-02-01 pos-02-02 down)
  (relativ-dir pos-02-02 pos-01-02 left)
  (relativ-dir pos-02-02 pos-03-02 right)
  (relativ-dir pos-02-02 pos-02-01 up)
  (relativ-dir pos-02-02 pos-02-03 down)
  (clear pos-02-03)
  (relativ-dir pos-02-03 pos-01-03 left)
  (relativ-dir pos-02-03 pos-03-03 right)
  (relativ-dir pos-02-03 pos-02-02 up)
  (relativ-dir pos-02-03 pos-02-04 down)
  (clear pos-02-04)
  (relativ-dir pos-02-04 pos-01-04 left)
  (relativ-dir pos-02-04 pos-03-04 right)
  (relativ-dir pos-02-04 pos-02-03 up)
  (relativ-dir pos-02-04 pos-02-05 down)
  (clear pos-02-05)
  (relativ-dir pos-02-05 pos-01-05 left)
  (relativ-dir pos-02-05 pos-03-05 right)
  (relativ-dir pos-02-05 pos-02-04 up)
  (boarder pos-02-05)
  (clear pos-03-00)
  (relativ-dir pos-03-00 pos-02-00 left)
  (relativ-dir pos-03-00 pos-04-00 right)
  (relativ-dir pos-03-00 pos-03-01 down)
  (relativ-dir pos-03-01 pos-02-01 left)
  (relativ-dir pos-03-01 pos-04-01 right)
  (relativ-dir pos-03-01 pos-03-00 up)
  (relativ-dir pos-03-01 pos-03-02 down)
  (relativ-dir pos-03-02 pos-02-02 left)
  (relativ-dir pos-03-02 pos-04-02 right)
  (relativ-dir pos-03-02 pos-03-01 up)
  (relativ-dir pos-03-02 pos-03-03 down)
  (clear pos-03-03)
  (relativ-dir pos-03-03 pos-02-03 left)
  (relativ-dir pos-03-03 pos-04-03 right)
  (relativ-dir pos-03-03 pos-03-02 up)
  (relativ-dir pos-03-03 pos-03-04 down)
  (clear pos-03-04)
  (relativ-dir pos-03-04 pos-02-04 left)
  (relativ-dir pos-03-04 pos-04-04 right)
  (relativ-dir pos-03-04 pos-03-03 up)
  (relativ-dir pos-03-04 pos-03-05 down)
  (clear pos-03-05)
  (relativ-dir pos-03-05 pos-02-05 left)
  (relativ-dir pos-03-05 pos-04-05 right)
  (relativ-dir pos-03-05 pos-03-04 up)
  (boarder pos-03-05)
  (clear pos-04-00)
  (relativ-dir pos-04-00 pos-03-00 left)
  (relativ-dir pos-04-00 pos-05-00 right)
  (relativ-dir pos-04-00 pos-04-01 down)
  (relativ-dir pos-04-01 pos-03-01 left)
  (relativ-dir pos-04-01 pos-05-01 right)
  (relativ-dir pos-04-01 pos-04-00 up)
  (relativ-dir pos-04-01 pos-04-02 down)
  (relativ-dir pos-04-02 pos-03-02 left)
  (relativ-dir pos-04-02 pos-05-02 right)
  (relativ-dir pos-04-02 pos-04-01 up)
  (relativ-dir pos-04-02 pos-04-03 down)
  (clear pos-04-03)
  (relativ-dir pos-04-03 pos-03-03 left)
  (relativ-dir pos-04-03 pos-05-03 right)
  (relativ-dir pos-04-03 pos-04-02 up)
  (relativ-dir pos-04-03 pos-04-04 down)
  (clear pos-04-04)
  (relativ-dir pos-04-04 pos-03-04 left)
  (relativ-dir pos-04-04 pos-05-04 right)
  (relativ-dir pos-04-04 pos-04-03 up)
  (relativ-dir pos-04-04 pos-04-05 down)
  (clear pos-04-05)
  (relativ-dir pos-04-05 pos-03-05 left)
  (relativ-dir pos-04-05 pos-05-05 right)
  (relativ-dir pos-04-05 pos-04-04 up)
  (boarder pos-04-05)
  (clear pos-05-00)
  (relativ-dir pos-05-00 pos-04-00 left)
  (relativ-dir pos-05-00 pos-06-00 right)
  (relativ-dir pos-05-00 pos-05-01 down)
  (clear pos-05-01)
  (relativ-dir pos-05-01 pos-04-01 left)
  (relativ-dir pos-05-01 pos-06-01 right)
  (relativ-dir pos-05-01 pos-05-00 up)
  (relativ-dir pos-05-01 pos-05-02 down)
  (clear pos-05-02)
  (relativ-dir pos-05-02 pos-04-02 left)
  (relativ-dir pos-05-02 pos-06-02 right)
  (relativ-dir pos-05-02 pos-05-01 up)
  (relativ-dir pos-05-02 pos-05-03 down)
  (relativ-dir pos-05-03 pos-04-03 left)
  (relativ-dir pos-05-03 pos-06-03 right)
  (relativ-dir pos-05-03 pos-05-02 up)
  (relativ-dir pos-05-03 pos-05-04 down)
  (clear pos-05-04)
  (relativ-dir pos-05-04 pos-04-04 left)
  (relativ-dir pos-05-04 pos-06-04 right)
  (relativ-dir pos-05-04 pos-05-03 up)
  (relativ-dir pos-05-04 pos-05-05 down)
  (clear pos-05-05)
  (relativ-dir pos-05-05 pos-04-05 left)
  (relativ-dir pos-05-05 pos-06-05 right)
  (relativ-dir pos-05-05 pos-05-04 up)
  (boarder pos-05-05)
  (clear pos-06-00)
  (relativ-dir pos-06-00 pos-05-00 left)
  (relativ-dir pos-06-00 pos-07-00 right)
  (relativ-dir pos-06-00 pos-06-01 down)
  (clear pos-06-01)
  (relativ-dir pos-06-01 pos-05-01 left)
  (relativ-dir pos-06-01 pos-07-01 right)
  (relativ-dir pos-06-01 pos-06-00 up)
  (relativ-dir pos-06-01 pos-06-02 down)
  (clear pos-06-02)
  (relativ-dir pos-06-02 pos-05-02 left)
  (relativ-dir pos-06-02 pos-07-02 right)
  (relativ-dir pos-06-02 pos-06-01 up)
  (relativ-dir pos-06-02 pos-06-03 down)
  (relativ-dir pos-06-03 pos-05-03 left)
  (relativ-dir pos-06-03 pos-07-03 right)
  (relativ-dir pos-06-03 pos-06-02 up)
  (relativ-dir pos-06-03 pos-06-04 down)
  (clear pos-06-04)
  (relativ-dir pos-06-04 pos-05-04 left)
  (relativ-dir pos-06-04 pos-07-04 right)
  (relativ-dir pos-06-04 pos-06-03 up)
  (relativ-dir pos-06-04 pos-06-05 down)
  (clear pos-06-05)
  (relativ-dir pos-06-05 pos-05-05 left)
  (relativ-dir pos-06-05 pos-07-05 right)
  (relativ-dir pos-06-05 pos-06-04 up)
  (boarder pos-06-05)
  (clear pos-07-00)
  (relativ-dir pos-07-00 pos-06-00 left)
  (relativ-dir pos-07-00 pos-08-00 right)
  (relativ-dir pos-07-00 pos-07-01 down)
  (clear pos-07-01)
  (relativ-dir pos-07-01 pos-06-01 left)
  (relativ-dir pos-07-01 pos-08-01 right)
  (relativ-dir pos-07-01 pos-07-00 up)
  (relativ-dir pos-07-01 pos-07-02 down)
  (clear pos-07-02)
  (relativ-dir pos-07-02 pos-06-02 left)
  (relativ-dir pos-07-02 pos-08-02 right)
  (relativ-dir pos-07-02 pos-07-01 up)
  (relativ-dir pos-07-02 pos-07-03 down)
  (clear pos-07-03)
  (relativ-dir pos-07-03 pos-06-03 left)
  (relativ-dir pos-07-03 pos-08-03 right)
  (relativ-dir pos-07-03 pos-07-02 up)
  (relativ-dir pos-07-03 pos-07-04 down)
  (relativ-dir pos-07-04 pos-06-04 left)
  (relativ-dir pos-07-04 pos-08-04 right)
  (relativ-dir pos-07-04 pos-07-03 up)
  (relativ-dir pos-07-04 pos-07-05 down)
  (clear pos-07-05)
  (relativ-dir pos-07-05 pos-06-05 left)
  (relativ-dir pos-07-05 pos-08-05 right)
  (relativ-dir pos-07-05 pos-07-04 up)
  (boarder pos-07-05)
  (clear pos-08-00)
  (relativ-dir pos-08-00 pos-07-00 left)
  (relativ-dir pos-08-00 pos-09-00 right)
  (relativ-dir pos-08-00 pos-08-01 down)
  (clear pos-08-01)
  (relativ-dir pos-08-01 pos-07-01 left)
  (relativ-dir pos-08-01 pos-09-01 right)
  (relativ-dir pos-08-01 pos-08-00 up)
  (relativ-dir pos-08-01 pos-08-02 down)
  (clear pos-08-02)
  (relativ-dir pos-08-02 pos-07-02 left)
  (relativ-dir pos-08-02 pos-09-02 right)
  (relativ-dir pos-08-02 pos-08-01 up)
  (relativ-dir pos-08-02 pos-08-03 down)
  (relativ-dir pos-08-03 pos-07-03 left)
  (relativ-dir pos-08-03 pos-09-03 right)
  (relativ-dir pos-08-03 pos-08-02 up)
  (relativ-dir pos-08-03 pos-08-04 down)
  (clear pos-08-04)
  (relativ-dir pos-08-04 pos-07-04 left)
  (relativ-dir pos-08-04 pos-09-04 right)
  (relativ-dir pos-08-04 pos-08-03 up)
  (relativ-dir pos-08-04 pos-08-05 down)
  (clear pos-08-05)
  (relativ-dir pos-08-05 pos-07-05 left)
  (relativ-dir pos-08-05 pos-09-05 right)
  (relativ-dir pos-08-05 pos-08-04 up)
  (boarder pos-08-05)
  (clear pos-09-00)
  (relativ-dir pos-09-00 pos-08-00 left)
  (relativ-dir pos-09-00 pos-09-01 down)
  (clear pos-09-01)
  (relativ-dir pos-09-01 pos-08-01 left)
  (relativ-dir pos-09-01 pos-09-00 up)
  (relativ-dir pos-09-01 pos-09-02 down)
  (clear pos-09-02)
  (relativ-dir pos-09-02 pos-08-02 left)
  (relativ-dir pos-09-02 pos-09-01 up)
  (relativ-dir pos-09-02 pos-09-03 down)
  (clear pos-09-03)
  (relativ-dir pos-09-03 pos-08-03 left)
  (relativ-dir pos-09-03 pos-09-02 up)
  (relativ-dir pos-09-03 pos-09-04 down)
  (clear pos-09-04)
  (relativ-dir pos-09-04 pos-08-04 left)
  (relativ-dir pos-09-04 pos-09-03 up)
  (relativ-dir pos-09-04 pos-09-05 down)
  (clear pos-09-05)
  (relativ-dir pos-09-05 pos-08-05 left)
  (relativ-dir pos-09-05 pos-09-04 up)
  (boarder pos-09-05)
 )
 (:goal (and
   (at player-01 pos-01-01)
  )
 )
 (:metric minimize (total-cost))
)
