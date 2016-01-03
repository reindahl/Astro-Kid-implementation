(define (domain Astro)
	(:requirements :typing :strips :equality :adl)
	(:types colour remote thing location direction goal flag - object
			player stone robot - thing 
			
	)
	(:constants up down left right - direction
			brown green purple blue red yellow - colour
	)
	
	(:functions (total-cost) - number)
	
	(:predicates 
		(clear ?l - location)
		(at ?t - thing ?l - location)
		(ladder ?l - location)
		(relativ-dir ?from ?to - location ?dir - direction)
		(moving ?s - thing ?dir - direction)
		(moved ?s - thing ?dir - direction)
		(update ?f - flag)
		(boarder ?l - location)
		(ground ?c - colour ?l - location)
		(button ?c - colour ?l - location)
		(gate ?c - colour ?l - location)
		(closed ?at - loaction)
		(facing ?t - thing ?dir - direction)
		(teleport ?l - location)
		(has ?r - remote)
		(wearing ?col - colour)
		(boot ?col - colour ?at - location)
		(controller ?r - remote ?at - location)
		(falling ?t)
	)
	(:derived (closed ?at)
		(exists (?c - colour ?b - location)
			(and
				(gate ?c ?at) 
				(button ?c ?b)
				(clear ?b)
			)
		)
	)
	
	;(:derived (falling ?t)
	;	(exists (?at ?under - location)
	;		(and
	;			(at ?t ?at)
	;			(relativ-dir ?at ?under down)
	;			(clear ?under)
	;			(not (closed ?under))
	;			
	;		)
	;	)
	;)
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	; player action
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	
	
	(:action walk
       :parameters  	(?p - player ?from ?to ?underFrom ?underTo - location ?dir - direction)
       :precondition 	(and 
       						(not (moving ?p left))(not (moving ?p right))
							(at ?p ?from) 

							(clear ?to)
							(not (closed ?to))
							(relativ-dir ?from ?to ?dir)
							(or (= ?dir left) (= ?dir right)) 
							
							
							(relativ-dir ?from ?underFrom down)
							(or
								(not (clear ?underFrom))
								(ladder ?underFrom)
								(closed ?underFrom)
							)
							
							(relativ-dir ?to ?underTo down)
							(not (and (ground blue ?underFrom) (not (wearing blue))))
							(not (and (ground purple ?underFrom) (not (wearing purple))))
							
							
							;;check nothing is moving
							
							(not (exists (?t3 - thing ?dirx - direction) (moving ?t3 ?dirx))) 
							;;check nothing is falling
							;(not (exists (?tx - thing) (falling ?tx)))
							
							;;;;;;
							; check all stones are legal
							;;;;;;
							(not
								(exists (?s - stone ?at ?under - location) 
									(and 
										(relativ-dir ?at ?under down)
										(at ?s ?at)
										(or 
											(ground purple ?under)
											(ground blue ?under)
										)
									)
								)
							)
						)
       :effect 			(and
							(not (at ?p ?from))
							(clear ?from)
							(at ?p ?to)
							(not (clear ?to))
							(increase (total-cost) 1)
							
							(when (and (ground green ?underTo) (not (wearing green)))
								(moving ?p ?dir)
							)
							;;start falling
							(when (and 
									(clear ?underTo)
									(not (closed ?underTo))
									(not (ladder ?underTo))
									(not (ladder ?to))
								)
									(falling ?p)
							)
						)
	)

	 (:action climbUp
       :parameters  (?p - player ?from ?to - location)
       :precondition (and
						(not (moving ?p left))(not (moving ?p right)) 

						(at ?p ?from) 
						(not (closed ?to))
						(or 
							(clear ?to) 
							(and
								(exists (?col - colour) (ground ?col ?to))
								(ladder ?to)
							)
						)
						(relativ-dir ?from ?to up)
						(ladder ?from)
						
						;;check nothing else is moving
							
						(not (exists (?t3 - thing ?dirx - direction) (moving ?t3 ?dirx))) 
						;(not (exists (?tx - thing) (falling ?tx)))	
					)
       :effect (and (not (at ?p ?from))
       				(when 
       					(not (exists (?col - colour) (ground ?col ?to)))
							(clear ?from)
					)
					(not (clear ?to))
					(at ?p ?to)
					(increase (total-cost) 1)
				)
	)
	(:action climbDown
			:parameters  (?p - player ?from ?to - location)
			:precondition (and 
							(not (moving ?p left))(not (moving ?p right))
							(at ?p ?from)
							(not (closed ?to)) 
							(or 
								(clear ?to) 
								(and
									(exists (?col - colour) (ground ?col ?to))
									(ladder ?to)
								)
							)
							(relativ-dir ?from ?to down)
							(or (ladder ?to) (ladder ?from))
							
							;;check nothing else is moving
							(not (exists (?t3 - thing ?dirx - direction) (moving ?t3 ?dirx))) 
							;(not (exists (?tx - thing) (falling ?tx)))
							
						  )
			:effect 	(and 
							(not (at ?p ?from))
							(when 
								(not (exists (?col - colour) (ground ?col ?to)))
									(clear ?from)
							)
							(not (clear ?to))
							(at ?p ?to)
							(increase (total-cost) 1)
						)
	)
	
	(:action activateRobot
       :parameters  	(?at - location ?r - robot ?rem - remote ?dir - direction)
       :precondition 	(and 
							(not (moving ?r left))(not (moving ?r down))(not (moving ?r right))
							(at ?r ?at) 
							(facing ?r ?dir)
							(has ?rem)
						)
       :effect 			(and
							(not (has ?rem))
							(moving ?r ?dir)
							(increase (total-cost) 1)
						)
	)
	(:action push
		:parameters  (?p - player ?t - thing ?at ?under ?from ?to ?underFrom ?underTo - location ?dir - direction)
		:precondition (and
						(not (moving ?p left))(not (moving ?p right))
						(at ?p ?at) (at ?t ?from) (clear ?to) 
						(relativ-dir ?at ?from ?dir) 
						(relativ-dir ?from ?to ?dir) 
						
						(or (= ?dir left) (= ?dir right))
						
						(not (= ?p ?t))
						
						(clear ?to)
						(not (closed ?to))
						
						(relativ-dir ?from ?underfrom down)
						(relativ-dir ?to ?underTo down)
						;;check nothing else is moving
							(relativ-dir ?from ?under down)
							(or
								(not (clear ?under))
								(ladder ?under)
							)
							
							(not (exists (?t3 - thing ?dirx - direction) (moving ?t3 ?dirx))) 
							;(not (exists (?tx - thing) (falling ?tx)))

					  )
					  
		:effect (and  	
						(not (at ?t ?from))
						(clear ?from)
						
						(at ?t ?to)
						(not (clear ?to))
						

						(facing ?t ?dir)
						(when (= ?dir left) (not (facing ?t right)))
						(when (= ?dir right) (not (facing ?t left)))

						(when 	(or
									(clear ?underTo)
									(ground green ?underTo)
									(exists (?r - robot) (= ?r ?t))
								)
								(moving ?t ?dir)
						)
						
						;;start falling
						(when (and 
									(clear ?underTo)
									(not (closed ?underTo))
								)
									(falling ?t)
						)

						(increase (total-cost) 1)
				)
	
	
	)
	
	(:action teleport
		:parameters  (?p - player ?at ?tele - location)
		:precondition 	(and
							(at ?p ?at)
							(teleport ?tele)
							(teleport ?at)
							(not (= ?at ?tele))
						)
		:effect	(and
					(at ?p ?tele)
					(not (at ?p ?at))
					(clear ?at)
					(not (clear ?tele))
				)
	)
	(:action fall
	
			:parameters  (?t - thing ?at ?under - location)
			:precondition	(and
								(relativ-dir ?at ?under down)
								(at ?t ?at)
								(clear ?under)
								(not (closed ?under))
								(not (ladder ?under))
								(not (ladder ?at))
								(not (exists (?p - player) (= ?p ?t)))
							)
			:effect			(and
								(not (at ?t ?at))
								(clear ?at)
								(at ?t ?under)
								(not (clear ?under))
							)
	)
	(:action fall 
	
			:parameters  (?p - player ?at ?under - location)
			:precondition	(and
								(relativ-dir ?at ?under down)
								(at ?p ?at)
								(clear ?under)
								(not (closed ?under))
								(not (ladder ?under))
								(not (ladder ?at))
							)
			:effect			(and
								(not (at ?p ?at))
								(clear ?at)
								(at ?p ?under)
								(not (clear ?under))
								(not (moving ?p left))
								(not (moving ?p right))
								
								(increase (total-cost) 1)
								
							)
	)
	
	(:action fallStop 
	
			:parameters  (?t - thing ?at ?under - location)
			:precondition	(and
								(relativ-dir ?at ?under down)
								(at ?t ?at)
								(or 
									(not (clear ?under))
									(closed ?under)
								)
								;(not (ladder ?under))
								;(not (ladder ?at))
							)
			:effect			(and
								(not (falling ?t))
							)
	)

	(:action slide 
	
			:parameters  (?p - player ?at ?to ?under ?underTo - location ?dir - direction)
			:precondition	(and
								(relativ-dir ?at ?under down)
								(relativ-dir ?at ?to ?dir)
								(relativ-dir ?to ?underTo down)
								(at ?p ?at)
								
								(clear ?to)
								(not (closed ?to))
								(moving ?p ?dir)
								(or (= ?dir left) (= ?dir right))
								
								(ground green ?under)
							)
			:effect			(and
								(not (at ?p ?at))
								(clear ?at)
								(at ?p ?to)
								(not (clear ?to))
								(when (not (ground green ?underTo))
									(and
										(not (moving ?p left))
										(not (moving ?p right))
									)
								)
								
								(increase (total-cost) 1)
							)
	)
	;;;;;;
	; Slide hit
	;;;;;;
	(:action slide 
	
			:parameters  (?p - player ?t - thing ?at ?to ?under ?underTo ?toTo - location ?dir - direction)
			:precondition	(and
								(relativ-dir ?at ?under down)
								(relativ-dir ?at ?to ?dir)
								(relativ-dir ?to ?toTo ?dir)
								(relativ-dir ?toTo ?underTo down)
								(at ?p ?at)
								
								(clear ?toTO)
								(at ?t ?to)
								(not (closed ?to))
								(moving ?p ?dir)
								(or (= ?dir left) (= ?dir right))
								
								(ground green ?under)
							)
			:effect			(and
								(not (at ?p ?at))
								(clear ?at)
								(at ?p ?to)
								(not (at ?t ?to))
								(at ?t ?toTo)
								(not (clear ?toTo))
								(and
									(not (moving ?p left))
									(not (moving ?p right))
								)
								;;start falling
								(when (and 
										(clear ?underTo)
										(not (closed ?underTo))
									)
									(falling ?t)
								)
								(increase (total-cost) 1)
							)
	)							
	(:action slide 
	
			:parameters  (?t - thing ?at ?to ?under ?underTo - location ?dir - direction)
			:precondition	(and
								(relativ-dir ?at ?under down)
								(relativ-dir ?at ?to ?dir)
								(relativ-dir ?to ?underTo down)
								(at ?t ?at)
								(not (clear ?under))
								(clear ?to)
								(not (closed ?to))
								(not (exists (?p - player) (= ?p ?t)))
								
								(moving ?t ?dir)
								(or (= ?dir left) (= ?dir right))
								
								(or 
									(ground green ?under)
									(exists (?r - robot) (= ?r ?t))
								)
								
								
							)
			:effect			(and
								(not (at ?t ?at))
								(clear ?at)
								(at ?t ?to)
								(not (clear ?to))
								
								;;start falling
								(when (and 
										(clear ?underTo)
										(not (closed ?underTo))
									)
									(falling ?t)
								)
							)
	)
	(:action slideStop 
	
			:parameters  (?t - thing ?at ?under ?to - location ?dir - direction)
			:precondition	(and
								(relativ-dir ?at ?under down)
								(relativ-dir ?at ?to ?dir)
								(at ?t ?at)
		
								(moving ?t ?dir)
								(or (= ?dir left) (= ?dir right))
								(not (clear ?under))
								(or 
									(and 
										(not (ground green ?under))
										(not (exists (?r - robot) (= ?r ?t)))
									)
									(not (clear ?to))
								 	(closed ?to)
								)
								
								;check for slide hit player
								(not (exists (?p - player ?toTo - location)
										(and
											(= ?p ?t)
											(relativ-dir ?to ?toTo ?dir)
											(clear ?toTO)
										)
									)			
								)
							)
			:effect			(and
								(not (moving ?t left))
								(not (moving ?t right))
							)
	)
	
	(:action boarder 
	
			:parameters  (?t - thing ?at - location)
			:precondition	(and
								(at ?t ?at)
								
								(boarder ?at)
							)
			:effect			(and
								(not (moving ?t left))
								(not (moving ?t right))
								(not (at ?t ?at))
								(clear ?at)
								(not (falling ?t))
							)
	)

	
	(:action destroyStone 
	
		:parameters  (?t - stone ?at ?under - location)
		:precondition	(and 
							(relativ-dir ?at ?under down)
							(at ?t ?at)
							(or 
								(ground purple ?under)
								(ground blue ?under)
							)
						)

		:effect			(and
							(not (moving ?t left))
							(not (moving ?t right))
							(not (at ?t ?at))
							(clear ?at)
						)
	)
	
	(:action destroyPlayer
	
		:parameters  (?t - player ?at ?under - location)
		:precondition	(and 
							(relativ-dir ?at ?under down)
							(at ?t ?at)
							(or 
								(and (ground blue ?under) (not (wearing blue)))
								(and (ground purple ?under) (not (wearing purple)))
							)
							
						)

		:effect			(and
							(not (moving ?t left))
							(not (moving ?t right))
							(not (at ?t ?at))
							(clear ?at)
						)
	)
	

	(:action destroy
	
		:parameters  (?t - thing ?at ?under - location)
		:precondition	(and 
							(relativ-dir ?at ?under down)
							(at ?t ?at)
							(or
								(exists (?p - player) 
									(and 
										(= ?p ?t)
										(or 
											(and (ground blue ?under) (not (wearing blue)))
											(and (ground purple ?under) (not (wearing purple)))
										)
									)
								)
								(exists (?s - stone) 
									(and 
										(= ?s ?t)
										(or 
											(ground purple ?under)
											(ground blue ?under)
										)
									)
								)
							)
						)

		:effect			(and
							(not (moving ?t left))
							(not (moving ?t right))
							(not (at ?t ?at))
							(clear ?at)
						)
	)
	
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	; pickup
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;	
	
	(:action pickupRemote
		:parameters  (?p - player ?at - location ?r - remote)
		:precondition 	(and
							(at ?p ?at)
							(controller ?r ?at)
						)
		:effect	(and
					(has ?r)
					(not (controller ?r ?at))
				)
	)
	
	(:action pickupBoots
		:parameters  (?p - player ?at - location ?col - colour)
		:precondition 	(and
							(at ?p ?at)
							(boot ?col ?at)
						)
		:effect	(and

					(wearing ?col)
					(when (= ?col green) (and (not (wearing purple)) (not (wearing blue))))
					(when (= ?col blue) (and (not (wearing purple)) (not (wearing green))))
					(when (= ?col purple) (and (not (wearing blue)) (not (wearing green))))
					(not (boot ?col ?at))
					
				)
	)		
)
