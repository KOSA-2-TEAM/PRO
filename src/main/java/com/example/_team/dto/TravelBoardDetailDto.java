package com.example._team.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelBoardDetailDto {
	
      Integer id;
      String nickname;
      String dateRange;
      String region;
      String thumbnail;
      String title;
      List<TravelAlbumImageListDTO> travelAlbumImageList;
      List<TravelThemeListDTO> travelThemeList;
      
}
