package com.example._team.controller;

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
	    
        model.addAttribute("response", response);
        model.addAttribute("user", user);
	
		return "view/travel/TravelEdit";
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////
	
    // 여행앨범 생성
    @PostMapping("/create2222")
    public String createTravelAlbum(@ModelAttribute("request") createTravelAlbumDTO request,
                                    RedirectAttributes redirectAttributes) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        TravelAlbumResultDTO response = travelService.postTravelAlbum(email, request);
        redirectAttributes.addAttribute("id", response.getTravelIdx());
        return "redirect:/api/travel/detail/{id}";
    }
}
