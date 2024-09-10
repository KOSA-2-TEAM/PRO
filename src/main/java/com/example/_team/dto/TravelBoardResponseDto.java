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
