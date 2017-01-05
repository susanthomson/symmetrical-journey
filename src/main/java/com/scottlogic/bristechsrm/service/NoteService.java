package com.scottlogic.bristechsrm.service;


import com.scottlogic.bristechsrm.NewNoteData;
import com.scottlogic.bristechsrm.PatchOp;
import com.scottlogic.bristechsrm.domain.Note;

public interface NoteService {
    Note add(final Note note);
    int update(final Long id, final PatchOp op);
}
