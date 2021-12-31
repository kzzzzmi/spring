package com.springboot.instagram.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springboot.instagram.config.auth.PrincipalDetails;
import com.springboot.instagram.domain.board.Board;
import com.springboot.instagram.domain.board.BoardRepository;
import com.springboot.instagram.web.dto.board.BoardReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;

	@Value("${file.path}")
	private String filePath;

	@Override
	public boolean insertBoard(PrincipalDetails principalDetails, BoardReqDto boardReqDto) {
		String imgFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_"
				+ boardReqDto.getFile().getOriginalFilename();
		String boardImg = "board_img\\" + imgFileName;
		Path imgFilePath = Paths.get(filePath, boardImg);

		File file = new File(filePath + "board_img");
		if (!file.exists()) {
			file.mkdir();
		}

		try {
			Files.write(imgFilePath, boardReqDto.getFile().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		Board boardEntity = boardReqDto.toEntity(principalDetails.getUser().getId(), boardImg);

		int result = boardRepository.insertBoard(boardEntity);
		if (result == 1) {
			return true;
		}
		
		return false;
	}

}
