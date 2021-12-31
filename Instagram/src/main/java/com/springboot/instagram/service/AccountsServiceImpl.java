package com.springboot.instagram.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;
import com.springboot.instagram.domain.user.UserRepository;
import com.springboot.instagram.web.dto.accounts.PasswordReqDto;
import com.springboot.instagram.web.dto.accounts.PasswordRespDto;
import com.springboot.instagram.web.dto.accounts.ProfileReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountsServiceImpl implements AccountsService {

	private final UserRepository userRepository;
	
	@Value("${file.path}")
	private String filePath;

	@Override
	public boolean usernameCheck(String username) {
		int result = userRepository.checkUsernameByUsername(username);
		if (result == 0) {
			// 수정 가능한 username
			return true;
		} else {
			// 이미 존재하는 username
			return false;
		}
	}

	public void deleteProfileImgFile(PrincipalDetails principalDetails) {
		String imgUrl = principalDetails.getUserDtl().getProfile_img();
		System.out.println(imgUrl);
		if(!imgUrl.equals("profile_img\\default.png")) {
			File file = new File(filePath + imgUrl);	
			if(file.exists()) {
				file.delete();
			}
		}
	}
	
	@Override
	public boolean updateUser(PrincipalDetails principalDetails, ProfileReqDto profileReqDto) {
		int id = principalDetails.getUser().getId();
		String password = principalDetails.getUser().getPassword();	
		String profile_img = null;
		
		User userEntity = profileReqDto.toUserEntity(id, password);
		UserDtl userDtlEntity = null;

		int result = 0;
		
		if(profileReqDto.getFile() == null) {
			profile_img = principalDetails.getUserDtl().getProfile_img();
		} else {
			String imageFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + profileReqDto.getFile().getOriginalFilename();
			Path imageFilePath = Paths.get(filePath, "profile_img\\" + imageFileName);
			
			File file = new File(filePath + "profile_img");
			if(!file.exists()) {
				file.mkdirs();
			}
			
			try {
				Files.write(imageFilePath, profileReqDto.getFile().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			profile_img = "profile_img\\" + imageFileName;
			
			deleteProfileImgFile(principalDetails);
		}
		
		userDtlEntity = profileReqDto.toUserDtlEntity(id, profile_img);
		result += userRepository.updateUserById(userEntity);
		result += userRepository.updateUserDtlById(userDtlEntity);	
		
		if(result == 2) {
			principalDetails.setUser(userEntity);
			principalDetails.setUserDtl(userDtlEntity);
			return true;
		} else {
			return false;
		}
	}

	public boolean passwordCheck(String principalPassword, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(password, principalPassword);
	}
	
	@Override
	public PasswordRespDto updatePassword(PrincipalDetails principalDetails, PasswordReqDto passwordReqDto) {
		boolean PrepasswordCheckFlag = passwordCheck(principalDetails.getPassword(), passwordReqDto.getPrePassword());
		boolean newPasswordCheckFlag = passwordCheck(principalDetails.getPassword(), passwordReqDto.getNewPassword());
		PasswordRespDto passwordRespDto = new PasswordRespDto();
		
		if(PrepasswordCheckFlag == false) {
			// 이전 비밀번호와 일치하지 않음
			passwordRespDto.setCode(400);
			passwordRespDto.setMessage("이전 비밀번호가 일치하지 않습니다.");
		} else if(newPasswordCheckFlag == true) {
			passwordRespDto.setCode(451);
			passwordRespDto.setMessage("새 비밀번호가 이전 비밀번호와 동일합니다.");
		} else {
			// 새 비밀번호로 변경
			User userEntity = passwordReqDto.toUserEntity(principalDetails.getUser().getId());
			int result = userRepository.updatePasswordById(userEntity);
			if(result == 1) {
				passwordRespDto.setCode(200);
				passwordRespDto.setMessage("새 비밀번호가 변경되었습니다.");
				principalDetails.getUser().setPassword(userEntity.getPassword());
			}
		}
		return passwordRespDto;
	}
}
