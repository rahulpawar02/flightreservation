package com.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.dto.ReservationRequest;
import com.flightreservation.entites.Flight;
import com.flightreservation.entites.Passenger;
import com.flightreservation.entites.Reservation;
import com.flightreservation.repos.FlightRepository;
import com.flightreservation.repos.PassengerRepository;
import com.flightreservation.repos.ReservationRepository;
import com.flightreservation.util.EmailUtil;
import com.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	    @Autowired
	    FlightRepository flightRepository;

		@Autowired
		PassengerRepository passengerRepository;

		@Autowired
        ReservationRepository reservationRepository;
		
		@Autowired
		PDFGenerator pdfGenerator;
	    
		@Autowired
		EmailUtil emailUtil;
		
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
	 
		//Make Payment

		Long flightId=request.getFlightId();
		Flight flight=flightRepository.findById(flightId).get();

		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
        Passenger savedPassenger=passengerRepository.save(passenger);
   
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		Reservation savedReservation = reservationRepository.save(reservation);
        
		String filepath = "/home/rahul/Documents/Reservation System Project/reservation"+ savedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(savedReservation,filepath);
		
		emailUtil.sendItinerary(passenger.getEmail(),filepath);
		return savedReservation;

	}

}
