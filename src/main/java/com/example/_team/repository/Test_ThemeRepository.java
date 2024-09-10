package com.example._team.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example._team.domain.Theme;
import com.example._team.domain.TravelBoard;

@Repository
public interface Test_ThemeRepository extends JpaRepository<Theme, Integer> {

    Optional<Theme> findById(Integer id);
    void deleteByTravelIdx(TravelBoard TravelIdx);
    List<Theme> findByTravelIdx(TravelBoard travelBoard);
//    List<Theme> saveAll(List<Theme> themes);  // 올바른 타입

//    List<Theme> findByTravelIdx(TravelBoard travelBoard);
//    
//    @Query("SELECT t FROM Theme t WHERE t.travelBoard.id = :travelBoardId")
//    List<Theme> findThemesByTravelBoardId(@Param("travelBoardId") Integer travelBoardId);
}
