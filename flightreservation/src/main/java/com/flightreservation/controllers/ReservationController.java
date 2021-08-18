package com.flightreservation.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.dto.ReservationRequest;
import com.flightreservation.entites.Flight;
import com.flightreservation.entites.Reservation;
import com.flightreservation.repos.FlightRepository;
import com.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
     
    @Autowired
	FlightRepository flightRepository;
    
    @Autowired
    ReservationService reservationService;
	
    @RequestMapping("/showCompleteReservation")	
	public String showCompleteReservation(@RequestParam("flightId")Long flightId,ModelMap modelMap)
	{
		
	    Flight flight = flightRepository.findById(flightId).get(); //flight object store the all details of Given any Id
	    modelMap.addAttribute("flight",flight);  
    	return "completeReservation";
	}
    
    @RequestMapping(value="/completeReservation",method=RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {
	  
    	Reservation reservation= reservationService.bookFlight(request);
    	modelMap.addAttribute("msg","Reservation created successfully"+reservation.getId());
    	
    	return "reservationConfirmation";
    	
    }
}
