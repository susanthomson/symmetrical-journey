package com.scottlogic.bristechsrm.web;

import com.scottlogic.bristechsrm.EventSession;
import com.scottlogic.bristechsrm.EventSessions;
import com.scottlogic.bristechsrm.NewNoteData;
import com.scottlogic.bristechsrm.PatchOp;
import com.scottlogic.bristechsrm.domain.*;
import com.scottlogic.bristechsrm.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class Controller {

    private final SessionService sessionService;
    private final SpeakerService speakerService;
    private final AdminService adminService;
    private final EventService eventService;
    private final NoteService noteService;

    public Controller(SessionService sessionService, SpeakerService speakerService, AdminService adminService, EventService eventService, NoteService noteService) {
        this.sessionService = sessionService;
        this.speakerService = speakerService;
        this.adminService = adminService;
        this.eventService = eventService;
        this.noteService = noteService;
    }

// SESSIONS

    @GetMapping(value = "/sessions")
    @ResponseBody
    public Iterable<Session> getSessions(@RequestHeader(value="Authorization") String accessToken) {
        return sessionService.getSessions();
    }

    @GetMapping(value = "/sessions/{sessionId}")
    @ResponseBody
    public Session getSession(@PathVariable("sessionId") Long sessionId) {
        return sessionService.getSession(sessionId);
    }

    @PostMapping(value = "/sessions")
    @ResponseBody
    public Long addSession(@RequestBody final Session session){
        return sessionService.add(session).getId();
    }

    @PatchMapping(value = "/sessions/{sessionId}")
    @ResponseBody
    public int updateSession(@PathVariable("sessionId") Long sessionId, @RequestBody final PatchOp op) {
        return sessionService.update(sessionId, op);
    }

    // SPEAKERS

    @GetMapping(value = "/speakers")
    @ResponseBody
    public Iterable<Speaker> getSpeakers() {
        return speakerService.getSpeakers();
    }

    @PostMapping(value = "/speakers")
    @ResponseBody
    public Long addSpeaker(@RequestBody final Speaker speaker){
        return speakerService.add(speaker).getId();
    }

    @PatchMapping(value = "/speakers/{speakerId}")
    @ResponseBody
    public int updateSpeaker(@PathVariable("speakerId") Long speakerId, @RequestBody final PatchOp op) {
        return speakerService.update(speakerId, op);
    }

    // ADMINS

    @GetMapping(value = "/admins")
    @ResponseBody
    public Iterable<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @PostMapping(value = "/admins")
    @ResponseBody
    public void addAdmins(@RequestBody final Admin admin){
        adminService.add(admin);
    }

    // EVENTS

    @GetMapping(value = "/events")
    @ResponseBody
    public Iterable<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping(value = "/events/{eventId}")
    @ResponseBody
    public EventSessions getEvent(@PathVariable("eventId") Long eventId) {
        Event event = eventService.getEvent(eventId);
        EventSessions  eventSessions = new EventSessions(event.getSessions());
        return eventSessions;
    }

    @PostMapping(value = "/events")
    public Long addEvent(@RequestBody final Event event){
        return eventService.add(event).getId();
    }

    // NOTES

    @GetMapping(value = "/notes")
    @ResponseBody
    public Iterable<Note> getNotes(@RequestParam("sessionId") long sessionId) {
        Session session = sessionService.getSession(sessionId);
        return session.getNotes();
    }

    @PostMapping(value = "/notes")
    @ResponseBody
    public Note addNote(@RequestBody final NewNoteData newNoteData){
        Session session = sessionService.getSession(newNoteData.getSessionId());
        Note note = new Note(session, newNoteData.getNote());
        return noteService.add(note);
    }

    @PatchMapping(value = "/notes/{noteId}")
    @ResponseBody
    public int updateNote(@PathVariable("noteId") Long noteId, @RequestBody final PatchOp op) {
        return noteService.update(noteId, op);
    }
}
