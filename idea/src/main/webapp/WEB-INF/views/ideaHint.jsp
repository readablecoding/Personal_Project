<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디어 힌트 얻기</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/swdo3rd.css"/>" />
</head>
<body>
	<div>
	<h1>[아이디어 힌트 얻기]</h1>
	<table class="line">
		<tr>
			<td>
				<a href="javascript:void(window.open('https://social.lge.co.kr/people/it_casting10'))">일상에서 영감을 얻는 22가지 방법</a>
			</td>	
		</tr>
		<tr>
			<td>
				<a href="javascript:void(window.open('https://www.huffingtonpost.kr/2014/07/23/story_n_5612022.html'))">창의력의 대가들은 이렇게 아이디어를 얻는다</a>	
			</td>	
		</tr>
		<tr>
			<td>
				<a href="javascript:void(window.open('http://www.wiznews.co.kr/news/articleView.html?idxno=469'))">천재들이 아이디어 얻는 법</a>	
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