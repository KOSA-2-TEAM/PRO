package com.example._team.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import com.example._team.web.dto.travelalbum.TravelAlbumRequestDTO;
import com.example._team.web.dto.travelalbum.TravelAlbumResponseDTO.TravelAlbumDetailResponseDTO;
import com.example._team.web.dto.travelalbum.TravelAlbumUpdateRequestDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/travel")
public class TravleUpdateController {
	private final TravelService travelService;
	private final UserService userService;
	private final AmazonS3Manager s3ImgService;
	
	// 수정 폼 페이지
	@GetMapping("/update/{travelIdx}")
	public String updateTravelBoard(@PathVariable Integer travelIdx, Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
	    Users user = userService.findByEmail(email);
        TravelAlbumDetailResponseDTO response = travelService.getTravelBoard(travelIdx, user);
        String dateRange = response.getDateRange();
        
        // System.out.println()을 사용하여 isPublic 값 출력 - 현재 콘솔 창: isPublic value: null
        System.out.println("isPublic value: " + response.getIsPublic());

        System.out.println("Thumbnail value: " + response.getThumbnail());
        
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
        
        // 공개여부 추가
        model.addAttribute("ispublic", response.getIsPublic());
	
		return "view/travel/TravelEdit";
	}
	
	// 수정 완료 후
	@PostMapping("/update/{travelIdx}")
    public String submitUpdateTravelBoard(@PathVariable Integer travelIdx,
                                          @ModelAttribute("request") TravelAlbumUpdateRequestDTO request,
                                          RedirectAttributes redirectAttributes) {
        // 현재 로그인한 사용자의 이메일 정보로 사용자 확인
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userService.findByEmail(email);

        // 여행 보드 업데이트 시도
        boolean updateResult = travelService.updateTravelBoard(travelIdx, request, user);

        if (updateResult) {
            // 수정 성공 시 해당 여행보드 상세 페이지로 리다이렉트
            redirectAttributes.addFlashAttribute("successMessage", "여행앨범이 성공적으로 업데이트 되었습니다.");
            return "redirect:/api/travel/detail/" + travelIdx;
        } else {
            // 수정 실패 시 다시 수정 페이지로 리다이렉트
            redirectAttributes.addFlashAttribute("errorMessage", "여행앨범 업데이트에 실패했습니다.");
            return "redirect:/api/travel/update/" + travelIdx;
        }
    }
	
}
