package com.scottlogic.bristechsrm.service;

import com.scottlogic.bristechsrm.domain.Event;

public interface EventService {
    Iterable<Event> getEvents();
    Event getEvent(final Long id);
    Event add(final Event event);
}