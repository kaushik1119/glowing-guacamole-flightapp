package com.babygu.flight.flightreservation.service;

import com.babygu.flight.flightreservation.dto.ReservationRequest;
import com.babygu.flight.flightreservation.entities.Reservation;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {

    Reservation bookFlight(ReservationRequest request);
}
