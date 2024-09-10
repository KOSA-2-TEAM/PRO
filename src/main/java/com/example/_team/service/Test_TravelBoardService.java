package com.example._team.service;

import java.util.List;
import java.util.Optional;

import com.example._team.dto.TravelBoardRequestsDto;
import com.example._team.dto.TravelBoardResponseDto;

public interface Test_TravelBoardService {
    TravelBoardResponseDto createTravelBoard(TravelBoardRequestsDto requestDto);
    TravelBoardResponseDto updateTravelBoard(Integer id, TravelBoardRequestsDto requestDto);
    void deleteTravelBoard(Integer id);
    TravelBoardResponseDto getTravelBoard(Integer id);
    List<TravelBoardResponseDto> getAllTravelBoards(); // 추가된 메서드
}



// 22222
//package com.example._team.service;
//
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//
//import java.util.List;
//
//public interface TravelBoardService {
//    void createTravelBoard(TravelBoardRequestsDto dto, String userEmail);
//    void updateTravelBoard(Integer travelIdx, TravelBoardRequestsDto dto);
//    void deleteTravelBoardByEmail(String email);
//    List<TravelBoardResponseDto> getTravelBoardsByEmail(String email);
// // 유저의 모든 여행 보드 목록을 조회하는 메서드
//    List<TravelBoardResponseDto> getAllTravelBoards();
//}



