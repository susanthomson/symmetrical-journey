package com.scottlogic.bristechsrm;

public class NewNoteData {

    private long sessionId;
    private String note;

    public NewNoteData() {
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
