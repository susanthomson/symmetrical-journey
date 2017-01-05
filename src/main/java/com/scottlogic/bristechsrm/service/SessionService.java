package com.scottlogic.bristechsrm.service;

import com.scottlogic.bristechsrm.PatchOp;
import com.scottlogic.bristechsrm.domain.Session;

public interface SessionService {
    Iterable<Session> getSessions();
    Session getSession(final Long id);
    Session add(final Session session);
    int update(final Long id, final PatchOp op);
}
