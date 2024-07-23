package com.rungroop.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.mapper.ClubMapper;
import com.rungroop.web.models.Club;
import com.rungroop.web.repository.ClubRepository;
import com.rungroop.web.repository.UserRepository;
import com.rungroop.web.security.SecurityUtil;
import com.rungroop.web.service.ClubService;

@Service
public class ClubServiceImpl implements ClubService{

    private ClubRepository clubRepository;
    private UserRepository userRepository;

    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> ClubMapper.mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto club) {
        club.setCreatedBy(userRepository.findByUsername(SecurityUtil.getSessionUser().getUsername()));
        return clubRepository.save(ClubMapper.mapToClub(club));
    }

    @Override
    public ClubDto findClubById(Long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return ClubMapper.mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto club) {
        club.setCreatedBy(userRepository.findByUsername(SecurityUtil.getSessionUser().getUsername()));
        clubRepository.save(ClubMapper.mapToClub(club));
    }

    @Override
    public void removeClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> ClubMapper.mapToClubDto(club)).collect(Collectors.toList());
    }    
    
}