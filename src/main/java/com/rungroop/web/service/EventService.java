package com.rungroop.web.service;

import java.util.List;

import com.rungroop.web.dto.EventDto;

public interface EventService {
    public void createEvent(long clubId, EventDto eventDto);
    public List<EventDto> findAllClubs();
}
