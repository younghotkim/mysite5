package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo selectUser(UserVo userVo) {
		
		System.out.println("[UserDao.selectUser()]");
		
		return sqlSession.selectOne("user.selectUser", userVo);
		
	}
	
	public int insertUser(UserVo userVo) {
		
		System.out.println("[UserDao.insertUser()]");
		
		return sqlSession.insert("user.insertUser", userVo);
		
	}
	
}
