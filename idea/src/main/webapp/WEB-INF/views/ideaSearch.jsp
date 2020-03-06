<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>특허 검색</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/swdo3rd.css"/>" />
<script>
	$(function(){
		$("#kr").on("click", function(){
			window.open("http://kportal.kipris.or.kr/kportal/search/total_search.do") ;
		});

		$("#us").on("click", function(){
			window.open("http://patft.uspto.gov/netahtml/PTO/search-adv.htm");
		});
	});
</script>
</head>
<body>
	<h1>[특허 검색]</h1>
	<div>
	<table class="line">
		<tr>
			<td>
				<input type="button" id="kr" value="한국 특허 검색"><br/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" id="us" value="미국 특허 검색"><br/>
			</td>
		</tr>
	</table>
	</div>
	<br/>
	<a href="<c:url value='ideaWriteForm'/>">아이디어 등록</a><br/>
	<a href="<c:url value='ideaList'/>">아이디어 리스트</a><br/>
	<a href="<c:url value='ideaList2'/>">아이디어 리스트(페이징)</a><br/>
	<a href="<c:url value='/'/>">메인 이동</a>
</body>
</html>