package com.springboot.instagram.boardstudy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.instagram.boardstudy.db.BRepository;
import com.springboot.instagram.boardstudy.db.BoardStudy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // IoC 등록이 안되서 디스패처 서블릿이 매핑주소를 찾을 수 없음
@RequestMapping("/study") // 이 컨트롤러의 앞 주소에는 /study가 붙게됨
public class BoardStudyController {
	
	private final BRepository bRepository;
	
	@Value("${test.filename}")
	private String filename;
	
	@Value("${file.path}")
	private String filePath;
	
	@GetMapping("/file")
	public String file() throws IOException {
		File dir = new File(filePath + "\\jam");
		File file = new File(filePath + filename);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		if(!file.exists()) {
			file.createNewFile();
		}
		
		return null;
	}
	
	@GetMapping("/board")
	public String boardPage(Model model, @RequestParam int page) {
		List<BoardStudy> boardStudy = bRepository.getBoardList();
		
		if(page == 0) {
			model.addAttribute("b", boardStudy);
		} else {
			List<BoardStudy> pageBoard = new ArrayList<>();
			int i = (page - 1) * 5;
			
			while(i < boardStudy.size() && i < (page * 5)) {
				pageBoard.add(boardStudy.get(i));
				i++;
			} 
			model.addAttribute("b", pageBoard);
		}
		
		return "study/board";
	}
}
