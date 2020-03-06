<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디어 리스트</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/swdo3rd.css"/>" />
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
</head>
<body>
	<h1>[아이디어 리스트]</h1>
	<div>
		<p>아이디어가 없습니다.</p>
		<p>새로 등록해주세요.</p>
		<a href="<c:url value='ideaWriteForm'/>">아이디어 등록</a><br/>
		<a href="<c:url value='/'/>">메인 이동</a>
	</div>
</body>
</html>