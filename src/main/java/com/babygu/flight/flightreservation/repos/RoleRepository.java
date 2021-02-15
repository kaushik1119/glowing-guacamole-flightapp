package com.babygu.flight.flightreservation.repos;

import com.babygu.flight.flightreservation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
