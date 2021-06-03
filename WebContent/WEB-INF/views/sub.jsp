<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<script>
	
	function shareAct() {

		var cUrl = "http://localhost:8080/BoardProject/main";

		cUrl = "http://www.facebook.com/sharer/sharer.php?u=" + cUrl;

		window.open(cUrl, '',
				'width=600,height=300,top=100,left=100,scrollbars=yes');
	}
	
	
	function search(){
		var word = document.getElementById('srch').value;
		
		if(word == ''){
			alert("검색어를 입력해주세요.");
			return false;
		}
		
		location.href="${root}board/search?word="+word;
	}
	
	function enterkey_2(){
		if (window.event.keyCode == 13){
			search();
		}
	}
</script>



<div class="sub">
	<!-- 계속 고정되는 부분. sub content?.html-->
	<div class="search">
		<div>
			<label for="phone" class="label-phone">검색어 입력↓</label>
		</div>
		<div>
			<input type="text" name="srch" id="srch" size="15" onkeyup="enterkey_2()" > <input
				type="button" name="search_number" onclick="search()" value="검색" >
		</div>
		<div class="menu">
			<div>
				<a href="http://www.inu.ac.kr/" target="_blank"><img
					src="${root}image/inu_logo.PNG">우리 학교 사이트 바로가기</a>
			</div>
			<div>
				<a href="${root }board/phone_book_all"><img
					src="https://img.icons8.com/officexs/16/000000/view-details.png" />
					전화번호 전부 보기</a>
			</div>
			<div class="sns">
				<a href="#" id="vIconFb" onclick="shareAct()">
				<!-- <img src="https://img.icons8.com/small/16/000000/share.png" />  -->
				<img src="https://img.icons8.com/officexs/16/000000/facebook-new.png"/>
				 이 사이트 공유하기</a>
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