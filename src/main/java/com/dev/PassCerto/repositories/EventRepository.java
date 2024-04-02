package com.dev.PassCerto.repositories;

import com.dev.PassCerto.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {

}
