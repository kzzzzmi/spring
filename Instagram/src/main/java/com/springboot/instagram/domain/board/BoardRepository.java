package com.springboot.instagram.domain.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
	public int insertBoard(Board board);
	public List<ProfileBoard> getProfileBoardListByUsername(String username);
	public Board getBoardById(int board_id);
}
