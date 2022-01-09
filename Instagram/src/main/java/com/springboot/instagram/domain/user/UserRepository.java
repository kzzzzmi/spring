package com.springboot.instagram.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	public int checkUsernameByUsername(String username);
	public int insertUser(User user);
	public User getUserByUsername(String username);
	public User getUserById(int id);
	public UserDtl getUserDtlById(int id);
	
	// acccounts
	public int updateUserById(User user);
	public int updateUserDtlById(UserDtl userDtl);
	public int updatePasswordById(User user);
}
