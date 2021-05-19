<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<script>
	alert("${name}님의 아이디는 ${id} 입니다. 로그인해주세요");
	location.href="${root}user/login";
</script>