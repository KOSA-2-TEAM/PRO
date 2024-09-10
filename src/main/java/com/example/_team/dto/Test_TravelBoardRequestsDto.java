package com.example._team.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example._team.domain.Theme;
import com.example._team.domain.TravelImages;
import com.example._team.domain.Users;
import com.example._team.domain.enums.Region;

import lombok.Data;

@Data
public class Test_TravelBoardRequestsDto {
    private String title;
    private String content;
    private Region region;
    private LocalDateTime statDate;
    private LocalDateTime endDate;
    private Integer isPublic;
//    private Users userIdx; // 사용자 ID 추가
    
    
//    private List<String> images; // 이미지 URL 리스트
//    private TravelImages imagePath;
    
//    private List<Integer> themeIds; // 테마 ID 리스트
//    private Theme name;
    
//    private Long userIdx; // 사용자 ID를 Long으로 저장
//    private Long imagePathId; // TravelImages의 ID를 저장
//    private Long themeId; // Theme의 ID를 저장
    
    private List<String> imagePaths; // 이미지 경로 리스트
    private List<Integer> themeIds;   // 테마 ID 리스트
}



// 22222
//package com.example._team.dto;
//
//import com.example._team.domain.enums.Region;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class TravelBoardRequestsDto {
//    private String title;
//    private Region region;
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
//    private String content;
//    private Integer isPublic;
//    private String imagePath; // 선택적 이미지 경로
//    private Integer themeIdx; // 선택적 테마 인덱스
//}



// 11111
//package com.example._team.dto;
//
//import java.time.LocalDateTime;
//
//import com.example._team.domain.Users;
//import com.example._team.domain.enums.Region;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class TravelBoardRequestsDto {
//	
//	private Integer travelIdx;
//	private String title;
//	private String content;
//	private Region region;
//	private LocalDateTime statDate;
//	private LocalDateTime endDate;
//	private Integer isPublic;
//	private Users userIdx;
//	private String email;
//}
