package com.rungroop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroop.web.models.Event;

public interface EventRepository extends JpaRepository<Event, Long>{   
}