package com.rungroop.web.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rungroop.web.models.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByTitle(String url);

    @Query("select c from Club c where c.title like concat('%', :query, '%')")
    public List<Club> searchClubs(String query);
}
