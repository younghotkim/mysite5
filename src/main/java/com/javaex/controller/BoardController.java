package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.service.UserService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/board/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(Model model, @RequestParam("no") int no) {

		System.out.println("[BoardController.read]");

		BoardVo boardVo = boardService.getBoard(no);

		model.addAttribute("boardVo", boardVo);

		return "board/read";

	}

	@RequestMapping(value = "/board/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {

		System.out.println("[BoardController.list]");

		List<BoardVo> boardList = boardService.getBoardList(keyword);

		model.addAttribute("boardList", boardList);

		return "board/list";

	}

	@RequestMapping(value = "/board/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(Model model, HttpSession session) {

		int authUserNo = ((BoardVo)session.getAttribute("authUser")).getUser_no();
		
		UserVo userVo =  userService.getUser(authUserNo);
		
		model.addAttribute("userVo", userVo);
		
		return "board/wirteForm";
		
	}

}
