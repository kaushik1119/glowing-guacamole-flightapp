package com.babygu.flight.flightreservation.repos;

import com.babygu.flight.flightreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
