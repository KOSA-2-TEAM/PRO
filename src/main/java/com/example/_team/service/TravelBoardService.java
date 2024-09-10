package com.example._team.service;

import java.util.List;

import com.example._team.dto.TravelBoardRequestsDto;
import com.example._team.dto.TravelBoardResponseDto;

public interface TravelBoardService {
	
    TravelBoardResponseDto createTravelBoard(TravelBoardRequestsDto requestDto);
    TravelBoardResponseDto updateTravelBoard(Integer id, TravelBoardRequestsDto requestDto);
    void deleteTravelBoard(Integer id);
    TravelBoardResponseDto getTravelBoard(Integer id);
    List<TravelBoardResponseDto> getAllTravelBoards();
    
}
