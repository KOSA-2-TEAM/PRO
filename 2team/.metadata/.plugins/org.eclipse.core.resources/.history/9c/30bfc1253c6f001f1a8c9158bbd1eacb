package com.example._team.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example._team.domain.Theme;
import com.example._team.domain.TravelBoard;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {
	
    Optional<Theme> findById(Integer id);
    void deleteByTravelIdx(TravelBoard TravelIdx);
    List<Theme> findByTravelIdx(TravelBoard travelBoard);
    
}
