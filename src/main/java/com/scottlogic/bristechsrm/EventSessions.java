package com.scottlogic.bristechsrm;

import com.scottlogic.bristechsrm.domain.Session;

import java.util.HashSet;
import java.util.Set;

public class EventSessions {
    private Set<EventSession> sessions;

    public EventSessions() {
    }

    public EventSessions(Set<Session> sessions) {
        this.sessions = new HashSet<>();
        for (Session session : sessions) {
            this.sessions.add (new EventSession(session));
        }
    }

    public Set<EventSession> getSessions() {
        return sessions;
    }

    public void setSessions(Set<EventSession> sessions) {
        this.sessions = sessions;
    }
}
