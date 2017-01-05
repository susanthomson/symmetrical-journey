package com.scottlogic.bristechsrm.service;


import com.scottlogic.bristechsrm.PatchOp;
import com.scottlogic.bristechsrm.dao.EventRepository;
import com.scottlogic.bristechsrm.dao.SessionRepository;
import com.scottlogic.bristechsrm.domain.Event;
import com.scottlogic.bristechsrm.domain.Session;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final EventRepository eventRepository;

    public SessionServiceImpl(SessionRepository sessionRepository, EventRepository eventRepository) {
        this.sessionRepository = sessionRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Iterable<Session> getSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public Session getSession(final Long id) {
        return sessionRepository.findOne(id);
    }

    @Override
    public Session add(final Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public int update(final Long id, final PatchOp op) {
        Session session = sessionRepository.findOne(id);
        String path = op.getPath();
        switch (path) {
            case "eventId":
                if (op.getValue() == null) {
                    session.setEvent(null);
                    sessionRepository.save(session);
                } else if (eventRepository.exists(Long.parseLong(op.getValue()))) {
                    session.setEvent(eventRepository.findOne(Long.parseLong(op.getValue())));
                    sessionRepository.save(session);
                } else {
                    throw new IllegalArgumentException("bad eventId");
                }
                break;
            case "description":
                session.setDescription(op.getValue());
                sessionRepository.save(session);
                break;
            case "title":
                session.setTitle(op.getValue());
                sessionRepository.save(session);
                break;
            default:
                throw new IllegalArgumentException("can't patch this");
        }
        return 1;
    }
}
