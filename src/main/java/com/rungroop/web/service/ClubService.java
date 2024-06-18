package com.rungroop.web.service;

import java.util.List;
import com.rungroop.web.dto.ClubDto;

public interface ClubService {
    public List<ClubDto> findAllClubs();
}
