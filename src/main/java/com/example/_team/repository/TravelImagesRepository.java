package com.example._team.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example._team.domain.TravelBoard;
import com.example._team.domain.TravelImages;

@Repository
public interface TravelImagesRepository extends JpaRepository<TravelImages, Integer> {

    Optional<TravelImages> findById(Integer id);
    void deleteByTravelIdx(TravelBoard travelIdx);
    List<TravelImages> findByTravelIdx(TravelBoard travelBoard);
    
    @Query(value= "SELECT ti FROM Travel_image ti WHERE ti.travel_board.id = :travel_board", nativeQuery = true)
    List<TravelImages> findImagesByTravelBoardId(@Param("travel_board") Integer travel_board);
    
}
