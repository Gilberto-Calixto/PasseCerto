package com.dev.PassCerto.services;

import com.dev.PassCerto.domain.attendee.Attendee;
import com.dev.PassCerto.domain.dto.event.EventIdDTO;
import com.dev.PassCerto.domain.dto.event.EventRequestDTO;
import com.dev.PassCerto.domain.dto.event.EventResponseDT;
import com.dev.PassCerto.domain.event.Event;
import com.dev.PassCerto.repositories.AttendeeRepository;
import com.dev.PassCerto.repositories.EventRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventResponseDT getEventDetail(String eventId){
        Event event = this.eventRepository.findById(eventId).orElseThrow(() ->
                new RuntimeException("Event not found with ID:" + eventId));
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventId);

        return new EventResponseDT(event, attendeeList.size());
    }

    public EventIdDTO createEvent(EventRequestDTO eventDTO){
        Event newEvent = new Event();
        newEvent.setTitle(eventDTO.title());
        newEvent.setDetails(eventDTO.details());
        newEvent.setMaximumAttendees(eventDTO.maximumAttendees());
        newEvent.setSlug(this.createSlug(eventDTO.title()));

        this.eventRepository.save(newEvent);

        return  new EventIdDTO(newEvent.getId());
    }

    private  String createSlug(String text){
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return  normalized.replaceAll("\\p{InCOMBINING_DIACRITICAL_MARKS}", "")
                .replaceAll("[^\\w\\s]", "")
                .replaceAll("\\s+", "-")
                .toLowerCase();

    }
}
