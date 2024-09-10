package com.example._team.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example._team.domain.TravelBoard;
import com.example._team.dto.TravelAlbumImageListDTO;
import com.example._team.dto.TravelBoardRequestsDto;
import com.example._team.dto.TravelBoardResponseDto;
import com.example._team.dto.TravelThemeListDTO;
import com.example._team.exception.DataNotFoundException;
import com.example._team.repository.ThemeRepository;
import com.example._team.repository.TravelBoardRepository;
import com.example._team.repository.TravelImagesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelBoardServiceImpl implements TravelBoardService {

	@Autowired
    private final TravelBoardRepository travelBoardRepository;
	@Autowired
    private final TravelImagesRepository travelImagesRepository;
	@Autowired
	private final ThemeRepository themeRepository;

	// 생성
    @Override
    @Transactional
    public TravelBoardResponseDto createTravelBoard(TravelBoardRequestsDto requestDto) {
    	
    	TravelBoard travelBoard = new TravelBoard();
        travelBoard.setTitle(requestDto.getTitle());
        travelBoard.setContent(requestDto.getContent());
        travelBoard.setRegion(requestDto.getRegion());
        travelBoard.setStatDate(requestDto.getStatDate());
        travelBoard.setEndDate(requestDto.getEndDate());
        travelBoard.setIsPublic(requestDto.getIsPublic());

        TravelBoard savedTravelBoard = travelBoardRepository.save(travelBoard);
        
        return convertToResponseDto(savedTravelBoard);
    }

    // 수정
    @Override
    @Transactional
    public TravelBoardResponseDto updateTravelBoard(Integer id, TravelBoardRequestsDto requestDto) {
    	
        TravelBoard travelBoard = travelBoardRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("TravelBoard not found"));

        travelBoard.setTitle(requestDto.getTitle());
        travelBoard.setContent(requestDto.getContent());
        travelBoard.setRegion(requestDto.getRegion());
        travelBoard.setStatDate(requestDto.getStatDate());
        travelBoard.setEndDate(requestDto.getEndDate());
        travelBoard.setIsPublic(requestDto.getIsPublic());

        TravelBoard updatedTravelBoard = travelBoardRepository.save(travelBoard);

        return convertToResponseDto(updatedTravelBoard);
    }

    // 삭제
    @Override
    @Transactional
    public void deleteTravelBoard(Integer id) {
    	
        if (!travelBoardRepository.existsById(id)) {
            throw new DataNotFoundException("TravelBoard not found");
        }
        
        TravelBoard travelBoard = travelBoardRepository.getReferenceById(id);
        
        travelImagesRepository.deleteByTravelIdx(travelBoard);
        themeRepository.deleteByTravelIdx(travelBoard);
        travelBoardRepository.deleteById(id);
    }

    // 특정 조회
    @Override
    public TravelBoardResponseDto getTravelBoard(Integer id) {
    	
    	TravelBoard travelBoard = travelBoardRepository.findRandomTravelBoard();
    	
    	if (travelBoard == null) {
            throw new DataNotFoundException("여행 앨범이 존재하지 않습니다.");
        }

    	List<TravelAlbumImageListDTO> imageList = travelImagesRepository.findByTravelIdx(travelBoard)
                .stream()
                .map(image -> TravelAlbumImageListDTO.builder()
                        .id(image.getImageIdx())
                        .imagePath(image.getImagePath())
                        .build())
                .collect(Collectors.toList());

        List<TravelThemeListDTO> themeList = themeRepository.findByTravelIdx(travelBoard)
                .stream()
                .map(theme -> TravelThemeListDTO.builder()
                        .id(theme.getThemeIdx())
                        .name(theme.getName())
                        .build())
                .collect(Collectors.toList());
        return TravelBoardResponseDto.builder()
        		.title(travelBoard.getTitle())
                .content(travelBoard.getContent())
                .region(travelBoard.getRegion())
                .statDate(travelBoard.getStatDate())
                .endDate(travelBoard.getEndDate())
                .isPublic(travelBoard.getIsPublic())
                .travelImageList(imageList)
                .travelThemeList(themeList)
                .build();
    }

    private TravelBoardResponseDto convertToResponseDto(TravelBoard travelBoard) {
    	
        TravelBoardResponseDto responseDto = new TravelBoardResponseDto();
        
        responseDto.setTitle(travelBoard.getTitle());
        responseDto.setContent(travelBoard.getContent());
        responseDto.setRegion(travelBoard.getRegion());
        responseDto.setStatDate(travelBoard.getStatDate());
        responseDto.setEndDate(travelBoard.getEndDate());
        responseDto.setIsPublic(travelBoard.getIsPublic());

        return responseDto;
    }

    // 전체 조회
	@Override
    public List<TravelBoardResponseDto> getAllTravelBoards() {
		
        List<TravelBoard> travelBoards = travelBoardRepository.findAll();
        
        return travelBoards.stream()
            .map(this::convertToResponseDto)
            .collect(Collectors.toList());
    }
	
}
