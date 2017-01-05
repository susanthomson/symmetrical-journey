package com.scottlogic.bristechsrm.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="speaker")
    private Speaker speaker;

    @ManyToOne
    @JoinColumn(name="admin")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;

    @OneToMany(mappedBy="session")
    @JsonIgnore
    private Set<Note> notes;

    public Session() {
    }

    public Session(String title, String description, Speaker speaker) {
        this.title = title;
        this.description = description;
        this.speaker = speaker;
    }

    public Session(String title, String description, Speaker speaker, Admin admin) {
        this.title = title;
        this.description = description;
        this.speaker = speaker;
        this.admin = admin;
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

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
