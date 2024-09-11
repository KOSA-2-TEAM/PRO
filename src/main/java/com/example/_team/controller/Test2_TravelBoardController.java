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
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.service.TravelBoardService;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/api/travelboards")
//@RequiredArgsConstructor
//public class Test2_TravelBoardController {
//
//    private final TravelBoardService travelBoardService;
//
//    // 생성
//    @PostMapping
//    public TravelBoardResponseDto createTravelBoard(@RequestBody TravelBoardRequestsDto requestDto) {
//        return travelBoardService.createTravelBoard(requestDto);
//    }
//
//    // 수정
//    @PutMapping("/{id}")
//    public TravelBoardResponseDto updateTravelBoard(@PathVariable Integer id, @RequestBody TravelBoardRequestsDto requestDto) {
//        return travelBoardService.updateTravelBoard(id, requestDto);
//    }
//
//    // 삭제
////    @DeleteMapping("/{travelIdx}")
////    public void deleteTravelBoard(@PathVariable Integer travelIdx) {
////        travelBoardService.deleteTravelBoard(travelIdx);
////    }
//    @DeleteMapping("/{id}")
//    public void deleteTravelBoard(@PathVariable Integer id) {
//        travelBoardService.deleteTravelBoard(id);
//    }
//
//
//    // 특정 조회
//    @GetMapping("/{id}")
//    public TravelBoardResponseDto getTravelBoard(@PathVariable Integer id) {
//        return travelBoardService.getTravelBoard(id);
//    }
//    
//    // 전체 조회
//    @GetMapping
//    public List<TravelBoardResponseDto> getAllTravelBoards() {
//        return travelBoardService.getAllTravelBoards();
//    }
//    
//}
