<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<script>
	alert("문의 답변이 작성되었습니다.");
	location.href="${root}board/inquire_board_read?inquire_idx=${inquire_idx}";

</script>
