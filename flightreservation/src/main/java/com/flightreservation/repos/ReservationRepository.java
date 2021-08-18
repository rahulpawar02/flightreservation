package com.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.entites.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
