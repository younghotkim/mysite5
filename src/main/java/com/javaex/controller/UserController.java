package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	/////////// Field//////////////
	@Autowired
	private UserService userService;

	/////////// General Method/////////////

	// loginForm

	@RequestMapping(value = "/user/loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {

		System.out.println("[UserController.loginForm()]");

		return "user/loginForm";

	}

	// Login

	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {

		System.out.println("[UserController.login()]");

		UserVo authUser = userService.getUser(userVo);

		if (authUser != null) {

			System.out.println("[로그인 성공]");

			session.setAttribute("authUser", authUser);

			return "redirect:/main";

		} else {

			System.out.println("[로그인 실패]");

			return "redirect:/user/loginForm?result=fail";

		}

	}

	// logout

	@RequestMapping(value = "/user/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {

		session.removeAttribute("authUser");
		session.invalidate();

		return "redirect:/main";

	}

	// joinForm

	@RequestMapping(value = "/user/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {

		System.out.println("[UserController.joinForm()]");

		return "user/joinForm";

	}

	// join
	@RequestMapping(value = "/user/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {

		System.out.println("[UserController.login()]");

		int count = userService.userJoin(userVo);

		System.out.println(count + "명이 가입했습니다.");

		return "user/joinOk";

	}

	// modifyForm
	@RequestMapping(value = "/user/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(Model model, HttpSession session) {

		System.out.println("[UserController.modifyForm()]");

		int authUserNo = ((UserVo) session.getAttribute("authUser")).getNo();

		UserVo userVo = userService.getUser(authUserNo);

		model.addAttribute("userVo", userVo);

		return "user/modifyForm";

	}

	// modify
	@RequestMapping(value = "/user/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {

		System.out.println("[UserController.modify()]");

		int no = ((UserVo) session.getAttribute("authUser")).getNo();

		userVo.setNo(no);

		int count = userService.userModify(userVo);

		((UserVo) session.getAttribute("authUser")).setName(userVo.getName());

		System.out.println(count + "건이 수정되었습니다.");

		return "redirect:/main";

	}
}
