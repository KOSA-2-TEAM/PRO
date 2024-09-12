package com.example._team.repository;

import com.example._team.domain.Theme;
import com.example._team.domain.TravelBoard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    List<Theme> findByTravelIdx(TravelBoard travelBoard);
    void deleteByTravelIdx(TravelBoard TravelIdx);
    
    // 추가함
    @Query("SELECT t.name FROM Theme t")
    List<String> findAllThemes();
}
