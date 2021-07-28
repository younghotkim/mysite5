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

		return sqlSession.selectOne("user.selectUser", userVo);

	}

	public UserVo selectUser(int no) {

		return sqlSession.selectOne("user.selectUserModify", no);

	}

	public int insertUser(UserVo userVo) {

		return sqlSession.insert("user.insertUser", userVo);

	}

	public int updateUser(UserVo userVo) {

		return sqlSession.update("user.updateUser", userVo);

	}

}
