package com.rungroop.web.service;

import com.rungroop.web.dto.EventDto;

public interface EventService {
    public void createEvent(long clubId, EventDto eventDto);
}
