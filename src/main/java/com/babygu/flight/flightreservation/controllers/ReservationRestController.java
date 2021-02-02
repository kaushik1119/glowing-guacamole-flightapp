package com.babygu.flight.flightreservation.controllers;

import com.babygu.flight.flightreservation.dto.CheckinReservationRequest;
import com.babygu.flight.flightreservation.entities.Reservation;
import com.babygu.flight.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRestController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("reservations/{id}")
    public Reservation getReservation(@PathVariable("id") Long id){
        return reservationRepository.findById(id).get();
    }
    @RequestMapping("/reservations")
    public Reservation checkinReservation(@RequestBody CheckinReservationRequest request){
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setCheckedIn(request.isCheckedIn());
        reservation.setNumberOfBags(request.getNumberOfBags());
        return reservationRepository.save(reservation);
    }
}
