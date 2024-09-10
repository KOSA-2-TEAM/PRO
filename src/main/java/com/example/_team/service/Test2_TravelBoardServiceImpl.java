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
public class Test2_TravelBoardServiceImpl implements TravelBoardService {

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
        
//        // 이미지 추가
//        if (requestDto.getImagePaths() != null) {
//            for (String imagePath : requestDto.getImagePaths()) {
//                TravelImages image = new TravelImages();
//                image.setImagePath(imagePath);
//                image.setUploadedAt(LocalDateTime.now());
//                image.setTravelIdx(savedTravelBoard);
//                travelImagesRepository.save(image);
//            }
//        }
//
//        // 테마 추가
//        if (requestDto.getThemeIds() != null) {
//            for (Integer themeId : requestDto.getThemeIds()) {
//                Theme theme = themeRepository.findById(themeId)
//                        .orElseThrow(() -> new DataNotFoundException("Theme not found"));
//                theme.setTravelIdx(savedTravelBoard);
//                themeRepository.save(theme);
//            }
//        }
        
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

//        TravelBoard updatedTravelBoard = travelBoardRepository.save(travelBoard);

     // 기존 이미지 업데이트
        if (requestDto.getImagePaths() != null) {
            // 기존 이미지 조회
            List<TravelImages> existingImages = travelImagesRepository.findByTravelIdx(travelBoard);

            // 기존 이미지 경로 목록
            List<String> existingImagePaths = existingImages.stream()
                .map(TravelImages::getImagePath)
                .collect(Collectors.toList());

            // 새로 입력된 이미지 경로 목록
            List<String> newImagePaths = requestDto.getImagePaths();

            // 추가할 이미지 경로 필터링
            List<String> imagesToAdd = newImagePaths.stream()
                .filter(imagePath -> !existingImagePaths.contains(imagePath))
                .collect(Collectors.toList());

            // 삭제할 이미지 경로 필터링
            List<String> imagesToRemove = existingImagePaths.stream()
                .filter(imagePath -> !newImagePaths.contains(imagePath))
                .collect(Collectors.toList());

            // 새로 추가할 이미지 저장
            for (String imagePath : imagesToAdd) {
                TravelImages image = new TravelImages();
                image.setImagePath(imagePath);
                image.setUploadedAt(LocalDateTime.now());
                image.setTravelIdx(travelBoard);
                travelImagesRepository.save(image);
            }

            // 삭제할 이미지 제거
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
            // 기존 테마 조회
            List<Theme> existingThemes = themeRepository.findByTravelIdx(travelBoard);

            // 기존 테마 ID 목록
            List<Integer> existingThemeIds = existingThemes.stream()
                .map(Theme::getThemeIdx)
                .collect(Collectors.toList());

            // 새로 입력된 테마 ID 목록
            List<Integer> newThemeIds = requestDto.getThemeIds();

            // 추가할 테마 ID 필터링
            List<Integer> themesToAdd = newThemeIds.stream()
                .filter(themeId -> !existingThemeIds.contains(themeId))
                .collect(Collectors.toList());

            // 삭제할 테마 ID 필터링
            List<Integer> themesToRemove = existingThemeIds.stream()
                .filter(themeId -> !newThemeIds.contains(themeId))
                .collect(Collectors.toList());

            // 새로 추가할 테마 저장
            for (Integer themeId : themesToAdd) {
                Theme theme = themeRepository.findById(themeId)
                    .orElseThrow(() -> new DataNotFoundException("Theme not found"));
                theme.setTravelIdx(travelBoard);
                themeRepository.save(theme);
            }

            // 삭제할 테마 제거
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
//    @Override
//    @Transactional
//    public TravelBoardResponseUpdateDto updateTravelBoard(Integer id, TravelBoardResponseUpdateDto requestDto) {
//    	
//        TravelBoard travelBoard = travelBoardRepository.findById(id)
//            .orElseThrow(() -> new DataNotFoundException("TravelBoard not found"));
//
//        travelBoard.setTitle(requestDto.getTitle());
//        travelBoard.setContent(requestDto.getContent());
//        travelBoard.setRegion(requestDto.getRegion());
//        travelBoard.setStatDate(requestDto.getStatDate());
//        travelBoard.setEndDate(requestDto.getEndDate());
//        travelBoard.setIsPublic(requestDto.getIsPublic());
//        travelBoard.set
//
////        TravelBoard updatedTravelBoard = travelBoardRepository.save(travelBoard);
//
//        
//        
//        TravelBoard updatedTravelBoard = travelBoardRepository.save(travelBoard);
//        return convertToResponseDto(updatedTravelBoard);
//    }

    // 삭제
    @Override
    @Transactional
    public void deleteTravelBoard(Integer id) {
    	
//        if (!travelBoardRepository.existsById(id)) {
//            throw new DataNotFoundException("TravelBoard not found");
//        }
//        
//        TravelBoard travelBoard = travelBoardRepository.getReferenceById(id);
//        
//        travelImagesRepository.deleteByTravelIdx(travelBoard);
//        themeRepository.deleteByTravelIdx(travelBoard);
//        travelBoardRepository.deleteById(id);
    	
    	TravelBoard travelBoard = travelBoardRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("TravelBoard not found"));

            // 관련 이미지와 테마 삭제
            travelImagesRepository.deleteByTravelIdx(travelBoard);
            themeRepository.deleteByTravelIdx(travelBoard);

            // 여행 보드 삭제
            travelBoardRepository.delete(travelBoard);
    }

    // 특정 조회
    @Override
    public TravelBoardResponseDto getTravelBoard(Integer id) {
    	
//    	TravelBoard travelBoard = travelBoardRepository.findRandomTravelBoard();
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
    	
//        TravelBoardResponseDto responseDto = new TravelBoardResponseDto();
//        
//        responseDto.setTitle(travelBoard.getTitle());
//        responseDto.setContent(travelBoard.getContent());
//        responseDto.setRegion(travelBoard.getRegion());
//        responseDto.setStatDate(travelBoard.getStatDate());
//        responseDto.setEndDate(travelBoard.getEndDate());
//        responseDto.setIsPublic(travelBoard.getIsPublic());
//
//        return responseDto;
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
		
//        List<TravelBoard> travelBoards = travelBoardRepository.findAll();
//        
//        return travelBoards.stream()
//            .map(this::convertToResponseDto)
//            .collect(Collectors.toList());
		return travelBoardRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }
	
}
