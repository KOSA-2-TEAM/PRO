package com.example._team.web.dto.travelalbum;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example._team.domain.Theme;
import com.example._team.domain.TravelBoard;
import com.example._team.domain.enums.Region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelAlbumUpdateResponseDTO {
	
	private String title;
	private String content;
//	private Region region;
	private String region;
	private LocalDate statDate;
	private LocalDate endDate;
//	private List<String> thumbnail;
	private String thumbnail;
	private Integer isPublic;
	private List<String> themes;
	
	public static TravelAlbumUpdateResponseDTO fromEntity(TravelBoard board) {
        return TravelAlbumUpdateResponseDTO.builder()
            .title(board.getTitle())
            .content(board.getContent())
//            .region(board.getRegion())
            .region(board.getRegion().name()) // Region Enum을 String으로 변환
            .statDate(board.getStatDate())
            .endDate(board.getEndDate())
            .thumbnail(board.getThumbnail())  // 대표 이미지 URL
            .isPublic(board.getIsPublic())
            .themes(board.getThemes().stream()
                      .map(Theme::getName)
                      .collect(Collectors.toList()))  // 테마의 이름만을 리스트로 저장
            .build();
    }

}
