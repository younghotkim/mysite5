<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header" class="clearfix">
	<h1>
		<a href="">MySite</a>
	</h1>

	<!-- 로그인 성공이면 -->
	<c:if test="${!empty sessionScope.authUser}">
		<ul>
			<li>${sessionScope.authUser.name}님안녕하세요^^)b</li>
			<li><a href="" class="btn_s">로그아웃</a></li>
			<li><a href="" class="btn_s">회원정보수정</a></li>
		</ul>
	</c:if>
	<!--  로그인이 안되어있으면 -->
	<c:if test="${empty sessionScope.authUser}">
		<ul>
			<li><a href="" class="btn_s">로그인</a></li>
			<li><a href="" class="btn_s">회원가입</a></li>
		</ul>
	</c:if>

</div>
<!-- //header -->

<div id="nav">
	<ul class="clearfix">
		<li><a href="">입사지원서</a></li>
		<li><a href="">게시판</a></li>
		<li><a href="">갤러리</a></li>
		<li><a href="">방명록</a></li>
	</ul>
</div>
<!-- //nav -->