// 11111
//package com.example._team.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example._team.domain.TravelBoard;
//import com.example._team.dto.SuccessResponseDto;
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.repository.TravelBoardRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class TravelBoardService {
//
//    private final TravelBoardRepository travelBoardRepository;
//
//    // 모든 여행 보드를 조회하고 최신순으로 정렬
//    public List<TravelBoardResponseDto> getPosts() {
//        return travelBoardRepository.findAllByOrderByCreatedAtDesc().stream()
//            .map(TravelBoardResponseDto::new)
//            .toList();
//    }
//
//    // 새로운 여행 보드를 생성하고 응답 DTO로 변환
//    public TravelBoardResponseDto createPost(TravelBoardRequestsDto requestsDto) {
//        TravelBoard travelboard = new TravelBoard();
//        travelboard.setTitle(requestsDto.getTitle());
//        travelboard.setContent(requestsDto.getContent());
//        travelboard.setRegion(requestsDto.getRegion());
//        travelboard.setStatDate(requestsDto.getStatDate());
//        travelboard.setEndDate(requestsDto.getEndDate());
//        travelboard.setIsPublic(requestsDto.getIsPublic());
//        travelboard.setUserIdx(requestsDto.getUserIdx());
//        // 이메일은 필요에 따라 저장 또는 사용
//
//        travelBoardRepository.save(travelboard);
//        return new TravelBoardResponseDto(travelboard);
//    }
//
//    // 이메일을 통해 해당 사용자가 작성한 여행 보드를 조회
//    @Transactional
//    public List<TravelBoardResponseDto> getPostsByEmail(String email) {
//        List<TravelBoard> travelBoards = travelBoardRepository.findByUserIdxEmail(email);
//        if (travelBoards.isEmpty()) {
//            throw new IllegalArgumentException("해당 이메일로 등록된 여행 보드가 없습니다.");
//        }
//        return travelBoards.stream().map(TravelBoardResponseDto::new).toList();
//    }
//
//    // 특정 여행 보드를 조회
//    @Transactional
//    public TravelBoardResponseDto getPost(Integer travelIdx) {
//        return travelBoardRepository.findById(travelIdx)
//            .map(TravelBoardResponseDto::new)
//            .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
//    }
//
//    // 특정 여행 보드를 업데이트
//    @Transactional
//    public TravelBoardResponseDto updatePost(Integer travelIdx, TravelBoardRequestsDto requestsDto) throws Exception {
//        TravelBoard travelboard = travelBoardRepository.findById(travelIdx)
//            .orElseThrow(() -> new IllegalAccessError("아이디가 존재하지 않습니다."));
//        travelboard.setTitle(requestsDto.getTitle());
//        travelboard.setContent(requestsDto.getContent());
//        travelboard.setRegion(requestsDto.getRegion());
//        travelboard.setStatDate(requestsDto.getStatDate());
//        travelboard.setEndDate(requestsDto.getEndDate());
//        travelboard.setIsPublic(requestsDto.getIsPublic());
//        // 필요한 필드를 업데이트
//        travelBoardRepository.save(travelboard);
//        return new TravelBoardResponseDto(travelboard);
//        
////     // 요청 DTO의 필드가 null이거나 기본값이 아닌 경우에만 업데이트
////        if (requestsDto.getTitle() != null) {
////            travelboard.setTitle(requestsDto.getTitle());
////        }
////        if (requestsDto.getRegion() != null) {
////            travelboard.setRegion(requestsDto.getRegion());
////        }
////        if (requestsDto.getStatDate() != null) {
////            travelboard.setStatDate(requestsDto.getStatDate());
////        }
////        if (requestsDto.getEndDate() != null) {
////            travelboard.setEndDate(requestsDto.getEndDate());
////        }
////        if (requestsDto.getContent() != null) {
////            travelboard.setContent(requestsDto.getContent());
////        }
////        if (requestsDto.getIsPublic() != null) {
////            travelboard.setIsPublic(requestsDto.getIsPublic());
////        }
////
////        // 업데이트된 여행 보드를 저장
////        travelBoardRepository.save(travelboard);
////        return new TravelBoardResponseDto(travelboard);
//    }
//
//    // 이메일을 통해 해당 사용자가 작성한 여행 보드를 삭제
//    @Transactional
//    public SuccessResponseDto deletePostByEmail(String email) throws Exception {
//        List<TravelBoard> travelBoards = travelBoardRepository.findByUserIdxEmail(email);
//        if (travelBoards.isEmpty()) {
//            throw new IllegalArgumentException("해당 이메일로 등록된 여행 보드가 없습니다.");
//        }
//        travelBoardRepository.deleteAll(travelBoards);
//        return new SuccessResponseDto(true);
//    }
//}




//package com.example._team.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example._team.domain.TravelBoard;
//import com.example._team.dto.SuccessResponseDto;
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.repository.TravelBoardRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class TravelBoardService {
//    
//    private final TravelBoardRepository travelBoardRepository;
//
//    // 모든 여행 보드를 조회하고 최신순으로 정렬
//    public List<TravelBoardResponseDto> getPosts() {
//        return travelBoardRepository.findAllByOrderByCreatedAtDesc().stream()
//            .map(TravelBoardResponseDto::new)
//            .toList();
//    }
//
//    // 새로운 여행 보드를 생성하고 응답 DTO로 변환
//    public TravelBoardResponseDto createPost(TravelBoardRequestsDto requestsDto) {
//        TravelBoard travelboard = new TravelBoard();
//        travelboard.setTitle(requestsDto.getTitle());
//        travelboard.setContent(requestsDto.getContent());
//        travelboard.setRegion(requestsDto.getRegion());
//        travelboard.setStatDate(requestsDto.getStatDate());
//        travelboard.setEndDate(requestsDto.getEndDate());
//        travelboard.setIsPublic(requestsDto.getIsPublic());
//        travelboard.setUserIdx(requestsDto.getUserIdx());
//        // 이메일은 필요에 따라 저장 또는 사용
//
//        travelBoardRepository.save(travelboard);
//        return new TravelBoardResponseDto(travelboard);
//    }
//
//    // 이메일을 통해 해당 사용자가 작성한 여행 보드를 조회
//    @Transactional
//    public List<TravelBoardResponseDto> getPostsByEmail(String email) {
//        List<TravelBoard> travelBoards = travelBoardRepository.findByUserIdxEmail(email);
//        if (travelBoards.isEmpty()) {
//            throw new IllegalArgumentException("해당 이메일로 등록된 여행 보드가 없습니다.");
//        }
//        return travelBoards.stream().map(TravelBoardResponseDto::new).toList();
//    }
//
//    // 특정 여행 보드를 조회
//    @Transactional
//    public TravelBoardResponseDto getPost(Integer travelIdx) {
//        return travelBoardRepository.findById(travelIdx)
//            .map(TravelBoardResponseDto::new)
//            .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
//    }
//
//    // 특정 여행 보드를 업데이트
//    @Transactional
//    public TravelBoardResponseDto updatePost(Integer travelIdx, TravelBoardRequestsDto requestsDto) throws Exception {
//        TravelBoard travelboard = travelBoardRepository.findById(travelIdx)
//            .orElseThrow(() -> new IllegalAccessError("아이디가 존재하지 않습니다."));
//        travelboard.setTitle(requestsDto.getTitle());
//        travelboard.setContent(requestsDto.getContent());
//        // 필요에 따라 다른 필드 업데이트
//        travelBoardRepository.save(travelboard);
//        return new TravelBoardResponseDto(travelboard);    
//    }
//
//    // 특정 여행 보드를 삭제
//    @Transactional
//    public SuccessResponseDto deletePost(Integer travelIdx, TravelBoardRequestsDto requestsDto) throws Exception {
//        TravelBoard travelboard = travelBoardRepository.findById(travelIdx)
//            .orElseThrow(() -> new IllegalAccessError("아이디가 존재하지 않습니다."));
//        travelBoardRepository.delete(travelboard);
//        return new SuccessResponseDto(true);
//    }
//}




//package com.example._team.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example._team.domain.TravelBoard;
//import com.example._team.dto.SuccessResponseDto;
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.repository.TravelBoardRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class TravelBoardService {
//    
//    private final TravelBoardRepository travelBoardRepository;
//
//    // 모든 여행 보드를 조회하고 최신순으로 정렬
//    public List<TravelBoardResponseDto> getPosts() {
//        return travelBoardRepository.findAllByOrderByCreatedAtDesc().stream()
//            .map(TravelBoardResponseDto::new)
//            .toList();
//    }
//
//    // 새로운 여행 보드를 생성하고 응답 DTO로 변환
//    public TravelBoardResponseDto createPost(TravelBoardRequestsDto requestsDto) {
//        TravelBoard travelboard = new TravelBoard();
//        travelboard.setTitle(requestsDto.getTitle());
//        travelboard.setContent(requestsDto.getContent());
//        travelboard.setRegion(requestsDto.getRegion());
//        travelboard.setStatDate(requestsDto.getStatDate());
//        travelboard.setEndDate(requestsDto.getEndDate());
//        travelboard.setIsPublic(requestsDto.getIsPublic());
//        travelboard.setUserIdx(requestsDto.getUserIdx());
//        
//        travelBoardRepository.save(travelboard);
//        return new TravelBoardResponseDto(travelboard);
//    }
//
//    // 이메일을 통해 해당 사용자가 작성한 여행 보드를 조회
//    @Transactional
//    public List<TravelBoardResponseDto> getPostsByEmail(String email) {
//        List<TravelBoard> travelBoards = travelBoardRepository.findByUserIdxEmail(email);
//        if (travelBoards.isEmpty()) {
//            throw new IllegalArgumentException("해당 이메일로 등록된 여행 보드가 없습니다.");
//        }
//        return travelBoards.stream().map(TravelBoardResponseDto::new).toList();
//    }
//
//    // 특정 여행 보드를 조회
//    @Transactional
//    public TravelBoardResponseDto getPost(Integer travelIdx) {
//        return travelBoardRepository.findById(travelIdx)
//            .map(TravelBoardResponseDto::new)
//            .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
//    }
//
//    // 특정 여행 보드를 업데이트
//    @Transactional
//    public TravelBoardResponseDto updatePost(Integer travelIdx, TravelBoardRequestsDto requestsDto) throws Exception {
//        TravelBoard travelboard = travelBoardRepository.findById(travelIdx)
//            .orElseThrow(() -> new IllegalAccessError("아이디가 존재하지 않습니다."));
//        travelboard.setTitle(requestsDto.getTitle());
//        travelboard.setContent(requestsDto.getContent());
//        // 필요에 따라 다른 필드 업데이트
//        travelBoardRepository.save(travelboard);
//        return new TravelBoardResponseDto(travelboard);    
//    }
//
//    // 특정 여행 보드를 삭제
//    @Transactional
//    public SuccessResponseDto deletePost(Integer travelIdx, TravelBoardRequestsDto requestsDto) throws Exception {
//        TravelBoard travelboard = travelBoardRepository.findById(travelIdx)
//            .orElseThrow(() -> new IllegalAccessError("아이디가 존재하지 않습니다."));
//        travelBoardRepository.delete(travelboard);
//        return new SuccessResponseDto(true);
//    }
//}




//package com.example._team.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example._team.domain.TravelBoard;
//import com.example._team.dto.SuccessResponseDto;
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.repository.TravelBoardRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class TravelBoardService {
//	
//	private final TravelBoardRepository travelBoardRepository;
//	
//	
//	
//	public List<TravelBoardResponseDto> getPosts() {
//		return travelBoardRepository.findAllByOrderByCreatedAtDesc().stream().map(TravelBoardResponseDto::new).toList();
//	}
//	
////	public TravelBoardResponseDto createPost(TravelBoardRequestsDto requestsDto) {
////		TravelBoard travelboard = new TravelBoard();
////		travelboard.setContent(requestsDto.getContent());
////		
////		travelBoardRepository.save(travelboard);
////		return new TravelBoardResponseDto(travelboard);
////	}
//	public TravelBoardResponseDto createPost(TravelBoardRequestsDto requestsDto) {
//	    TravelBoard travelboard = new TravelBoard();
//	    travelboard.setTitle(requestsDto.getTitle());
//	    travelboard.setContent(requestsDto.getContent());
//	    travelboard.setRegion(requestsDto.getRegion());
//	    travelboard.setStatDate(requestsDto.getStatDate());
//	    travelboard.setEndDate(requestsDto.getEndDate());
//	    travelboard.setIsPublic(requestsDto.getIsPublic());
//	    travelboard.setUserIdx(requestsDto.getUserIdx());
//	    
//	    travelBoardRepository.save(travelboard);
//	    return new TravelBoardResponseDto(travelboard);
//	}
//	
//	
////	@Transactional
////	public TravelBoardResponseDto getPost(Integer userIdx) {
////		return travelBoardRepository.findById(userIdx).map(TravelBoardResponseDto::new).orElseThrow(
////				() -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
////		);
////	}
////	
////	@Transactional
////	public TravelBoardResponseDto updatePost(Integer userIdx, TravelBoardRequestsDto requestsDto) throws Exception {
////		TravelBoard travelboard = travelBoardRepository.findById(userIdx).orElseThrow(
////				() -> new IllegalAccessError("아이디가 존재하지 않습니다.")
////		);
//////		if (!requestsDto.get().equals(users.get))
////		
//////		travelboard.update(requestsDto);
////		return new TravelBoardResponseDto(travelboard);	
////	}
////	
////	@Transactional
////	public SuccessResponseDto deletePost(Integer userIdx, TravelBoardRequestsDto requestsDto) throws Exception {
////		TravelBoard travelboard = travelBoardRepository.findById(userIdx).orElseThrow(
////				() -> new IllegalAccessError("아이디가 존재하지 않습니다.")
////		);
////		
////		return new SuccessResponseDto(true);
////	}
//	
//	@Transactional
//	public TravelBoardResponseDto getPost(Integer travelIdx) {
//	    return travelBoardRepository.findById(travelIdx).map(TravelBoardResponseDto::new).orElseThrow(
//	            () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//	    );
//	}
//
//	@Transactional
//	public TravelBoardResponseDto updatePost(Integer travelIdx, TravelBoardRequestsDto requestsDto) throws Exception {
//	    TravelBoard travelboard = travelBoardRepository.findById(travelIdx).orElseThrow(
//	            () -> new IllegalAccessError("아이디가 존재하지 않습니다.")
//	    );
//	    travelboard.setTitle(requestsDto.getTitle());
//	    travelboard.setContent(requestsDto.getContent());
//	    // 필요한 필드를 업데이트
//	    travelBoardRepository.save(travelboard);
//	    return new TravelBoardResponseDto(travelboard);    
//	}
//
//	@Transactional
//	public SuccessResponseDto deletePost(Integer travelIdx, TravelBoardRequestsDto requestsDto) throws Exception {
//	    TravelBoard travelboard = travelBoardRepository.findById(travelIdx).orElseThrow(
//	            () -> new IllegalAccessError("아이디가 존재하지 않습니다.")
//	    );
//	    travelBoardRepository.delete(travelboard);
//	    return new SuccessResponseDto(true);
//	}
//
//
//}
