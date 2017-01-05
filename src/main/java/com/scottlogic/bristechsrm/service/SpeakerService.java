package com.scottlogic.bristechsrm.service;

import com.scottlogic.bristechsrm.PatchOp;
import com.scottlogic.bristechsrm.domain.Speaker;

public interface SpeakerService {
    Iterable<Speaker> getSpeakers();
    Speaker add(final Speaker speaker);
    int update(final Long id, final PatchOp op);
}
