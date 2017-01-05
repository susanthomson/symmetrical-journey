package com.scottlogic.bristechsrm.dao;

import com.scottlogic.bristechsrm.domain.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long>{
}