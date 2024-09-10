package com.example._team.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example._team.dto.TravelBoardRequestsDto;
import com.example._team.dto.TravelBoardResponseDto;
import com.example._team.exception.DataNotFoundException;
import com.example._team.service.TravelBoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/travelboards")
@RequiredArgsConstructor
public class Test_TravelBoardController {

    private final TravelBoardService travelBoardService;

    @PostMapping
    public TravelBoardResponseDto createTravelBoard(@RequestBody TravelBoardRequestsDto requestDto) {
        return travelBoardService.createTravelBoard(requestDto);
    }

    @PutMapping("/{id}")
    public TravelBoardResponseDto updateTravelBoard(@PathVariable Integer id, @RequestBody TravelBoardRequestsDto requestDto) {
        return travelBoardService.updateTravelBoard(id, requestDto);
    }

//    @DeleteMapping("/{id}")
//    public void deleteTravelBoard(@PathVariable Integer id) {
//        travelBoardService.deleteTravelBoard(id);
//    }
    @DeleteMapping("/{travelIdx}")
    public void deleteTravelBoard(@PathVariable Integer travelIdx) {
        travelBoardService.deleteTravelBoard(travelIdx);
    }


    @GetMapping("/{id}")
    public TravelBoardResponseDto getTravelBoard(@PathVariable Integer id) {
        return travelBoardService.getTravelBoard(id);
//        		.orElseThrow(() -> new DataNotFoundException("TravelBoard not found"));
    }
    
    @GetMapping
    public List<TravelBoardResponseDto> getAllTravelBoards() {
        return travelBoardService.getAllTravelBoards();
    }
}



