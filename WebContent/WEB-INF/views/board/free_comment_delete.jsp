<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>

<script>
	alert("댓글이 삭제되었습니다.");
	location.href="${root}board/free_board_read?free_idx=${free_idx}";
</script>
