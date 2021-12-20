package com.spring.study.domain.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<User> getUserAll() {
		return sqlSession.selectList("com.spring.study.domain.user.UserRepository.getUserAll");
	}

	@Override
	public int idCheck(String username) {
		return sqlSession.selectOne("com.spring.study.domain.user.UserRepository.idCheck", username);
	}

	@Override
	public int insertUser(User user) {
		return sqlSession.insert("com.spring.study.domain.user.UserRepository.insertUser", user);
	}
	
}
