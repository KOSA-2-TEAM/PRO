package com.example._team.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example._team.domain.Theme;
import com.example._team.domain.enums.Region;

import lombok.Data;

@Data
public class TravelBoardRequestsDto {
	
    private String title;
    private String content;
    private Region region;
    private LocalDateTime statDate;
    private LocalDateTime endDate;
    private Integer isPublic;
    private List<String> imagePaths;
    private List<Integer> themeIds;
    
}
