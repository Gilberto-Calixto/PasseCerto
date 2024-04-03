package com.dev.PassCerto.domain.dto.event;

import com.dev.PassCerto.domain.event.Event;

public class EventResponseDT {
    EventDetailDTO event;

    public EventResponseDT(Event event, Integer numberOfattendees){
        this.event = new EventDetailDTO(
                event.getId(),
                event.getTitle(),
                event.getDetails(),
                event.getSlug(),
                event.getMaximumAttendees(),
                numberOfattendees
        );
    }
}
