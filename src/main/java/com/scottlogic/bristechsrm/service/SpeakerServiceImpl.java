package com.scottlogic.bristechsrm.service;


import com.scottlogic.bristechsrm.PatchOp;
import com.scottlogic.bristechsrm.dao.SpeakerRepository;
import com.scottlogic.bristechsrm.domain.Speaker;
import org.springframework.stereotype.Service;

@Service
public class SpeakerServiceImpl implements SpeakerService {
    private final SpeakerRepository speakerRepository;

    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @Override
    public Iterable<Speaker> getSpeakers() {
        return speakerRepository.findAll();
    }

    @Override
    public Speaker add(final Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    @Override
    public int update(final Long id, final PatchOp op) {
        Speaker speaker = speakerRepository.findOne(id);
        String path = op.getPath();
        switch (path) {
            case "forename":
                speaker.setForename(op.getValue());
                speakerRepository.save(speaker);
                break;
            case "surname":
                speaker.setSurname(op.getValue());
                speakerRepository.save(speaker);
                break;
            case "bio":
                speaker.setBio(op.getValue());
                speakerRepository.save(speaker);
                break;
            default:
                throw new IllegalArgumentException("can't patch this");
        }
        return 1;
    }
}