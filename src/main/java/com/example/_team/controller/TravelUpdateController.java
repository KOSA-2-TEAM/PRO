package com.example._team.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example._team.domain.Users;
import com.example._team.global.s3.AmazonS3Manager;
import com.example._team.repository.TravelLikesRepository;
import com.example._team.service.TravelService;
import com.example._team.service.UserService;
import com.example._team.web.dto.travelalbum.TravelAlbumRequestDTO.createTravelAlbumDTO;
import com.example._team.web.dto.travelalbum.TravelAlbumResponseDTO.TravelAlbumDetailResponseDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/travel")
public class TravelUpdateController {
	private final TravelService travelService;
	private final UserService userService;
	private final AmazonS3Manager s3ImgService;
	private final TravelLikesRepository travelLikesRepository;
	  
//  // 여행앨범 수정 폼
//  @GetMapping("/edit/{id}") // /{id} //"/editform/{id}"
//  public String showEditForm(@PathVariable Integer id, Model model) {
//  	String email = SecurityContextHolder.getContext().getAuthentication().getName();
//  	Users user = userService.findByEmail(email);
//  	
//  	TravelAlbumDetailResponseDTO response = travelService.getTravelBoard(id, user);
////  	List<String> theme = travelService.getTravelThemes();
//  	
//  	model.addAttribute("response", response);
//  	model.addAttribute("user", user);
//  	return "view/travel/TravelEdit";
//  }
//
//	// 여행앨범 수정
//	@PutMapping("/edit/{id}")
//	public String updateTravelAlbum(@PathVariable Integer id, @ModelAttribute("request") createTravelAlbumDTO request,
//			RedirectAttributes redirectAttributes) {
//		String email = SecurityContextHolder.getContext().getAuthentication().getName();
//		boolean success = travelService.updateTravelAlbum(id, email, request);
//
//		if (success) {
//			redirectAttributes.addAttribute("id", id);
//			return "redirect:/api/travel/detail/{id}";
//		} else {
//			redirectAttributes.addFlashAttribute("error", "앨범 수정에 실패했습니다.");
//			return "redirect:/api/travel/edit/{id}";
//		}
//	}
	
//	@GetMapping()
//	public String updateTravelAlbun() {
//		return ""
//	}

}
