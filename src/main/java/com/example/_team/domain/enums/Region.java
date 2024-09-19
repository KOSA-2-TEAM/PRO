package com.example._team.domain.enums;

public enum Region {
    서울, 인천, 부산, 대구, 광주, 대전, 울산, 세종, 경기도, 강원도, 충청도, 전라도, 경상도, 제주도;
    
//	public static Region fromString(Region region) {
//        for (Region r : Region.values()) {
//            if (r.name().equals(region)) {
//                return r;
//            }
//        }
//        throw new IllegalArgumentException("Invalid region: " + region);
//    }
//	public static Region fromString(String region) {
//        for (Region r : Region.values()) {
//            if (r.name().equalsIgnoreCase(region.trim())) { // 대소문자 무시하고 공백 제거
//                return r;
//            }
//        }
//        throw new IllegalArgumentException("Invalid region: " + region);
//    }
//
//	public String trim() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
