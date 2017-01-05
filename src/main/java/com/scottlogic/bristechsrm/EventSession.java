package com.scottlogic.bristechsrm;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.scottlogic.bristechsrm.domain.Session;

public class EventSession {

    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;
    private String title;
    private String description;
    private String speakerForename;
    private String speakerSurname;
    private String speakerBio;
    private String speakerImageUri;

    public EventSession(Session session) {
        this.id = session.getId();
        this.title = session.getTitle();
        this.description = session.getDescription();
        this.speakerForename = session.getSpeaker().getForename();
        this.speakerSurname = session.getSpeaker().getSurname();
        this.speakerBio = session.getSpeaker().getBio();
        this.speakerImageUri = session.getSpeaker().getImageUri();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpeakerForename() {
        return speakerForename;
    }

    public void setSpeakerForename(String speakerForename) {
        this.speakerForename = speakerForename;
    }

    public String getSpeakerSurname() {
        return speakerSurname;
    }

    public void setSpeakerSurname(String speakerSurname) {
        this.speakerSurname = speakerSurname;
    }

    public String getSpeakerBio() {
        return speakerBio;
    }

    public void setSpeakerBio(String speakerBio) {
        this.speakerBio = speakerBio;
    }

    public String getSpeakerImageUri() {
        return speakerImageUri;
    }

    public void setSpeakerImageUri(String speakerImageUri) {
        this.speakerImageUri = speakerImageUri;
    }
}
