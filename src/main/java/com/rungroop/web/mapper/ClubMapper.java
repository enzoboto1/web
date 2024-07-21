package com.rungroop.web.mapper;

import java.util.Collections;
import java.util.stream.Collectors;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;

public class ClubMapper {
    
    public static ClubDto mapToClubDto(Club club) {
        return ClubDto.builder()
                        .id(club.getId())
                        .title(club.getTitle())
                        .photoUrl(club.getPhotoUrl())
                        .content(club.getContent())
                        .createdOn(club.getCreatedOn())
                        .updatedOn(club.getUpdatedOn())
                        .events(club.getEvents().stream().map((event) -> EventMapper.mapToEventDto(event)).collect(Collectors.toList()))
                        .build();
    }

    public static Club mapToClub(ClubDto clubDto){
        return Club.builder()
                        .id(clubDto.getId())
                        .title(clubDto.getTitle())
                        .photoUrl(clubDto.getPhotoUrl())
                        .content(clubDto.getContent())
                        .createdOn(clubDto.getCreatedOn())
                        .updatedOn(clubDto.getUpdatedOn())
                        .events(clubDto.getEvents() == null ? Collections.emptyList() : clubDto.getEvents().stream().map((eventDto) -> EventMapper.mapToEvent(eventDto)).collect(Collectors.toList()))
                        .build();
    }
}
