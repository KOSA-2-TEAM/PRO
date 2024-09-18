package com.example._team.controller;

import com.example._team.web.dto.travelalbum.TravelAlbumRequestDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example._team.domain.Users;
import com.example._team.global.s3.AmazonS3Manager;
import com.example._team.service.TravelService;
import com.example._team.service.UserService;
import com.example._team.web.dto.travelalbum.TravelAlbumRequestDTO.createTravelAlbumDTO;
import com.example._team.web.dto.travelalbum.TravelAlbumResponseDTO.TravelAlbumDetailResponseDTO;
import com.example._team.web.dto.travelalbum.TravelAlbumResponseDTO.TravelAlbumResultDTO;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/travel")
public class TravleUpdateController {
	private final TravelService travelService;
	private final UserService userService;
	private final AmazonS3Manager s3ImgService;
	
	@GetMapping("/update/{travelIdx}")
	public String updateTravelBoard(@PathVariable Integer travelIdx, Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
	    Users user = userService.findByEmail(email);
        TravelAlbumDetailResponseDTO response = travelService.getTravelBoard(travelIdx, user);
        String dateRange = response.getDateRange();

        // 날짜 포맷터 생성
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        // 문자열을 각각 시작일과 종료일로 분리
        String[] dates = dateRange.split(" - ");

        // 문자열을 LocalDate로 변환
        LocalDate startDate = LocalDate.parse(dates[0], formatter);
        LocalDate endDate = LocalDate.parse(dates[1], formatter);

        model.addAttribute("response", response);
        model.addAttribute("user", user);
        model.addAttribute("startDate",startDate);
        model.addAttribute("endDAte",endDate);
	
		return "view/travel/TravelEdit";
	}

    // 기존 값 못 불러옴(지역, 대표사진, 공개여부), 테마 삭제 버튼 수정 필요

    ////////////////////////////////////////////////////////////////////////////////////
	
    // 여행앨범 생성
    /*@PostMapping("/create2222")
    public String createTravelAlbum(@ModelAttribute("request") createTravelAlbumDTO request,
                                    RedirectAttributes redirectAttributes) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        TravelAlbumResultDTO response = travelService.postTravelAlbum(email, request);
        redirectAttributes.addAttribute("id", response.getTravelIdx());
        return "redirect:/api/travel/detail/{id}";
    }*/
}
