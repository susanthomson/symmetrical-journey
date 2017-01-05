package com.scottlogic.bristechsrm.service;


import com.scottlogic.bristechsrm.dao.EventRepository;
import com.scottlogic.bristechsrm.domain.Event;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(final Long id) {
        return eventRepository.findOne(id);
    }

    @Override
    public Event add(final Event event) {
        return eventRepository.save(event);
    }
}