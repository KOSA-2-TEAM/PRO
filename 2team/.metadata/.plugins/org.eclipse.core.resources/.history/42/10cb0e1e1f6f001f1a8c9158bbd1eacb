package com.example._team.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example._team.domain.TravelBoard;

@Repository
public interface TravelBoardRepository extends JpaRepository<TravelBoard, Integer> {

	Optional<TravelBoard> findByTravelIdx(Integer travelIdx);
	
	@Query("SELECT tb FROM TravelBoard tb WHERE tb.id = :id")
    Optional<TravelBoard> findById(@Param("id") Integer id);
	
	@Query(value = "SELECT * FROM (SELECT t.* FROM travel_board t ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1", nativeQuery = true)
	TravelBoard findRandomTravelBoard();
	
}
