package com.springboot.instagram.web.dto.profile;

import lombok.Data;

@Data
public class ProfileRespDto {
	private int userId;
	private String username;
	private String profile_img;
	private String introduction;
	private int boardTotalCount;
	private int followingCount;
	private int followerCount;
}
