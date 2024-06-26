package com.rungroop.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.repository.ClubRepository;
import com.rungroop.web.service.ClubService;

@Service
public class ClubServiceImpl implements ClubService{

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto club) {
        return clubRepository.save(mapToClub(club));
    }

    @Override
    public ClubDto findClubById(Long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto club) {
        clubRepository.save(mapToClub(club));
    }

    private ClubDto mapToClubDto(Club club) {
        return ClubDto.builder()
                        .id(club.getId())
                        .title(club.getTitle())
                        .photoUrl(club.getPhotoUrl())
                        .content(club.getContent())
                        .createdOn(club.getCreatedOn())
                        .updatedOn(club.getUpdatedOn())
                        .build();
    }

    private Club mapToClub(ClubDto club){
        return Club.builder()
                        .id(club.getId())
                        .title(club.getTitle())
                        .photoUrl(club.getPhotoUrl())
                        .content(club.getContent())
                        .createdOn(club.getCreatedOn())
                        .updatedOn(club.getUpdatedOn())
                        .build();
    }
    
}
