package com.babygu.flight.flightreservation.service;

import com.babygu.flight.flightreservation.dto.ReservationRequest;
import com.babygu.flight.flightreservation.entities.Flight;
import com.babygu.flight.flightreservation.entities.Passenger;
import com.babygu.flight.flightreservation.entities.Reservation;
import com.babygu.flight.flightreservation.repos.FlightRepository;
import com.babygu.flight.flightreservation.repos.PassengerRepository;
import com.babygu.flight.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest request) {

        //payment details

        Flight flight = flightRepository.findById(request.getFlightId()).get();
        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        return reservationRepository.save(reservation);
    }
}
