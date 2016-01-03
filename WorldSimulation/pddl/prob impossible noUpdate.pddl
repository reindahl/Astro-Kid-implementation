;                   
;                   
;       r    r   wg 
;     ¤#¤¤bb¤¤¤#¤¤¤ 
;      #  ¤¤   ##   
;   tpr#        #rt 
;   ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤ 
;                   


(define (problem prob impossible noUpdate-Astro)
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
  pos-10-03 - location
  pos-11-03 - location
  pos-12-03 - location
  pos-13-03 - location
  pos-14-03 - location
  pos-15-03 - location
  pos-16-03 - location
  pos-17-03 - location
  pos-18-03 - location
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
  pos-10-04 - location
  pos-11-04 - location
  pos-12-04 - location
  pos-13-04 - location
  pos-14-04 - location
  pos-15-04 - location
  pos-16-04 - location
  pos-17-04 - location
  pos-18-04 - location
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
  pos-10-05 - location
  pos-11-05 - location
  pos-12-05 - location
  pos-13-05 - location
  pos-14-05 - location
  pos-15-05 - location
  pos-16-05 - location
  pos-17-05 - location
  pos-18-05 - location
  pos-00-06 - location
  pos-01-06 - location
  pos-02-06 - location
  pos-03-06 - location
  pos-04-06 - location
  pos-05-06 - location
  pos-06-06 - location
  pos-07-06 - location
  pos-08-06 - location
  pos-09-06 - location
  pos-10-06 - location
  pos-11-06 - location
  pos-12-06 - location
  pos-13-06 - location
  pos-14-06 - location
  pos-15-06 - location
  pos-16-06 - location
  pos-17-06 - location
  pos-18-06 - location
  pos-00-07 - location
  pos-01-07 - location
  pos-02-07 - location
  pos-03-07 - location
  pos-04-07 - location
  pos-05-07 - location
  pos-06-07 - location
  pos-07-07 - location
  pos-08-07 - location
  pos-09-07 - location
  pos-10-07 - location
  pos-11-07 - location
  pos-12-07 - location
  pos-13-07 - location
  pos-14-07 - location
  pos-15-07 - location
  pos-16-07 - location
  pos-17-07 - location
  pos-18-07 - location
  robot0 - robot
  robot1 - robot
  robot2 - robot
  robot3 - robot
 )
 (:init
  (= (total-cost) 0)
  (at player-01 pos-04-05)
  (ladder pos-06-03)
  (ladder pos-06-04)
  (ladder pos-06-05)
  (ladder pos-14-03)
  (ladder pos-14-04)
  (ladder pos-15-04)
  (ladder pos-15-05)
  (at robot0 pos-16-05)
  (facing robot0 right)
  (at robot1 pos-05-05)
  (facing robot1 right)
  (at robot2 pos-07-02)
  (facing robot2 right)
  (at robot3 pos-12-02)
  (facing robot3 right)
  (ground brown pos-03-06)
  (ground brown pos-04-06)
  (ground brown pos-05-03)
  (ground brown pos-05-06)
  (ground brown pos-06-03)
  (ground brown pos-06-06)
  (ground brown pos-07-03)
  (ground brown pos-07-06)
  (ground brown pos-08-03)
  (ground brown pos-08-06)
  (ground brown pos-09-04)
  (ground brown pos-09-06)
  (ground brown pos-10-04)
  (ground brown pos-10-06)
  (ground brown pos-11-03)
  (ground brown pos-11-06)
  (ground brown pos-12-03)
  (ground brown pos-12-06)
  (ground brown pos-13-03)
  (ground brown pos-13-06)
  (ground brown pos-14-03)
  (ground brown pos-14-06)
  (ground brown pos-15-03)
  (ground brown pos-15-06)
  (ground brown pos-16-03)
  (ground brown pos-16-06)
  (ground brown pos-17-03)
  (ground brown pos-17-06)
  (teleport pos-03-05)
  (teleport pos-17-05)
  (button red pos-09-03)
  (button red pos-10-03)
  (gate red pos-16-02)
  (closed pos-16-02)
  (clear pos-16-02)
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
  (clear pos-01-00)
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
  (clear pos-01-06)
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
  (relativ-dir pos-02-00 pos-03-00 right)
  (relativ-dir pos-02-00 pos-02-01 down)
  (clear pos-02-01)
  (relativ-dir pos-02-01 pos-01-01 left)
  (relativ-dir pos-02-01 pos-03-01 right)
  (relativ-dir pos-02-01 pos-02-00 up)
  (relativ-dir pos-02-01 pos-02-02 down)
  (clear pos-02-02)
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
  (relativ-dir pos-02-05 pos-02-06 down)
  (clear pos-02-06)
  (relativ-dir pos-02-06 pos-01-06 left)
  (relativ-dir pos-02-06 pos-03-06 right)
  (relativ-dir pos-02-06 pos-02-05 up)
  (relativ-dir pos-02-06 pos-02-07 down)
  (clear pos-02-07)
  (relativ-dir pos-02-07 pos-01-07 left)
  (relativ-dir pos-02-07 pos-03-07 right)
  (relativ-dir pos-02-07 pos-02-06 up)
  (boarder pos-02-07)
  (clear pos-03-00)
  (relativ-dir pos-03-00 pos-02-00 left)
  (relativ-dir pos-03-00 pos-04-00 right)
  (relativ-dir pos-03-00 pos-03-01 down)
  (clear pos-03-01)
  (relativ-dir pos-03-01 pos-02-01 left)
  (relativ-dir pos-03-01 pos-04-01 right)
  (relativ-dir pos-03-01 pos-03-00 up)
  (relativ-dir pos-03-01 pos-03-02 down)
  (clear pos-03-02)
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
  (relativ-dir pos-03-05 pos-03-06 down)
  (relativ-dir pos-03-06 pos-02-06 left)
  (relativ-dir pos-03-06 pos-04-06 right)
  (relativ-dir pos-03-06 pos-03-05 up)
  (relativ-dir pos-03-06 pos-03-07 down)
  (clear pos-03-07)
  (relativ-dir pos-03-07 pos-02-07 left)
  (relativ-dir pos-03-07 pos-04-07 right)
  (relativ-dir pos-03-07 pos-03-06 up)
  (boarder pos-03-07)
  (clear pos-04-00)
  (relativ-dir pos-04-00 pos-03-00 left)
  (relativ-dir pos-04-00 pos-05-00 right)
  (relativ-dir pos-04-00 pos-04-01 down)
  (clear pos-04-01)
  (relativ-dir pos-04-01 pos-03-01 left)
  (relativ-dir pos-04-01 pos-05-01 right)
  (relativ-dir pos-04-01 pos-04-00 up)
  (relativ-dir pos-04-01 pos-04-02 down)
  (clear pos-04-02)
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
  (relativ-dir pos-04-05 pos-03-05 left)
  (relativ-dir pos-04-05 pos-05-05 right)
  (relativ-dir pos-04-05 pos-04-04 up)
  (relativ-dir pos-04-05 pos-04-06 down)
  (relativ-dir pos-04-06 pos-03-06 left)
  (relativ-dir pos-04-06 pos-05-06 right)
  (relativ-dir pos-04-06 pos-04-05 up)
  (relativ-dir pos-04-06 pos-04-07 down)
  (clear pos-04-07)
  (relativ-dir pos-04-07 pos-03-07 left)
  (relativ-dir pos-04-07 pos-05-07 right)
  (relativ-dir pos-04-07 pos-04-06 up)
  (boarder pos-04-07)
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
  (relativ-dir pos-05-05 pos-04-05 left)
  (relativ-dir pos-05-05 pos-06-05 right)
  (relativ-dir pos-05-05 pos-05-04 up)
  (relativ-dir pos-05-05 pos-05-06 down)
  (relativ-dir pos-05-06 pos-04-06 left)
  (relativ-dir pos-05-06 pos-06-06 right)
  (relativ-dir pos-05-06 pos-05-05 up)
  (relativ-dir pos-05-06 pos-05-07 down)
  (clear pos-05-07)
  (relativ-dir pos-05-07 pos-04-07 left)
  (relativ-dir pos-05-07 pos-06-07 right)
  (relativ-dir pos-05-07 pos-05-06 up)
  (boarder pos-05-07)
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
  (relativ-dir pos-06-05 pos-06-06 down)
  (relativ-dir pos-06-06 pos-05-06 left)
  (relativ-dir pos-06-06 pos-07-06 right)
  (relativ-dir pos-06-06 pos-06-05 up)
  (relativ-dir pos-06-06 pos-06-07 down)
  (clear pos-06-07)
  (relativ-dir pos-06-07 pos-05-07 left)
  (relativ-dir pos-06-07 pos-07-07 right)
  (relativ-dir pos-06-07 pos-06-06 up)
  (boarder pos-06-07)
  (clear pos-07-00)
  (relativ-dir pos-07-00 pos-06-00 left)
  (relativ-dir pos-07-00 pos-08-00 right)
  (relativ-dir pos-07-00 pos-07-01 down)
  (clear pos-07-01)
  (relativ-dir pos-07-01 pos-06-01 left)
  (relativ-dir pos-07-01 pos-08-01 right)
  (relativ-dir pos-07-01 pos-07-00 up)
  (relativ-dir pos-07-01 pos-07-02 down)
  (relativ-dir pos-07-02 pos-06-02 left)
  (relativ-dir pos-07-02 pos-08-02 right)
  (relativ-dir pos-07-02 pos-07-01 up)
  (relativ-dir pos-07-02 pos-07-03 down)
  (relativ-dir pos-07-03 pos-06-03 left)
  (relativ-dir pos-07-03 pos-08-03 right)
  (relativ-dir pos-07-03 pos-07-02 up)
  (relativ-dir pos-07-03 pos-07-04 down)
  (clear pos-07-04)
  (relativ-dir pos-07-04 pos-06-04 left)
  (relativ-dir pos-07-04 pos-08-04 right)
  (relativ-dir pos-07-04 pos-07-03 up)
  (relativ-dir pos-07-04 pos-07-05 down)
  (clear pos-07-05)
  (relativ-dir pos-07-05 pos-06-05 left)
  (relativ-dir pos-07-05 pos-08-05 right)
  (relativ-dir pos-07-05 pos-07-04 up)
  (relativ-dir pos-07-05 pos-07-06 down)
  (relativ-dir pos-07-06 pos-06-06 left)
  (relativ-dir pos-07-06 pos-08-06 right)
  (relativ-dir pos-07-06 pos-07-05 up)
  (relativ-dir pos-07-06 pos-07-07 down)
  (clear pos-07-07)
  (relativ-dir pos-07-07 pos-06-07 left)
  (relativ-dir pos-07-07 pos-08-07 right)
  (relativ-dir pos-07-07 pos-07-06 up)
  (boarder pos-07-07)
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
  (relativ-dir pos-08-05 pos-08-06 down)
  (relativ-dir pos-08-06 pos-07-06 left)
  (relativ-dir pos-08-06 pos-09-06 right)
  (relativ-dir pos-08-06 pos-08-05 up)
  (relativ-dir pos-08-06 pos-08-07 down)
  (clear pos-08-07)
  (relativ-dir pos-08-07 pos-07-07 left)
  (relativ-dir pos-08-07 pos-09-07 right)
  (relativ-dir pos-08-07 pos-08-06 up)
  (boarder pos-08-07)
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
  (relativ-dir pos-09-02 pos-09-03 down)
  (clear pos-09-03)
  (relativ-dir pos-09-03 pos-08-03 left)
  (relativ-dir pos-09-03 pos-10-03 right)
  (relativ-dir pos-09-03 pos-09-02 up)
  (relativ-dir pos-09-03 pos-09-04 down)
  (relativ-dir pos-09-04 pos-08-04 left)
  (relativ-dir pos-09-04 pos-10-04 right)
  (relativ-dir pos-09-04 pos-09-03 up)
  (relativ-dir pos-09-04 pos-09-05 down)
  (clear pos-09-05)
  (relativ-dir pos-09-05 pos-08-05 left)
  (relativ-dir pos-09-05 pos-10-05 right)
  (relativ-dir pos-09-05 pos-09-04 up)
  (relativ-dir pos-09-05 pos-09-06 down)
  (relativ-dir pos-09-06 pos-08-06 left)
  (relativ-dir pos-09-06 pos-10-06 right)
  (relativ-dir pos-09-06 pos-09-05 up)
  (relativ-dir pos-09-06 pos-09-07 down)
  (clear pos-09-07)
  (relativ-dir pos-09-07 pos-08-07 left)
  (relativ-dir pos-09-07 pos-10-07 right)
  (relativ-dir pos-09-07 pos-09-06 up)
  (boarder pos-09-07)
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
  (relativ-dir pos-10-02 pos-10-03 down)
  (clear pos-10-03)
  (relativ-dir pos-10-03 pos-09-03 left)
  (relativ-dir pos-10-03 pos-11-03 right)
  (relativ-dir pos-10-03 pos-10-02 up)
  (relativ-dir pos-10-03 pos-10-04 down)
  (relativ-dir pos-10-04 pos-09-04 left)
  (relativ-dir pos-10-04 pos-11-04 right)
  (relativ-dir pos-10-04 pos-10-03 up)
  (relativ-dir pos-10-04 pos-10-05 down)
  (clear pos-10-05)
  (relativ-dir pos-10-05 pos-09-05 left)
  (relativ-dir pos-10-05 pos-11-05 right)
  (relativ-dir pos-10-05 pos-10-04 up)
  (relativ-dir pos-10-05 pos-10-06 down)
  (relativ-dir pos-10-06 pos-09-06 left)
  (relativ-dir pos-10-06 pos-11-06 right)
  (relativ-dir pos-10-06 pos-10-05 up)
  (relativ-dir pos-10-06 pos-10-07 down)
  (clear pos-10-07)
  (relativ-dir pos-10-07 pos-09-07 left)
  (relativ-dir pos-10-07 pos-11-07 right)
  (relativ-dir pos-10-07 pos-10-06 up)
  (boarder pos-10-07)
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
  (relativ-dir pos-11-02 pos-11-03 down)
  (relativ-dir pos-11-03 pos-10-03 left)
  (relativ-dir pos-11-03 pos-12-03 right)
  (relativ-dir pos-11-03 pos-11-02 up)
  (relativ-dir pos-11-03 pos-11-04 down)
  (clear pos-11-04)
  (relativ-dir pos-11-04 pos-10-04 left)
  (relativ-dir pos-11-04 pos-12-04 right)
  (relativ-dir pos-11-04 pos-11-03 up)
  (relativ-dir pos-11-04 pos-11-05 down)
  (clear pos-11-05)
  (relativ-dir pos-11-05 pos-10-05 left)
  (relativ-dir pos-11-05 pos-12-05 right)
  (relativ-dir pos-11-05 pos-11-04 up)
  (relativ-dir pos-11-05 pos-11-06 down)
  (relativ-dir pos-11-06 pos-10-06 left)
  (relativ-dir pos-11-06 pos-12-06 right)
  (relativ-dir pos-11-06 pos-11-05 up)
  (relativ-dir pos-11-06 pos-11-07 down)
  (clear pos-11-07)
  (relativ-dir pos-11-07 pos-10-07 left)
  (relativ-dir pos-11-07 pos-12-07 right)
  (relativ-dir pos-11-07 pos-11-06 up)
  (boarder pos-11-07)
  (clear pos-12-00)
  (relativ-dir pos-12-00 pos-11-00 left)
  (relativ-dir pos-12-00 pos-13-00 right)
  (relativ-dir pos-12-00 pos-12-01 down)
  (clear pos-12-01)
  (relativ-dir pos-12-01 pos-11-01 left)
  (relativ-dir pos-12-01 pos-13-01 right)
  (relativ-dir pos-12-01 pos-12-00 up)
  (relativ-dir pos-12-01 pos-12-02 down)
  (relativ-dir pos-12-02 pos-11-02 left)
  (relativ-dir pos-12-02 pos-13-02 right)
  (relativ-dir pos-12-02 pos-12-01 up)
  (relativ-dir pos-12-02 pos-12-03 down)
  (relativ-dir pos-12-03 pos-11-03 left)
  (relativ-dir pos-12-03 pos-13-03 right)
  (relativ-dir pos-12-03 pos-12-02 up)
  (relativ-dir pos-12-03 pos-12-04 down)
  (clear pos-12-04)
  (relativ-dir pos-12-04 pos-11-04 left)
  (relativ-dir pos-12-04 pos-13-04 right)
  (relativ-dir pos-12-04 pos-12-03 up)
  (relativ-dir pos-12-04 pos-12-05 down)
  (clear pos-12-05)
  (relativ-dir pos-12-05 pos-11-05 left)
  (relativ-dir pos-12-05 pos-13-05 right)
  (relativ-dir pos-12-05 pos-12-04 up)
  (relativ-dir pos-12-05 pos-12-06 down)
  (relativ-dir pos-12-06 pos-11-06 left)
  (relativ-dir pos-12-06 pos-13-06 right)
  (relativ-dir pos-12-06 pos-12-05 up)
  (relativ-dir pos-12-06 pos-12-07 down)
  (clear pos-12-07)
  (relativ-dir pos-12-07 pos-11-07 left)
  (relativ-dir pos-12-07 pos-13-07 right)
  (relativ-dir pos-12-07 pos-12-06 up)
  (boarder pos-12-07)
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
  (relativ-dir pos-13-02 pos-13-03 down)
  (relativ-dir pos-13-03 pos-12-03 left)
  (relativ-dir pos-13-03 pos-14-03 right)
  (relativ-dir pos-13-03 pos-13-02 up)
  (relativ-dir pos-13-03 pos-13-04 down)
  (clear pos-13-04)
  (relativ-dir pos-13-04 pos-12-04 left)
  (relativ-dir pos-13-04 pos-14-04 right)
  (relativ-dir pos-13-04 pos-13-03 up)
  (relativ-dir pos-13-04 pos-13-05 down)
  (clear pos-13-05)
  (relativ-dir pos-13-05 pos-12-05 left)
  (relativ-dir pos-13-05 pos-14-05 right)
  (relativ-dir pos-13-05 pos-13-04 up)
  (relativ-dir pos-13-05 pos-13-06 down)
  (relativ-dir pos-13-06 pos-12-06 left)
  (relativ-dir pos-13-06 pos-14-06 right)
  (relativ-dir pos-13-06 pos-13-05 up)
  (relativ-dir pos-13-06 pos-13-07 down)
  (clear pos-13-07)
  (relativ-dir pos-13-07 pos-12-07 left)
  (relativ-dir pos-13-07 pos-14-07 right)
  (relativ-dir pos-13-07 pos-13-06 up)
  (boarder pos-13-07)
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
  (relativ-dir pos-14-02 pos-14-03 down)
  (relativ-dir pos-14-03 pos-13-03 left)
  (relativ-dir pos-14-03 pos-15-03 right)
  (relativ-dir pos-14-03 pos-14-02 up)
  (relativ-dir pos-14-03 pos-14-04 down)
  (clear pos-14-04)
  (relativ-dir pos-14-04 pos-13-04 left)
  (relativ-dir pos-14-04 pos-15-04 right)
  (relativ-dir pos-14-04 pos-14-03 up)
  (relativ-dir pos-14-04 pos-14-05 down)
  (clear pos-14-05)
  (relativ-dir pos-14-05 pos-13-05 left)
  (relativ-dir pos-14-05 pos-15-05 right)
  (relativ-dir pos-14-05 pos-14-04 up)
  (relativ-dir pos-14-05 pos-14-06 down)
  (relativ-dir pos-14-06 pos-13-06 left)
  (relativ-dir pos-14-06 pos-15-06 right)
  (relativ-dir pos-14-06 pos-14-05 up)
  (relativ-dir pos-14-06 pos-14-07 down)
  (clear pos-14-07)
  (relativ-dir pos-14-07 pos-13-07 left)
  (relativ-dir pos-14-07 pos-15-07 right)
  (relativ-dir pos-14-07 pos-14-06 up)
  (boarder pos-14-07)
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
  (relativ-dir pos-15-02 pos-15-03 down)
  (relativ-dir pos-15-03 pos-14-03 left)
  (relativ-dir pos-15-03 pos-16-03 right)
  (relativ-dir pos-15-03 pos-15-02 up)
  (relativ-dir pos-15-03 pos-15-04 down)
  (clear pos-15-04)
  (relativ-dir pos-15-04 pos-14-04 left)
  (relativ-dir pos-15-04 pos-16-04 right)
  (relativ-dir pos-15-04 pos-15-03 up)
  (relativ-dir pos-15-04 pos-15-05 down)
  (clear pos-15-05)
  (relativ-dir pos-15-05 pos-14-05 left)
  (relativ-dir pos-15-05 pos-16-05 right)
  (relativ-dir pos-15-05 pos-15-04 up)
  (relativ-dir pos-15-05 pos-15-06 down)
  (relativ-dir pos-15-06 pos-14-06 left)
  (relativ-dir pos-15-06 pos-16-06 right)
  (relativ-dir pos-15-06 pos-15-05 up)
  (relativ-dir pos-15-06 pos-15-07 down)
  (clear pos-15-07)
  (relativ-dir pos-15-07 pos-14-07 left)
  (relativ-dir pos-15-07 pos-16-07 right)
  (relativ-dir pos-15-07 pos-15-06 up)
  (boarder pos-15-07)
  (clear pos-16-00)
  (relativ-dir pos-16-00 pos-15-00 left)
  (relativ-dir pos-16-00 pos-17-00 right)
  (relativ-dir pos-16-00 pos-16-01 down)
  (clear pos-16-01)
  (relativ-dir pos-16-01 pos-15-01 left)
  (relativ-dir pos-16-01 pos-17-01 right)
  (relativ-dir pos-16-01 pos-16-00 up)
  (relativ-dir pos-16-01 pos-16-02 down)
  (relativ-dir pos-16-02 pos-15-02 left)
  (relativ-dir pos-16-02 pos-17-02 right)
  (relativ-dir pos-16-02 pos-16-01 up)
  (relativ-dir pos-16-02 pos-16-03 down)
  (relativ-dir pos-16-03 pos-15-03 left)
  (relativ-dir pos-16-03 pos-17-03 right)
  (relativ-dir pos-16-03 pos-16-02 up)
  (relativ-dir pos-16-03 pos-16-04 down)
  (clear pos-16-04)
  (relativ-dir pos-16-04 pos-15-04 left)
  (relativ-dir pos-16-04 pos-17-04 right)
  (relativ-dir pos-16-04 pos-16-03 up)
  (relativ-dir pos-16-04 pos-16-05 down)
  (relativ-dir pos-16-05 pos-15-05 left)
  (relativ-dir pos-16-05 pos-17-05 right)
  (relativ-dir pos-16-05 pos-16-04 up)
  (relativ-dir pos-16-05 pos-16-06 down)
  (relativ-dir pos-16-06 pos-15-06 left)
  (relativ-dir pos-16-06 pos-17-06 right)
  (relativ-dir pos-16-06 pos-16-05 up)
  (relativ-dir pos-16-06 pos-16-07 down)
  (clear pos-16-07)
  (relativ-dir pos-16-07 pos-15-07 left)
  (relativ-dir pos-16-07 pos-17-07 right)
  (relativ-dir pos-16-07 pos-16-06 up)
  (boarder pos-16-07)
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
  (relativ-dir pos-17-02 pos-17-03 down)
  (relativ-dir pos-17-03 pos-16-03 left)
  (relativ-dir pos-17-03 pos-18-03 right)
  (relativ-dir pos-17-03 pos-17-02 up)
  (relativ-dir pos-17-03 pos-17-04 down)
  (clear pos-17-04)
  (relativ-dir pos-17-04 pos-16-04 left)
  (relativ-dir pos-17-04 pos-18-04 right)
  (relativ-dir pos-17-04 pos-17-03 up)
  (relativ-dir pos-17-04 pos-17-05 down)
  (clear pos-17-05)
  (relativ-dir pos-17-05 pos-16-05 left)
  (relativ-dir pos-17-05 pos-18-05 right)
  (relativ-dir pos-17-05 pos-17-04 up)
  (relativ-dir pos-17-05 pos-17-06 down)
  (relativ-dir pos-17-06 pos-16-06 left)
  (relativ-dir pos-17-06 pos-18-06 right)
  (relativ-dir pos-17-06 pos-17-05 up)
  (relativ-dir pos-17-06 pos-17-07 down)
  (clear pos-17-07)
  (relativ-dir pos-17-07 pos-16-07 left)
  (relativ-dir pos-17-07 pos-18-07 right)
  (relativ-dir pos-17-07 pos-17-06 up)
  (boarder pos-17-07)
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
  (relativ-dir pos-18-02 pos-18-03 down)
  (clear pos-18-03)
  (relativ-dir pos-18-03 pos-17-03 left)
  (relativ-dir pos-18-03 pos-18-02 up)
  (relativ-dir pos-18-03 pos-18-04 down)
  (clear pos-18-04)
  (relativ-dir pos-18-04 pos-17-04 left)
  (relativ-dir pos-18-04 pos-18-03 up)
  (relativ-dir pos-18-04 pos-18-05 down)
  (clear pos-18-05)
  (relativ-dir pos-18-05 pos-17-05 left)
  (relativ-dir pos-18-05 pos-18-04 up)
  (relativ-dir pos-18-05 pos-18-06 down)
  (clear pos-18-06)
  (relativ-dir pos-18-06 pos-17-06 left)
  (relativ-dir pos-18-06 pos-18-05 up)
  (relativ-dir pos-18-06 pos-18-07 down)
  (clear pos-18-07)
  (relativ-dir pos-18-07 pos-17-07 left)
  (relativ-dir pos-18-07 pos-18-06 up)
  (boarder pos-18-07)
 )
 (:goal (and
   (at player-01 pos-17-02)
  )
 )
 (:metric minimize (total-cost))
)
