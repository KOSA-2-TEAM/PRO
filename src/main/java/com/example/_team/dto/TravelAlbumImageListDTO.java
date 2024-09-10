package com.example._team.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelAlbumImageListDTO {
	
	Integer id;
	String imagePath;
	
}
