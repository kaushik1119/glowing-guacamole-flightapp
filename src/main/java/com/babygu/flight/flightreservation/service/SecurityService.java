package com.babygu.flight.flightreservation.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

    boolean login(String userName, String password);
}
