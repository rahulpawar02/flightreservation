package com.flightreservation.services;

import com.flightreservation.dto.ReservationRequest;
import com.flightreservation.entites.Reservation;

public interface ReservationService {

public Reservation bookFlight(ReservationRequest request);

}
