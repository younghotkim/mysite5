package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	public BoardVo getBoard(int no) {

		System.out.println("[BoardService.getBoard()]");

		boardDao.updateHit(no);

		BoardVo boardVo = boardDao.selecetBoard(no);

		return boardVo;

	}

	public List<BoardVo> getBoardList(String keyword) {

		System.out.println("[BoardService.boardList()]");

		List<BoardVo> boardList = boardDao.selectList(keyword);

		return boardList;
		
	}

}
