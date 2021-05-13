<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="root" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="${root }css/index.css">

</head>
<body>
<c:import url="/WEB-INF/views/include/header.jsp"/>

<div>
<h1>content</h1>
<div>${loginUserInfo.user_name }님 반갑습니다.</div>




</div>

<c:import url="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>