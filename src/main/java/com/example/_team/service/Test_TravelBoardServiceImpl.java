//package com.example._team.service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example._team.domain.TravelBoard;
//import com.example._team.dto.TravelAlbumImageListDTO;
//import com.example._team.dto.TravelBoardDetailDto;
//import com.example._team.dto.TravelBoardRequestsDto;
//import com.example._team.dto.TravelBoardResponseDto;
//import com.example._team.dto.TravelThemeListDTO;
//import com.example._team.exception.DataNotFoundException;
//import com.example._team.repository.ThemeRepository;
//import com.example._team.repository.TravelBoardRepository;
//import com.example._team.repository.TravelImagesRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class Test_TravelBoardServiceImpl implements TravelBoardService {
//
//	@Autowired
//    private final TravelBoardRepository travelBoardRepository;
//	@Autowired
//    private final TravelImagesRepository travelImagesRepository; // 추가된 부분
//	@Autowired
//	private final ThemeRepository themeRepository; // 추가된 부분
////    private final UsersRepository usersRepository; // 추가된 부분
//
////    @Override
////    public TravelBoardResponseDto createTravelBoard(TravelBoardRequestsDto requestDto) {
////        TravelBoard travelBoard = new TravelBoard();
////        TravelImages travelImages = new TravelImages();
////        travelBoard.setTitle(requestDto.getTitle());
////        travelBoard.setContent(requestDto.getContent());
////        travelBoard.setRegion(requestDto.getRegion());
////        travelBoard.setStatDate(requestDto.getStatDate());
////        travelBoard.setEndDate(requestDto.getEndDate());
////        travelBoard.setIsPublic(requestDto.getIsPublic());
////        travelBoard.setUserIdx(requestDto.getUserIdx());
////
////        // Assuming imagePath and name are single objects, update as needed
////        TravelImages.setImagePath(requestDto.getImagePath());
////        travelBoard.setName(requestDto.getName());
////
////        TravelBoard savedTravelBoard = travelBoardRepository.save(travelBoard);
////
////        return convertToResponseDto(savedTravelBoard);
////    }
////    @Override
////    public TravelBoardResponseDto createTravelBoard(TravelBoardRequestsDto requestDto) {
////        TravelBoard travelBoard = new TravelBoard();
////        travelBoard.setTitle(requestDto.getTitle());
////        travelBoard.setContent(requestDto.getContent());
////        travelBoard.setRegion(requestDto.getRegion());
////        travelBoard.setStatDate(requestDto.getStatDate());
////        travelBoard.setEndDate(requestDto.getEndDate());
////        travelBoard.setIsPublic(requestDto.getIsPublic());
//////        travelBoard.setUserIdx(requestDto.getUserIdx());
////
////        // ID를 설정
////        travelBoard.setImagePathId(requestDto.getImagePathId());
////        travelBoard.setThemeId(requestDto.getThemeId());
////
////        TravelBoard savedTravelBoard = travelBoardRepository.save(travelBoard);
////
////        return convertToResponseDto(savedTravelBoard);
////    }
//    @Override
//    @Transactional
//    public TravelBoardResponseDto createTravelBoard(TravelBoardRequestsDto requestDto) {
////    	if (requestDto.getUserIdx() == null) {
////            throw new IllegalArgumentException("UserIdx cannot be null");
////        }
//    	TravelBoard travelBoard = new TravelBoard();
//        travelBoard.setTitle(requestDto.getTitle());
//        travelBoard.setContent(requestDto.getContent());
//        travelBoard.setRegion(requestDto.getRegion());
//        travelBoard.setStatDate(requestDto.getStatDate());
//        travelBoard.setEndDate(requestDto.getEndDate());
//        travelBoard.setIsPublic(requestDto.getIsPublic());
//
//     // UsersRepository를 사용하여 userIdx에 해당하는 Users 객체 조회
////        Users user = usersRepository.findById(requestDto.getUserIdx().intValue())
////            .orElseThrow(() -> new DataNotFoundException("User not found"));
////        travelBoard.setUserIdx(user);
////        // TravelImages와 Theme 객체를 가져와서 TravelBoard에 설정
////        TravelImages travelImages = travelImagesRepository.findById(requestDto.getImagePathId())
////            .orElseThrow(() -> new DataNotFoundException("TravelImages not found"));
////        Theme theme = themeRepository.findById(requestDto.getThemeId())
////            .orElseThrow(() -> new DataNotFoundException("Theme not found"));
////
////        travelBoard.setImagePath(travelImages.getImagePath()); // 이미지 경로 설정
////        travelBoard.setName(theme.getName()); // 테마 이름 설정
//
//        TravelBoard savedTravelBoard = travelBoardRepository.save(travelBoard);
//        
//        
//
//        return convertToResponseDto(savedTravelBoard);
//    }
//
//    @Override
//    @Transactional
//    public TravelBoardResponseDto updateTravelBoard(Integer id, TravelBoardRequestsDto requestDto) {
//        TravelBoard travelBoard = travelBoardRepository.findById(id)
//            .orElseThrow(() -> new DataNotFoundException("TravelBoard not found"));
//
//        travelBoard.setTitle(requestDto.getTitle());
//        travelBoard.setContent(requestDto.getContent());
//        travelBoard.setRegion(requestDto.getRegion());
//        travelBoard.setStatDate(requestDto.getStatDate());
//        travelBoard.setEndDate(requestDto.getEndDate());
//        travelBoard.setIsPublic(requestDto.getIsPublic());
////        travelBoard.setUserIdx(requestDto.getUserIdx());
//
////        // Update imagePath and name
////        travelBoard.setImagePath(requestDto.getImagePath());
////        travelBoard.setName(requestDto.getName());
//
//        TravelBoard updatedTravelBoard = travelBoardRepository.save(travelBoard);
//        System.out.println("여기까지왔니");
//        System.err.println(updatedTravelBoard.getUserIdx().getUserIdx());
//
//        return convertToResponseDto(updatedTravelBoard);
//    }
//
//    @Override
//    @Transactional
//    public void deleteTravelBoard(Integer id) {
//        if (!travelBoardRepository.existsById(id)) {
//            throw new DataNotFoundException("TravelBoard not found");
//        }
//        TravelBoard travelBoard = travelBoardRepository.getReferenceById(id);   // 1. 삭제할 여행기록 조회 (객체 조회)
//        travelImagesRepository.deleteByTravelIdx(travelBoard);					// 2. 조회된 객체를 이용하여 여행앨범에 해당하는 이미지 전체 삭제
//        themeRepository.deleteByTravelIdx(travelBoard);
////        travelImagesRepository.deleteById(id); 
////        themeRepository.deleteById(id);
//        
//        travelBoardRepository.deleteById(id);
//    }
//
//    @Override
//    public TravelBoardResponseDto getTravelBoard(Integer id) {
////        return travelBoardRepository.findByTravelIdx(id)
////            .map(this::convertToResponseDto);
//    	TravelBoard travelBoard = travelBoardRepository.findRandomTravelBoard();
//    	
//    	if (travelBoard == null) {
//            throw new DataNotFoundException("여행 앨범이 존재하지 않습니다.");
//        }
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
////        String formattedDateRange = travelBoard.getStatDate().format(formatter) + " - " + travelBoard.getEndDate().format(formatter);
//
//    	List<TravelAlbumImageListDTO> imageList = travelImagesRepository.findByTravelIdx(travelBoard)
//                .stream()
//                .map(image -> TravelAlbumImageListDTO.builder()
//                        .id(image.getImageIdx())
//                        .imagePath(image.getImagePath())
//                        .build())
//                .collect(Collectors.toList());
//
//        // 테마 리스트 조회
//        List<TravelThemeListDTO> themeList = themeRepository.findByTravelIdx(travelBoard)
//                .stream()
//                .map(theme -> TravelThemeListDTO.builder()
//                        .id(theme.getThemeIdx())
//                        .name(theme.getName())
//                        .build())
//                .collect(Collectors.toList());
//        return TravelBoardResponseDto.builder()
//        		.title(travelBoard.getTitle())
//                .content(travelBoard.getContent())
//                .region(travelBoard.getRegion())
//                .statDate(travelBoard.getStatDate())
//                .endDate(travelBoard.getEndDate())
//                .isPublic(travelBoard.getIsPublic())
//                .travelImageList(imageList)  // 이미지 리스트 설정
//                .travelThemeList(themeList)  // 테마 리스트 설정
//                .build();
//    }
//
//    private TravelBoardResponseDto convertToResponseDto(TravelBoard travelBoard) {
//        TravelBoardResponseDto responseDto = new TravelBoardResponseDto();
//        responseDto.setTitle(travelBoard.getTitle());
//        responseDto.setContent(travelBoard.getContent());
//        responseDto.setRegion(travelBoard.getRegion());
//        responseDto.setStatDate(travelBoard.getStatDate());
//        responseDto.setEndDate(travelBoard.getEndDate());
//        responseDto.setIsPublic(travelBoard.getIsPublic());
////        responseDto.setUserIdx(travelBoard.getUserIdx());
////        responseDto.setImagePath(travelBoard.getImagePath());
////        responseDto.setName(travelBoard.getName());
//
//        return responseDto;
//    }
//
////	@Override
////	public List<TravelBoardResponseDto> getAllTravelBoards() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//	
//	@Override
//    public List<TravelBoardResponseDto> getAllTravelBoards() {
//        List<TravelBoard> travelBoards = travelBoardRepository.findAll();
//        return travelBoards.stream()
//            .map(this::convertToResponseDto)
//            .collect(Collectors.toList());
//    }
//}
//
//
//
//// 33333
////package com.example._team.service;
////
////import com.example._team.domain.TravelBoard;
////import com.example._team.domain.TravelImages;
////import com.example._team.domain.Theme;
////import com.example._team.domain.Users;
////import com.example._team.dto.TravelBoardRequestsDto;
////import com.example._team.dto.TravelBoardResponseDto;
////import com.example._team.exception.DataNotFoundException;
////import com.example._team.repository.TravelBoardRepository;
////import com.example._team.service.TravelBoardService;
////import lombok.RequiredArgsConstructor;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////import java.util.Optional;
////
////@Service
////@RequiredArgsConstructor
////public class TravelBoardServiceImpl implements TravelBoardService {
////
////    private final TravelBoardRepository travelBoardRepository;
////
////    @Override
////    public TravelBoardResponseDto createTravelBoard(TravelBoardRequestsDto requestDto) {
////        TravelBoard travelBoard = new TravelBoard();
//////        TravelImages travelImages = new TravelImages();
////        travelBoard.setTitle(requestDto.getTitle());
////        travelBoard.setContent(requestDto.getContent());
////        travelBoard.setRegion(requestDto.getRegion());
////        travelBoard.setStatDate(requestDto.getStatDate());
////        travelBoard.setEndDate(requestDto.getEndDate());
////        travelBoard.setIsPublic(requestDto.getIsPublic());
////        travelBoard.setUserIdx(requestDto.getUserIdx());
////
////        // Assuming images and themes are set correctly
////        travelBoard.setImages(requestDto.getImages());
////        travelBoard.setThemeIds(requestDto.getThemeIds());
////
////        TravelBoard savedTravelBoard = travelBoardRepository.save(travelBoard);
////
////        return convertToResponseDto(savedTravelBoard);
////    }
////
////    @Override
////    public TravelBoardResponseDto updateTravelBoard(Integer id, TravelBoardRequestsDto requestDto) {
////        TravelBoard travelBoard = travelBoardRepository.findById(id)
////            .orElseThrow(() -> new DataNotFoundException("TravelBoard not found"));
////
////        travelBoard.setTitle(requestDto.getTitle());
////        travelBoard.setContent(requestDto.getContent());
////        travelBoard.setRegion(requestDto.getRegion());
////        travelBoard.setStatDate(requestDto.getStatDate());
////        travelBoard.setEndDate(requestDto.getEndDate());
////        travelBoard.setIsPublic(requestDto.getIsPublic());
////        travelBoard.setUserIdx(requestDto.getUserIdx());
////
////        // Update images and themes similarly
////        travelBoard.setImages(requestDto.getImages());
////        travelBoard.setThemeIds(requestDto.getThemeIds());
////
////        TravelBoard updatedTravelBoard = travelBoardRepository.save(travelBoard);
////
////        return convertToResponseDto(updatedTravelBoard);
////    }
////
////    @Override
////    public void deleteTravelBoard(Integer id) {
////        if (!travelBoardRepository.existsById(id)) {
////            throw new DataNotFoundException("TravelBoard not found");
////        }
////        travelBoardRepository.deleteById(id);
////    }
////
////    @Override
////    public Optional<TravelBoardResponseDto> getTravelBoard(Integer id) {
////        return travelBoardRepository.findById(id)
////            .map(this::convertToResponseDto);
////    }
////
////    private TravelBoardResponseDto convertToResponseDto(TravelBoard travelBoard) {
////        TravelBoardResponseDto responseDto = new TravelBoardResponseDto();
////        responseDto.setTitle(travelBoard.getTitle());
////        responseDto.setContent(travelBoard.getContent());
////        responseDto.setRegion(travelBoard.getRegion());
////        responseDto.setStatDate(travelBoard.getStatDate());
////        responseDto.setEndDate(travelBoard.getEndDate());
////        responseDto.setIsPublic(travelBoard.getIsPublic());
////        responseDto.setUserIdx(travelBoard.getUserIdx());
////        responseDto.setImages(travelBoard.getImages());
////        responseDto.setThemeIds(travelBoard.getThemeIds());
////
////        return responseDto;
////    }
////}
//
//
//
//// 33333
////package com.example._team.service;
////
////import com.example._team.domain.TravelBoard;
////import com.example._team.dto.TravelBoardRequestsDto;
////import com.example._team.dto.TravelBoardResponseDto;
////import com.example._team.exception.DataNotFoundException;
////import com.example._team.repository.TravelBoardRepository;
////import com.example._team.service.TravelBoardService;
////import lombok.RequiredArgsConstructor;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////import java.util.Optional;
////import java.util.stream.Collectors;
////
////@Service
////@RequiredArgsConstructor
////public class TravelBoardServiceImpl implements TravelBoardService {
////
////    private final TravelBoardRepository travelBoardRepository;
////
////    @Override
////    public TravelBoardResponseDto createTravelBoard(TravelBoardRequestsDto requestDto) {
////        TravelBoard travelBoard = new TravelBoard();
////        travelBoard.setTitle(requestDto.getTitle());
////        travelBoard.setContent(requestDto.getContent());
////        travelBoard.setRegion(requestDto.getRegion());
////        travelBoard.setStatDate(requestDto.getStatDate());
////        travelBoard.setEndDate(requestDto.getEndDate());
////        travelBoard.setIsPublic(requestDto.getIsPublic());
////        travelBoard.setUserIdx(requestDto.getUserIdx());
////        travelBoard.setImages(requestDto.getImages());
////        travelBoard.setThemeIds(requestDto.getThemeIds());
////
////        TravelBoard savedTravelBoard = travelBoardRepository.save(travelBoard);
////
////        return convertToResponseDto(savedTravelBoard);
////    }
////
////    @Override
////    public TravelBoardResponseDto updateTravelBoard(Integer id, TravelBoardRequestsDto requestDto) {
////        TravelBoard travelBoard = travelBoardRepository.findById(id)
////            .orElseThrow(() -> new DataNotFoundException("TravelBoard not found"));
////
////        travelBoard.setTitle(requestDto.getTitle());
////        travelBoard.setContent(requestDto.getContent());
////        travelBoard.setRegion(requestDto.getRegion());
////        travelBoard.setStatDate(requestDto.getStatDate());
////        travelBoard.setEndDate(requestDto.getEndDate());
////        travelBoard.setIsPublic(requestDto.getIsPublic());
////        travelBoard.setUserIdx(requestDto.getUserIdx());
////        travelBoard.setImages(requestDto.getImages());
////        travelBoard.setThemeIds(requestDto.getThemeIds());
////
////        TravelBoard updatedTravelBoard = travelBoardRepository.save(travelBoard);
////
////        return convertToResponseDto(updatedTravelBoard);
////    }
////
////    @Override
////    public void deleteTravelBoard(Integer id) {
////        if (!travelBoardRepository.existsById(id)) {
////            throw new DataNotFoundException("TravelBoard not found");
////        }
////        travelBoardRepository.deleteById(id);
////    }
////
////    @Override
////    public Optional<TravelBoardResponseDto> getTravelBoard(Integer id) {
////        return travelBoardRepository.findById(id)
////            .map(this::convertToResponseDto);
////    }
////
////    private TravelBoardResponseDto convertToResponseDto(TravelBoard travelBoard) {
////        TravelBoardResponseDto responseDto = new TravelBoardResponseDto();
////        responseDto.setTitle(travelBoard.getTitle());
////        responseDto.setContent(travelBoard.getContent());
////        responseDto.setRegion(travelBoard.getRegion());
////        responseDto.setStatDate(travelBoard.getStatDate());
////        responseDto.setEndDate(travelBoard.getEndDate());
////        responseDto.setIsPublic(travelBoard.getIsPublic());
////        responseDto.setUserIdx(travelBoard.getUserIdx());
////        responseDto.setImages(travelBoard.getImages());
////        responseDto.setThemeIds(travelBoard.getThemeIds());
////
////        return responseDto;
////    }
////}
//
//
//
//// 22222
////package com.example._team.service;
////
////import com.example._team.domain.TravelBoard;
////import com.example._team.domain.Users;
////import com.example._team.dto.TravelBoardRequestsDto;
////import com.example._team.dto.TravelBoardResponseDto;
////import com.example._team.repository.TravelBoardRepository;
////import com.example._team.repository.UsersRepository;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////import java.util.stream.Collectors;
////
////@Service
////public class TravelBoardServiceImpl implements TravelBoardService {
////
////    private final TravelBoardRepository travelBoardRepository;
////    private final UsersRepository usersRepository;
////
////    public TravelBoardServiceImpl(TravelBoardRepository travelBoardRepository, UsersRepository usersRepository) {
////        this.travelBoardRepository = travelBoardRepository;
////        this.usersRepository = usersRepository;
////    }
////
////    @Override
////    public void createTravelBoard(TravelBoardRequestsDto dto, String userEmail) {
////        Users user = usersRepository.findByEmail(userEmail);
////
////        // Setter를 이용한 TravelBoard 생성
////        TravelBoard travelBoard = new TravelBoard();
////        travelBoard.setTitle(dto.getTitle());
////        travelBoard.setContent(dto.getContent());
////        travelBoard.setRegion(dto.getRegion());
////        travelBoard.setStatDate(dto.getStartDate());
////        travelBoard.setEndDate(dto.getEndDate());
////        travelBoard.setIsPublic(dto.getIsPublic());
////        travelBoard.setUserIdx(user); // 유저 설정
////
////        travelBoardRepository.save(travelBoard);
////    }
////
////    @Override
////    public void updateTravelBoard(Integer travelIdx, TravelBoardRequestsDto dto) {
////        TravelBoard travelBoard = travelBoardRepository.findById(travelIdx)
////                .orElseThrow(() -> new IllegalArgumentException("Invalid travelIdx"));
////
////        travelBoard.setTitle(dto.getTitle());
////        travelBoard.setRegion(dto.getRegion());
////        travelBoard.setStatDate(dto.getStartDate());  // 오타 수정 (StatDate -> StartDate)
////        travelBoard.setEndDate(dto.getEndDate());
////        travelBoard.setContent(dto.getContent());
////        travelBoard.setIsPublic(dto.getIsPublic());
////
////        travelBoardRepository.save(travelBoard);
////    }
////
////    @Override
////    public void deleteTravelBoardByEmail(String email) {
////        travelBoardRepository.deleteByUserIdx_Email(email);
////    }
////
//////    @Override
//////    public List<TravelBoardResponseDto> getTravelBoardsByEmail(String email) {
//////        return travelBoardRepository.findByUserIdx_Email(email)
//////                .stream()
//////                .map(board -> new TravelBoardResponseDto(board.getTitle(), board.getRegion(), board.getStatDate(), board.getEndDate(), board.getContent(), board.getIsPublic()))
//////                .collect(Collectors.toList());
//////    }
////    @Override
////    public List<TravelBoardResponseDto> getTravelBoardsByEmail(String email) {
////        return travelBoardRepository.findByUserIdx_Email(email)
////                .stream()
////                .map(board -> new TravelBoardResponseDto(
////                        board.getTitle(),
////                        board.getRegion(),
////                        board.getStatDate(),  // 이 부분에서 오류가 발생하면 대체 메서드를 사용
////                        board.getEndDate(),
////                        board.getContent(),
////                        board.getIsPublic()
////                ))
////                .collect(Collectors.toList());
////    }
////    @Override
////    public List<TravelBoardResponseDto> getAllTravelBoards() {
////        return travelBoardRepository.findAll()
////                .stream()
////                .map(board -> new TravelBoardResponseDto(
////                        board.getTitle(),
////                        board.getRegion(),
////                        board.getStatDate(),
////                        board.getEndDate(),
////                        board.getContent(),
////                        board.getIsPublic()))
////                .collect(Collectors.toList());
////    }
////
////}
//
//
//
////package com.example._team.service;
////
////import com.example._team.domain.TravelBoard;
////import com.example._team.domain.Users;
////import com.example._team.dto.TravelBoardRequestsDto;
////import com.example._team.dto.TravelBoardResponseDto;
////import com.example._team.repository.TravelBoardRepository;
////import com.example._team.repository.UsersRepository;
////import com.example._team.service.TravelBoardService;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////import java.util.stream.Collectors;
////
////@Service
////public class TravelBoardServiceImpl implements TravelBoardService {
////
////    private final TravelBoardRepository travelBoardRepository;
////    private final UsersRepository usersRepository;
////
////    public TravelBoardServiceImpl(TravelBoardRepository travelBoardRepository, UsersRepository usersRepository) {
////        this.travelBoardRepository = travelBoardRepository;
////        this.usersRepository = usersRepository;
////    }
////
////    @Override
////    public void createTravelBoard(TravelBoardRequestsDto dto, String userEmail) {
////        Users user = usersRepository.findByEmail(userEmail);
////        TravelBoard travelBoard = new TravelBoard(dto.getTitle(), dto.getContent(), dto.getRegion(), dto.getStartDate(), dto.getEndDate(), dto.getIsPublic(), user);
////        travelBoardRepository.save(travelBoard);
////    }
////
////    @Override
////    public void updateTravelBoard(Integer travelIdx, TravelBoardRequestsDto dto) {
////        TravelBoard travelBoard = travelBoardRepository.findById(travelIdx).orElseThrow(() -> new IllegalArgumentException("Invalid travelIdx"));
////        travelBoard.setTitle(dto.getTitle());
////        travelBoard.setRegion(dto.getRegion());
////        travelBoard.setStatDate(dto.getStartDate());
////        travelBoard.setEndDate(dto.getEndDate());
////        travelBoard.setContent(dto.getContent());
////        travelBoard.setIsPublic(dto.getIsPublic());
////        travelBoardRepository.save(travelBoard);
////    }
////
////    @Override
////    public void deleteTravelBoardByEmail(String email) {
////        travelBoardRepository.deleteByUserIdx_Email(email);
////    }
////
////    @Override
////    public List<TravelBoardResponseDto> getTravelBoardsByEmail(String email) {
////        return travelBoardRepository.findByUserIdx_Email(email)
////                .stream()
////                .map(board -> new TravelBoardResponseDto(board.getTitle(), board.getRegion(), board.getStartDate(), board.getEndDate(), board.getContent(), board.getIsPublic()))
////                .collect(Collectors.toList());
////    }
////}