// 22222
//package com.example._team.controller;
//
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.service.TravelBoardService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/travelboard")
//public class TravelBoardController {
//
//    private final TravelBoardService travelBoardService;
//
//    public TravelBoardController(TravelBoardService travelBoardService) {
//        this.travelBoardService = travelBoardService;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<String> createTravelBoard(@RequestBody TravelBoardRequestsDto dto, @RequestParam String userEmail) {
//        travelBoardService.createTravelBoard(dto, userEmail);
//        return ResponseEntity.ok("Travel board created successfully");
//    }
//
//    @PutMapping("/update/{travelIdx}")
//    public ResponseEntity<String> updateTravelBoard(@PathVariable Integer travelIdx, @RequestBody TravelBoardRequestsDto dto) {
//        travelBoardService.updateTravelBoard(travelIdx, dto);
//        return ResponseEntity.ok("Travel board updated successfully");
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteTravelBoard(@RequestParam String email) {
//        travelBoardService.deleteTravelBoardByEmail(email);
//        return ResponseEntity.ok("Travel board deleted successfully");
//    }
//
//    @GetMapping("/get")
//    public ResponseEntity<List<TravelBoardResponseDto>> getTravelBoards(@RequestParam String email) {
//        List<TravelBoardResponseDto> boards = travelBoardService.getTravelBoardsByEmail(email);
//        return ResponseEntity.ok(boards);
//    }
//    
//    /**
//     * 모든 유저의 여행 보드 목록 조회 API
//     * 
//     * @return 모든 유저의 여행 보드 목록
//     */
//    @GetMapping("/all")
//    public ResponseEntity<List<TravelBoardResponseDto>> getAllTravelBoards() {
//        List<TravelBoardResponseDto> boards = travelBoardService.getAllTravelBoards();
//        return ResponseEntity.ok(boards);
//    }
//}



// 11111
//package com.example._team.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example._team.dto.SuccessResponseDto;
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.service.TravelBoardService;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//public class TravelBoardController {
//
//    private final TravelBoardService travelBoardService;
//
//    // 모든 여행 보드를 조회
//    @GetMapping("/api/posts")
//    public List<TravelBoardResponseDto> getPosts() {
//        return travelBoardService.getPosts();
//    }
//
//    // 새로운 여행 보드를 생성
//    @PostMapping("/api/post")
//    public TravelBoardResponseDto createPost(@RequestBody TravelBoardRequestsDto requestsDto) {
//        return travelBoardService.createPost(requestsDto);
//    }
//
//    // 특정 여행 보드를 조회 (travelIdx를 통해)
//    @GetMapping("/api/post/{travelIdx}")
//    public TravelBoardResponseDto getPost(@PathVariable Integer travelIdx) {
//        return travelBoardService.getPost(travelIdx);
//    }
//
//    // 이메일을 통해 해당 사용자가 작성한 여행 보드를 조회
//    @GetMapping("/api/posts/email/{email}")
//    public List<TravelBoardResponseDto> getPostsByEmail(@PathVariable String email) {
//        return travelBoardService.getPostsByEmail(email);
//    }
//
//    // 특정 여행 보드를 업데이트
//    @PutMapping("/api/post/{travelIdx}")
//    public TravelBoardResponseDto updatePost(@PathVariable Integer travelIdx, @RequestBody TravelBoardRequestsDto requestsDto) throws Exception {
//        return travelBoardService.updatePost(travelIdx, requestsDto);
//    }
//
//    // 이메일을 통해 해당 사용자가 작성한 여행 보드를 삭제
//    @DeleteMapping("/api/posts/email/{email}")
//    public SuccessResponseDto deletePost(@PathVariable String email) throws Exception {
//        return travelBoardService.deletePostByEmail(email);
//    }
//}




//package com.example._team.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example._team.dto.SuccessResponseDto;
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.service.TravelBoardService;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//public class TravelBoardController {
//
//    private final TravelBoardService travelBoardService;
//
//    // 모든 여행 보드를 조회
//    @GetMapping("/api/posts")
//    public List<TravelBoardResponseDto> getPosts() {
//        return travelBoardService.getPosts();
//    }
//
//    // 새로운 여행 보드를 생성
//    @PostMapping("/api/post")
//    public TravelBoardResponseDto createPost(@RequestBody TravelBoardRequestsDto requestsDto) {
//        return travelBoardService.createPost(requestsDto);
//    }
//
//    // 특정 여행 보드를 조회 (travelIdx를 통해)
//    @GetMapping("/api/post/{travelIdx}")
//    public TravelBoardResponseDto getPost(@PathVariable Integer travelIdx) {
//        return travelBoardService.getPost(travelIdx);
//    }
//
//    // 이메일을 통해 해당 사용자가 작성한 여행 보드를 조회
//    @GetMapping("/api/posts/email/{email}")
//    public List<TravelBoardResponseDto> getPostsByEmail(@PathVariable String email) {
//        return travelBoardService.getPostsByEmail(email);
//    }
//
//    // 특정 여행 보드를 업데이트
//    @PutMapping("/api/post/{travelIdx}")
//    public TravelBoardResponseDto updatePost(@PathVariable Integer travelIdx, @RequestBody TravelBoardRequestsDto requestsDto) throws Exception {
//        return travelBoardService.updatePost(travelIdx, requestsDto);
//    }
//
//    // 특정 여행 보드를 삭제
//    @DeleteMapping("/api/post/{travelIdx}")
//    public SuccessResponseDto deletePost(@PathVariable Integer travelIdx, @RequestBody TravelBoardRequestsDto requestsDto) throws Exception {
//        return travelBoardService.deletePost(travelIdx, requestsDto);
//    }
//}




//package com.example._team.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example._team.dto.SuccessResponseDto;
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.service.TravelBoardService;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//public class TravelBoardController {
//
//    private final TravelBoardService travelBoardService;
//    
//    @GetMapping("/api/posts")
//    public List<TravelBoardResponseDto> getPosts() {
//    	return travelBoardService.getPosts();
//    }
//    
//    @PostMapping("/api/post")
//    public TravelBoardResponseDto createPost(@RequestBody TravelBoardRequestsDto requestsDto) {
//    	return travelBoardService.createPost(requestsDto);
//    }
//
////    @GetMapping("/api/post/{id}")
////    public TravelBoardResponseDto getPost(@PathVariable Integer userIdx) {
////    	return travelBoardService.getPost(userIdx);
////    }
//    @GetMapping("/api/post/{travelIdx}")
//    public TravelBoardResponseDto getPost(@PathVariable Integer travelIdx) {
//        return travelBoardService.getPost(travelIdx);
//    }
//    
////    @PutMapping("/api/post/{id}")
////    public TravelBoardResponseDto updatePost(@PathVariable Integer userIdx, @RequestBody TravelBoardRequestsDto requestsDto) throws Exception {
////    	return travelBoardService.updatePost(userIdx, requestsDto);
////    }
//    @PutMapping("/api/post/{travelIdx}")
//    public TravelBoardResponseDto updatePost(@PathVariable Integer travelIdx, @RequestBody TravelBoardRequestsDto requestsDto) throws Exception {
//        return travelBoardService.updatePost(travelIdx, requestsDto);
//    }
//    
////    @DeleteMapping("/api/post/{id}")
////    public SuccessResponseDto deletePost(@PathVariable Integer userIdx, @RequestBody TravelBoardRequestsDto requestsDto) throws Exception {
////    	return travelBoardService.deletePost(userIdx, requestsDto);
////    }
//    @DeleteMapping("/api/post/{travelIdx}")
//    public SuccessResponseDto deletePost(@PathVariable Integer travelIdx, @RequestBody TravelBoardRequestsDto requestsDto) throws Exception {
//        return travelBoardService.deletePost(travelIdx, requestsDto);
//    }
//}
