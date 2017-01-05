package com.scottlogic.bristechsrm.service;

import com.scottlogic.bristechsrm.NewNoteData;
import com.scottlogic.bristechsrm.PatchOp;
import com.scottlogic.bristechsrm.dao.NoteRepository;
import com.scottlogic.bristechsrm.domain.Note;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;
    TimeZone tz = TimeZone.getTimeZone("UTC");
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset

    public NoteServiceImpl(NoteRepository noteRepository) {
        df.setTimeZone(tz);
        this.noteRepository = noteRepository;
    }

    @Override
    public Note add(final Note note) {
        String now = df.format(new Date());
        note.setDateAdded(now);
        note.setDateModified(now);
        return noteRepository.save(note);
    }

    @Override
    public int update(final Long id, final PatchOp op) {
        Note note = noteRepository.findOne(id);
        note.setNote(op.getValue());
        String now = df.format(new Date());
        note.setDateModified(now);
        noteRepository.save(note);
        return 1;
    }
}
