package com.babygu.flight.flightreservation.repos;

import com.babygu.flight.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
