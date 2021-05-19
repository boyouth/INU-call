<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<script>
	alert("게시글이 수정되었습니다.");
	location.href="${root}board/phone_book_read?list_idx=${list_idx}";
</script>
