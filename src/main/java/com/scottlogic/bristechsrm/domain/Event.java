package com.scottlogic.bristechsrm.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;

    private String name;
    private String date;
    private String meetupEvent;

    @OneToMany(mappedBy="event")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Session> sessionIds;

    @OneToMany(mappedBy="event")
    @JsonIgnore
    private Set<Session> sessions;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return name;
    }

    public void setDescription(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMeetupEvent() {
        return meetupEvent;
    }

    public void setMeetupEvent(String meetupEvent) {
        this.meetupEvent = meetupEvent;
    }

    public Set<Session> getSessionIds() {
        return sessionIds;
    }

    public void setSessionIds(Set<Session> sessionIds) {
        this.sessionIds = sessionIds;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }
}
