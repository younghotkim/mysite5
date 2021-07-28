package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;

	public int updateHit(int no) {

		System.out.println("[BoardDao.updateHit]");

		return sqlSession.update("board.updateHit", no);

	}

	public BoardVo selecetBoard(int no) {

		System.out.println("[BoardDao.selectBoard]");

		return sqlSession.selectOne("board.selectBoard", no);

	}

	public List<BoardVo> selectList(String keyword) {

		System.out.println("[BoardDao.selectList]");

		return sqlSession.selectList("board.selectList", keyword);

	}

}
