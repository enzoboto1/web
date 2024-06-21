package com.rungroop.web.service;

import java.util.List;
import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;

public interface ClubService {
    public List<ClubDto> findAllClubs();
    public Club saveClub(Club club); 
}
