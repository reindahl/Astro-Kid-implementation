; p sg¤             
; ¤¤¤x              
;                   


(define (problem prob21-Astro)
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
  pos-10-00 - location
  pos-11-00 - location
  pos-12-00 - location
  pos-13-00 - location
  pos-14-00 - location
  pos-15-00 - location
  pos-16-00 - location
  pos-17-00 - location
  pos-18-00 - location
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
  pos-10-01 - location
  pos-11-01 - location
  pos-12-01 - location
  pos-13-01 - location
  pos-14-01 - location
  pos-15-01 - location
  pos-16-01 - location
  pos-17-01 - location
  pos-18-01 - location
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
  pos-10-02 - location
  pos-11-02 - location
  pos-12-02 - location
  pos-13-02 - location
  pos-14-02 - location
  pos-15-02 - location
  pos-16-02 - location
  pos-17-02 - location
  pos-18-02 - location
  stone0 - stone
 )
 (:init
  (= (total-cost) 0)
  (at player-01 pos-01-00)
  (at stone0 pos-03-00)
  (ground brown pos-01-01)
  (ground brown pos-02-01)
  (ground brown pos-03-01)
  (ground purple pos-04-01)
  (ground brown pos-05-00)
  (boot purple pos-02-00)
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
  (boarder pos-00-02)
  (relativ-dir pos-01-00 pos-00-00 left)
  (relativ-dir pos-01-00 pos-02-00 right)
  (relativ-dir pos-01-00 pos-01-01 down)
  (relativ-dir pos-01-01 pos-00-01 left)
  (relativ-dir pos-01-01 pos-02-01 right)
  (relativ-dir pos-01-01 pos-01-00 up)
  (relativ-dir pos-01-01 pos-01-02 down)
  (clear pos-01-02)
  (relativ-dir pos-01-02 pos-00-02 left)
  (relativ-dir pos-01-02 pos-02-02 right)
  (relativ-dir pos-01-02 pos-01-01 up)
  (boarder pos-01-02)
  (clear pos-02-00)
  (relativ-dir pos-02-00 pos-01-00 left)
  (relativ-dir pos-02-00 pos-03-00 right)
  (relativ-dir pos-02-00 pos-02-01 down)
  (relativ-dir pos-02-01 pos-01-01 left)
  (relativ-dir pos-02-01 pos-03-01 right)
  (relativ-dir pos-02-01 pos-02-00 up)
  (relativ-dir pos-02-01 pos-02-02 down)
  (clear pos-02-02)
  (relativ-dir pos-02-02 pos-01-02 left)
  (relativ-dir pos-02-02 pos-03-02 right)
  (relativ-dir pos-02-02 pos-02-01 up)
  (boarder pos-02-02)
  (relativ-dir pos-03-00 pos-02-00 left)
  (relativ-dir pos-03-00 pos-04-00 right)
  (relativ-dir pos-03-00 pos-03-01 down)
  (relativ-dir pos-03-01 pos-02-01 left)
  (relativ-dir pos-03-01 pos-04-01 right)
  (relativ-dir pos-03-01 pos-03-00 up)
  (relativ-dir pos-03-01 pos-03-02 down)
  (clear pos-03-02)
  (relativ-dir pos-03-02 pos-02-02 left)
  (relativ-dir pos-03-02 pos-04-02 right)
  (relativ-dir pos-03-02 pos-03-01 up)
  (boarder pos-03-02)
  (clear pos-04-00)
  (relativ-dir pos-04-00 pos-03-00 left)
  (relativ-dir pos-04-00 pos-05-00 right)
  (relativ-dir pos-04-00 pos-04-01 down)
  (relativ-dir pos-04-01 pos-03-01 left)
  (relativ-dir pos-04-01 pos-05-01 right)
  (relativ-dir pos-04-01 pos-04-00 up)
  (relativ-dir pos-04-01 pos-04-02 down)
  (clear pos-04-02)
  (relativ-dir pos-04-02 pos-03-02 left)
  (relativ-dir pos-04-02 pos-05-02 right)
  (relativ-dir pos-04-02 pos-04-01 up)
  (boarder pos-04-02)
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
  (boarder pos-05-02)
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
  (boarder pos-06-02)
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
  (boarder pos-07-02)
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
  (boarder pos-08-02)
  (clear pos-09-00)
  (relativ-dir pos-09-00 pos-08-00 left)
  (relativ-dir pos-09-00 pos-10-00 right)
  (relativ-dir pos-09-00 pos-09-01 down)
  (clear pos-09-01)
  (relativ-dir pos-09-01 pos-08-01 left)
  (relativ-dir pos-09-01 pos-10-01 right)
  (relativ-dir pos-09-01 pos-09-00 up)
  (relativ-dir pos-09-01 pos-09-02 down)
  (clear pos-09-02)
  (relativ-dir pos-09-02 pos-08-02 left)
  (relativ-dir pos-09-02 pos-10-02 right)
  (relativ-dir pos-09-02 pos-09-01 up)
  (boarder pos-09-02)
  (clear pos-10-00)
  (relativ-dir pos-10-00 pos-09-00 left)
  (relativ-dir pos-10-00 pos-11-00 right)
  (relativ-dir pos-10-00 pos-10-01 down)
  (clear pos-10-01)
  (relativ-dir pos-10-01 pos-09-01 left)
  (relativ-dir pos-10-01 pos-11-01 right)
  (relativ-dir pos-10-01 pos-10-00 up)
  (relativ-dir pos-10-01 pos-10-02 down)
  (clear pos-10-02)
  (relativ-dir pos-10-02 pos-09-02 left)
  (relativ-dir pos-10-02 pos-11-02 right)
  (relativ-dir pos-10-02 pos-10-01 up)
  (boarder pos-10-02)
  (clear pos-11-00)
  (relativ-dir pos-11-00 pos-10-00 left)
  (relativ-dir pos-11-00 pos-12-00 right)
  (relativ-dir pos-11-00 pos-11-01 down)
  (clear pos-11-01)
  (relativ-dir pos-11-01 pos-10-01 left)
  (relativ-dir pos-11-01 pos-12-01 right)
  (relativ-dir pos-11-01 pos-11-00 up)
  (relativ-dir pos-11-01 pos-11-02 down)
  (clear pos-11-02)
  (relativ-dir pos-11-02 pos-10-02 left)
  (relativ-dir pos-11-02 pos-12-02 right)
  (relativ-dir pos-11-02 pos-11-01 up)
  (boarder pos-11-02)
  (clear pos-12-00)
  (relativ-dir pos-12-00 pos-11-00 left)
  (relativ-dir pos-12-00 pos-13-00 right)
  (relativ-dir pos-12-00 pos-12-01 down)
  (clear pos-12-01)
  (relativ-dir pos-12-01 pos-11-01 left)
  (relativ-dir pos-12-01 pos-13-01 right)
  (relativ-dir pos-12-01 pos-12-00 up)
  (relativ-dir pos-12-01 pos-12-02 down)
  (clear pos-12-02)
  (relativ-dir pos-12-02 pos-11-02 left)
  (relativ-dir pos-12-02 pos-13-02 right)
  (relativ-dir pos-12-02 pos-12-01 up)
  (boarder pos-12-02)
  (clear pos-13-00)
  (relativ-dir pos-13-00 pos-12-00 left)
  (relativ-dir pos-13-00 pos-14-00 right)
  (relativ-dir pos-13-00 pos-13-01 down)
  (clear pos-13-01)
  (relativ-dir pos-13-01 pos-12-01 left)
  (relativ-dir pos-13-01 pos-14-01 right)
  (relativ-dir pos-13-01 pos-13-00 up)
  (relativ-dir pos-13-01 pos-13-02 down)
  (clear pos-13-02)
  (relativ-dir pos-13-02 pos-12-02 left)
  (relativ-dir pos-13-02 pos-14-02 right)
  (relativ-dir pos-13-02 pos-13-01 up)
  (boarder pos-13-02)
  (clear pos-14-00)
  (relativ-dir pos-14-00 pos-13-00 left)
  (relativ-dir pos-14-00 pos-15-00 right)
  (relativ-dir pos-14-00 pos-14-01 down)
  (clear pos-14-01)
  (relativ-dir pos-14-01 pos-13-01 left)
  (relativ-dir pos-14-01 pos-15-01 right)
  (relativ-dir pos-14-01 pos-14-00 up)
  (relativ-dir pos-14-01 pos-14-02 down)
  (clear pos-14-02)
  (relativ-dir pos-14-02 pos-13-02 left)
  (relativ-dir pos-14-02 pos-15-02 right)
  (relativ-dir pos-14-02 pos-14-01 up)
  (boarder pos-14-02)
  (clear pos-15-00)
  (relativ-dir pos-15-00 pos-14-00 left)
  (relativ-dir pos-15-00 pos-16-00 right)
  (relativ-dir pos-15-00 pos-15-01 down)
  (clear pos-15-01)
  (relativ-dir pos-15-01 pos-14-01 left)
  (relativ-dir pos-15-01 pos-16-01 right)
  (relativ-dir pos-15-01 pos-15-00 up)
  (relativ-dir pos-15-01 pos-15-02 down)
  (clear pos-15-02)
  (relativ-dir pos-15-02 pos-14-02 left)
  (relativ-dir pos-15-02 pos-16-02 right)
  (relativ-dir pos-15-02 pos-15-01 up)
  (boarder pos-15-02)
  (clear pos-16-00)
  (relativ-dir pos-16-00 pos-15-00 left)
  (relativ-dir pos-16-00 pos-17-00 right)
  (relativ-dir pos-16-00 pos-16-01 down)
  (clear pos-16-01)
  (relativ-dir pos-16-01 pos-15-01 left)
  (relativ-dir pos-16-01 pos-17-01 right)
  (relativ-dir pos-16-01 pos-16-00 up)
  (relativ-dir pos-16-01 pos-16-02 down)
  (clear pos-16-02)
  (relativ-dir pos-16-02 pos-15-02 left)
  (relativ-dir pos-16-02 pos-17-02 right)
  (relativ-dir pos-16-02 pos-16-01 up)
  (boarder pos-16-02)
  (clear pos-17-00)
  (relativ-dir pos-17-00 pos-16-00 left)
  (relativ-dir pos-17-00 pos-18-00 right)
  (relativ-dir pos-17-00 pos-17-01 down)
  (clear pos-17-01)
  (relativ-dir pos-17-01 pos-16-01 left)
  (relativ-dir pos-17-01 pos-18-01 right)
  (relativ-dir pos-17-01 pos-17-00 up)
  (relativ-dir pos-17-01 pos-17-02 down)
  (clear pos-17-02)
  (relativ-dir pos-17-02 pos-16-02 left)
  (relativ-dir pos-17-02 pos-18-02 right)
  (relativ-dir pos-17-02 pos-17-01 up)
  (boarder pos-17-02)
  (clear pos-18-00)
  (relativ-dir pos-18-00 pos-17-00 left)
  (relativ-dir pos-18-00 pos-18-01 down)
  (clear pos-18-01)
  (relativ-dir pos-18-01 pos-17-01 left)
  (relativ-dir pos-18-01 pos-18-00 up)
  (relativ-dir pos-18-01 pos-18-02 down)
  (clear pos-18-02)
  (relativ-dir pos-18-02 pos-17-02 left)
  (relativ-dir pos-18-02 pos-18-01 up)
  (boarder pos-18-02)
 )
 (:goal (and
   (at player-01 pos-04-00)
  )
 )
 (:metric minimize (total-cost))
)
