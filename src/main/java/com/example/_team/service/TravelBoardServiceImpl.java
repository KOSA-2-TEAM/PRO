package com.example._team.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example._team.domain.Theme;
import com.example._team.domain.TravelBoard;
import com.example._team.domain.TravelImages;
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

        // 기존 이미지 업데이트
        if (requestDto.getImagePaths() != null) {
        	
            List<TravelImages> existingImages = travelImagesRepository.findByTravelIdx(travelBoard);
            
            List<String> existingImagePaths = existingImages.stream()
                .map(TravelImages::getImagePath)
                .collect(Collectors.toList());
            
            List<String> newImagePaths = requestDto.getImagePaths();
            
            List<String> imagesToAdd = newImagePaths.stream()
                .filter(imagePath -> !existingImagePaths.contains(imagePath))
                .collect(Collectors.toList());
            
            List<String> imagesToRemove = existingImagePaths.stream()
                .filter(imagePath -> !newImagePaths.contains(imagePath))
                .collect(Collectors.toList());
            
            for (String imagePath : imagesToAdd) {
                TravelImages image = new TravelImages();
                image.setImagePath(imagePath);
                image.setUploadedAt(LocalDateTime.now());
                image.setTravelIdx(travelBoard);
                travelImagesRepository.save(image);
            }
            
            for (String imagePath : imagesToRemove) {
                TravelImages imageToRemove = existingImages.stream()
                    .filter(image -> image.getImagePath().equals(imagePath))
                    .findFirst()
                    .orElseThrow(() -> new DataNotFoundException("Image to remove not found"));
                travelImagesRepository.delete(imageToRemove);
            }
        }

        // 기존 테마 업데이트
        if (requestDto.getThemeIds() != null) {
        	
            List<Theme> existingThemes = themeRepository.findByTravelIdx(travelBoard);
            
            List<Integer> existingThemeIds = existingThemes.stream()
                .map(Theme::getThemeIdx)
                .collect(Collectors.toList());
            
            List<Integer> newThemeIds = requestDto.getThemeIds();
            
            List<Integer> themesToAdd = newThemeIds.stream()
                .filter(themeId -> !existingThemeIds.contains(themeId))
                .collect(Collectors.toList());
            
            List<Integer> themesToRemove = existingThemeIds.stream()
                .filter(themeId -> !newThemeIds.contains(themeId))
                .collect(Collectors.toList());
            
            for (Integer themeId : themesToAdd) {
                Theme theme = themeRepository.findById(themeId)
                    .orElseThrow(() -> new DataNotFoundException("Theme not found"));
                theme.setTravelIdx(travelBoard);
                themeRepository.save(theme);
            }
            
            for (Integer themeId : themesToRemove) {
                Theme themeToRemove = existingThemes.stream()
                    .filter(theme -> theme.getThemeIdx().equals(themeId))
                    .findFirst()
                    .orElseThrow(() -> new DataNotFoundException("Theme to remove not found"));
                themeRepository.delete(themeToRemove);
            }
        }
        
        TravelBoard updatedTravelBoard = travelBoardRepository.save(travelBoard);
        return convertToResponseDto(updatedTravelBoard);
        
    }

    // 삭제
    @Override
    @Transactional
    public void deleteTravelBoard(Integer id) {
    	
    	TravelBoard travelBoard = travelBoardRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("TravelBoard not found"));

            travelImagesRepository.deleteByTravelIdx(travelBoard);
            
            themeRepository.deleteByTravelIdx(travelBoard);

            travelBoardRepository.delete(travelBoard);
            
    }

    // 특정 조회
    @Override
    public TravelBoardResponseDto getTravelBoard(Integer id) {
    	
    	TravelBoard travelBoard = travelBoardRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("TravelBoard not found"));
    	
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

    // 전체 조회
	@Override
    public List<TravelBoardResponseDto> getAllTravelBoards() {
		
		return travelBoardRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
		
    }
	
}
