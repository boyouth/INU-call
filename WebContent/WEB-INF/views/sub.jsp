<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>




<div class="sub">
	<!-- 계속 고정되는 부분. sub content?.html-->
	<div class="search">
		<div>
			<label for="phone" class="label-phone">전화번호/검색어 입력↓</label>
		</div>
		<div>
			<input type="text" name="phone" size="15"> <input
				type="button" name="search_number" value="검색">
		</div>
		<div class="menu">
			<div>
				<a href="">현재 등록된 부서 보기</a>
			</div>
			<div>
				<a href="">현재 등록된 전화번호 보기</a>
			</div>
			<div>
				<a href="">내가 부서 등록하기</a>
			</div>
		</div>
	</div>
	<hr style="border: 1px color=silver;" width="100%">
	<div class="whatis">
		<div class="tit">inu@call이란?</div>
		<div class="con">
			inu@call은 학교 혹은 학교 내의 사무실에 연락를 해야만 하는 일이 생길 우리 인천대 학우들을 위해 제공하는 인천대
			전용 전화번호부입니다.
			<div>친절하지 않은 부서를 찾아 문의해주시면 총장님께 바로 메일 발송하겠습니다.</div>
		</div>

	</div>

</div>