package com.example._team.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example._team.domain.Theme;
import com.example._team.domain.TravelBoard;
import com.example._team.domain.TravelImages;
import com.example._team.domain.Users;
import com.example._team.domain.enums.Region;
import com.example._team.exception.DataNotFoundException;
import com.example._team.global.s3.AmazonS3Manager;
import com.example._team.repository.ThemeRepository;
import com.example._team.repository.TravelImageRepository;
import com.example._team.repository.TravelLikesRepository;
import com.example._team.repository.TravelRepository;
import com.example._team.repository.UserRepository;
import com.example._team.web.dto.travelalbum.TravelAlbumRequestDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TravleUpdateService {
	private final TravelRepository travelRepository;
	private final TravelImageRepository travelImageRepository;
	private final ThemeRepository themeRepository;
	private final TravelLikesRepository travelLikesRepository;
	private final UserRepository userRepository;
	private final AmazonS3Manager s3ImgService;
	
//	 // 여행 앨범 수정
//    @Transactional
//    public boolean updateTravelAlbum(Integer id, String email, TravelAlbumRequestDTO request) {
//        // 사용자의 유효성 검사
//        Users user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new DataNotFoundException("유저가 존재하지 않습니다."));
//
//        // 여행 앨범을 조회합니다.
//        TravelBoard travelBoard = travelRepository.findById(id)
//                .orElseThrow(() -> new DataNotFoundException("해당 여행앨범이 존재하지 않습니다."));
//
//        // 여행 앨범 작성자의 유효성 검사
//        if (!travelBoard.getUserIdx().getEmail().equals(email)) {
//            throw new IllegalArgumentException("이 여행 앨범을 수정할 권한이 없습니다.");
//        }
//
//        // 수정할 내용 설정
//        travelBoard.setTitle(request.getTitle());
//        travelBoard.setContent(request.getContent());
//        travelBoard.setRegion(Region.valueOf(request.getRegion()));
//        travelBoard.setStatDate(request.getStatDate());
//        travelBoard.setEndDate(request.getEndDate());
//        travelBoard.setIsPublic(request.getIsPublic());
//
//        // 썸네일이 새로 업로드된 경우 처리
//        MultipartFile thumbnailFile = request.getThumbnail();
//        if (thumbnailFile != null && !thumbnailFile.isEmpty()) {
//            String thumbnailFileName = UUID.randomUUID().toString().substring(0, 10) + "-" + thumbnailFile.getOriginalFilename();
//            String thumbnailKeyName = "travel/thumbnail/" + thumbnailFileName;
//            String thumbnailUrl = s3ImgService.uploadFile(thumbnailKeyName, thumbnailFile);
//
//            travelBoard.setThumbnail(thumbnailUrl);
//        }
//
//        // 테마 리스트 처리
//        // 기존 테마 삭제
//        themeRepository.deleteByTravelIdx(travelBoard);
//
//        // 새로운 테마 추가
//        List<Theme> themes = request.getTravelThemeList().stream()
//                .map(themeRequest -> {
//                    Theme theme = new Theme();
//                    theme.setName(themeRequest.getName());
//                    theme.setTravelIdx(travelBoard);
//                    return theme;
//                }).collect(Collectors.toList());
//
//        themeRepository.saveAll(themes);
//
//        // 이미지 URL 처리
//        // 기존 이미지 삭제
//        travelImageRepository.deleteByTravelIdx(travelBoard);
//
//        // 새 이미지 추가
//        List<String> imageUrls = request.getTravelAlbumImageList().stream()
//                .map(TravelAlbumResponseDTO.TravelAlbumImageListDTO::getImagePath)
//                .collect(Collectors.toList());
//        
//        List<TravelImages> savedImgs = imageUrls.stream()
//                .map(imgUrl -> {
//                    TravelImages travelImage = new TravelImages();
//                    travelImage.setImagePath(imgUrl);
//                    travelImage.setUploadedAt(LocalDateTime.now());
//                    travelImage.setTravelIdx(travelBoard);
//                    return travelImage;
//                })
//                .collect(Collectors.toList());
//
//        travelImageRepository.saveAll(savedImgs);
//
//        return true;
//    }

    
    
//    @Transactional
//    public boolean updateTravelAlbum(Integer id, String email, createTravelAlbumDTO request) {
//        // 사용자의 유효성 검사
//        Users user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new DataNotFoundException("유저가 존재하지 않습니다."));
//
//        // 여행 앨범을 조회합니다.
//        TravelBoard travelBoard = travelRepository.findById(id)
//                .orElseThrow(() -> new DataNotFoundException("해당 여행앨범이 존재하지 않습니다."));
//
//        // 여행 앨범 작성자의 유효성 검사
//        if (!travelBoard.getUserIdx().getEmail().equals(email)) {
//            throw new IllegalArgumentException("이 여행 앨범을 수정할 권한이 없습니다.");
//        }
//
//        // 수정할 내용 설정
//        travelBoard.setTitle(request.getTitle());
//        travelBoard.setContent(request.getContent());
//        travelBoard.setRegion(Region.valueOf(request.getRegion()));
//        travelBoard.setStatDate(request.getStatDate());
//        travelBoard.setEndDate(request.getEndDate());
//        travelBoard.setIsPublic(request.getIsPublic());
//
//        // 썸네일이 새로 업로드된 경우 처리
//        MultipartFile thumbnailFile = request.getThumbnail();
//        if (thumbnailFile != null && !thumbnailFile.isEmpty()) {
//            String thumbnailFileName = UUID.randomUUID().toString().substring(0, 10) + "-" + thumbnailFile.getOriginalFilename();
//            String thumbnailKeyName = "travel/thumbnail/" + thumbnailFileName;
//            String thumbnailUrl = s3ImgService.uploadFile(thumbnailKeyName, thumbnailFile);
//
//            travelBoard.setThumbnail(thumbnailUrl);
//        }
//
//        // 테마 리스트 처리
//        // 기존 테마 삭제
//        themeRepository.deleteByTravelIdx(travelBoard);
//
//        // 새로운 테마 추가
//        List<Theme> themes = request.getTravelThemeList().stream()
//                .map(themeRequest -> {
//                    Theme theme = new Theme();
//                    theme.setName(themeRequest.getName());
//                    theme.setTravelIdx(travelBoard);
//                    return theme;
//                }).collect(Collectors.toList());
//
//        themeRepository.saveAll(themes);
//
//        // 이미지 URL 처리
//        // 기존 이미지 삭제
//        travelImageRepository.deleteByTravelIdx(travelBoard);
//
//        // 새 이미지 추가
//        List<String> imageUrls = extractImageUrlsFromContent(request.getContent());
//        List<TravelImages> savedImgs = imageUrls.stream()
//                .map(imgUrl -> {
//                    TravelImages travelImage = new TravelImages();
//                    travelImage.setImagePath(imgUrl);
//                    travelImage.setUploadedAt(LocalDateTime.now());
//                    travelImage.setTravelIdx(travelBoard);
//                    return travelImage;
//                })
//                .collect(Collectors.toList());
//
//        travelImageRepository.saveAll(savedImgs);
//
//        return true;
//    }
    
//    public TravelService(TravelRepository travelRepository) {
//    	this.travelRepository = travelRepository;
//    }
//    
//    public Page<TravelAlbumListDTO> getAllTravelAlbums(Pageable pageable) {
//    	return travelRepository.find
//    }

}
