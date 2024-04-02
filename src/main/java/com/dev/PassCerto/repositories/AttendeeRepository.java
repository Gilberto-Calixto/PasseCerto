package com.dev.PassCerto.repositories;

import com.dev.PassCerto.domain.attendee.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, String> {

}
