package com.example._team.web.dto.travelalbum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example._team.web.dto.travelalbum.TravelAlbumRequestDTO.TravelAlbumThemeListDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelAlbumUpdateRequestDTO {
	String title;
    String region;
    LocalDate statDate;
    LocalDate endDate;
    MultipartFile thumbnail;
    String content;
    Integer isPublic;
    private List<TravelAlbumThemeListDTO> travelThemeList = new ArrayList<>();
    
    

}
