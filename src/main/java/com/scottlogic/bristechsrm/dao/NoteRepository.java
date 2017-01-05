package com.scottlogic.bristechsrm.dao;

import com.scottlogic.bristechsrm.domain.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long>{
}
