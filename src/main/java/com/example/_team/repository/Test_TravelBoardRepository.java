package com.example._team.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example._team.domain.Theme;
import com.example._team.domain.TravelBoard;
import com.example._team.domain.TravelImages;

@Repository
public interface Test_TravelBoardRepository extends JpaRepository<TravelBoard, Integer> {
    // 추가적인 쿼리 메서드 정의가 필요하다면 여기에 추가
	Optional<TravelBoard> findByTravelIdx(Integer travelIdx);
//	Optional<TravelBoard> findByIdWithDetails(@Param("id") Integer id);
	@Query("SELECT tb FROM TravelBoard tb WHERE tb.id = :id")
    Optional<TravelBoard> findById(@Param("id") Integer id);
	
	 @Query(value = "SELECT * FROM (SELECT t.* FROM travel_board t ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1", nativeQuery = true)
	 TravelBoard findRandomTravelBoard(); // 랜덤

    
}


// 22222
//package com.example._team.repository;
//
//import com.example._team.domain.TravelBoard;
//import com.example._team.domain.Users;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;
//
//public interface TravelBoardRepository extends JpaRepository<TravelBoard, Integer> {
//    List<TravelBoard> findByUserIdx_Email(String email); // 이메일로 여행 보드 조회
//    void deleteByUserIdx_Email(String email); // 이메일로 여행 보드 삭제
//}



// 11111
//package com.example._team.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.example._team.domain.TravelBoard;
//
//public interface TravelBoardRepository extends JpaRepository<TravelBoard, Integer> {
//	List<TravelBoard> findAllByOrderByCreatedAtDesc();
//	
//	// 이메일을 통해 해당 사용자가 작성한 여행 보드를 조회
//    List<TravelBoard> findByUserIdxEmail(String email);
//}
