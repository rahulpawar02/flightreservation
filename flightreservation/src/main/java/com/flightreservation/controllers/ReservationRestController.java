package com.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightreservation.dto.ReservationUpdateRequest;
import com.flightreservation.entites.Reservation;
import com.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;
    
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id)
	{  
		Reservation reservation = reservationRepository.findById(id).get();
		return reservation;
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(ReservationUpdateRequest request) {
		
		Reservation reservation =reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckIn());
		Reservation updateReservation=reservationRepository.save(reservation);//line 1  
		return updateReservation;//line 2 
		
		// line 1&2 we can write as => return reservationRepository.save(reservation);	
		
	}
	
}
