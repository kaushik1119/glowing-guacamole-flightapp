package com.babygu.flight.flightreservation.controllers;

import com.babygu.flight.flightreservation.entities.Flight;
import com.babygu.flight.flightreservation.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping(value = "findFlights",method = RequestMethod.POST)
    public String findFlights(@RequestParam("from")String from,@RequestParam("to")String to,
                              @RequestParam("date") @DateTimeFormat(pattern = "mm-dd-yyyy") Date date,
                                ModelMap map){

    List<Flight> flights = flightRepository.findFlights(from,to,date);
    List<Flight> flights1 = flightRepository.findFlightsByDepartureCityAndAndArrivalCityAndDateOfDeparture(from, to, date);
    if(flights.equals(flights1)){
        System.out.println("Both are equal..........................");
    }
    map.addAttribute("flights",flights);

        return "displayFlights";
    }
}
