package com.babygu.flight.flightreservation.controllers;

import com.babygu.flight.flightreservation.dto.ReservationRequest;
import com.babygu.flight.flightreservation.entities.Flight;
import com.babygu.flight.flightreservation.entities.Reservation;
import com.babygu.flight.flightreservation.repos.FlightRepository;
import com.babygu.flight.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showComplete(@RequestParam("flightId") Long flightId, ModelMap modelMap){
        Optional<Flight> flight = flightRepository.findById(flightId);
        modelMap.addAttribute("flight",flight.get());
        return "displayReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(@RequestParam("flightId") Long flightId,ReservationRequest request,ModelMap modelMap){
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg","Reservation success with id: " + reservation.getId());
        return "reservationConfirmation";
    }
}
