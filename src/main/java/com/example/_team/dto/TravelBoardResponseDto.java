//package com.example._team.dto;
//
//
//
//import java.util.List;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//public class TravelBoardResponseAllDto {
//	
//	@Builder
//	@Data
//	@NoArgsConstructor
//	@AllArgsConstructor
//	public static class TravelBoardResponseDto {
//		private String title;
//		private String content;
//		private String region;
//		private String statDate;
//		private String endDate;
//		private Integer isPublic;
//	}
//	
//    @Builder
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class TravelAlbumListDTO {
//        Integer id;
//        String title;
//        String dateRange;
//        String thumbnail;
//
//    }
//
//    @Builder
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class TravelAlbumDetailResponseDTO {
//        Integer id;
//        String nickname;
//        String dateRange;   // 여행날짜
//        String region;
//        String thumbnail;
//        String title;
//        List<TravelAlbumImageListDTO> travelAlbumImageList;
//        List<TravelThemeListDTO> travelThemeList;
//    }
//
//    @Builder
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class TravelAlbumImageListDTO {
//        // 일단은 이미지 리스트만 불러오고, 위치정보 잘 가져오면 방문한 장소 리스트 불러오기
//        Integer id; // 이미지 아이디
//        String imagePath;   // 이미지 경로
//    }
//
//    @Builder
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class TravelThemeListDTO {
//        Integer id;
//        String name;    // 테마 이름
//    }
//
//    @Builder
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class TravelAlbumResultDTO {
//        Integer travelLikesIdx;
//    }
//}

//package com.example._team.dto;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import com.example._team.domain.Theme;
//import com.example._team.domain.TravelImages;
//import com.example._team.domain.Users;
//import com.example._team.domain.enums.Region;
//
//import lombok.Data;
//
//@Data
//public class TravelBoardResponseDto {
//    private String title;
//    private String content;
//    private String region;
//    private String statDate;
//    private String endDate;
//    private Integer isPublic;
//    
////    private Users userIdx; // 사용자 ID 추가
////    private List<String> images; // 이미지 URL 리스트
////    private TravelImages imagePath;
////    private List<Integer> themeIds; // 테마 ID 리스트
////    private Theme name;
//    
//    private long userIdx; // 사용자 ID
//    private List<String> imagePath; // 이미지 URL
//    private List<Integer> themeId; // 테마 ID
//}


// String 수정 전
package com.example._team.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example._team.domain.enums.Region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelBoardResponseDto {
	
    private String title;
    private String content;
    private Region region;
    private LocalDateTime statDate;
    private LocalDateTime endDate;
    private Integer isPublic;
    private List<TravelAlbumImageListDTO> travelImageList;
    private List<TravelThemeListDTO> travelThemeList;

}
