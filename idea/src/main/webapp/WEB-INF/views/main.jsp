<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디어 노트</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/swdo3rd.css"/>" />
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
</head>
<body>
	<div>
		<h1>[아이디어 노트]</h1>
		<div>
			<c:if test="${sessionScope.userid != null}">
				<h3>${sessionScope.userid}님 환영합니다.</h3>
			</c:if>
		</div>	
		<div>
			<table class="line">	
					<c:if test="${sessionScope.userid == null}">		
						<tr>
							<td>
								<a href="<c:url value="loginForm"/>">로그인</a>
							</td>
						</tr>					
						<tr>
							<td>
								<a href="<c:url value="signupForm"/>">회원가입</a>
							</td>
						</tr>	
					</c:if>	
					<c:if test="${sessionScope.userid != null}">		
						<tr>
							<td>
								<a href="<c:url value="ideaWriteForm"/>">아이디어  등록</a>
							</td>
						</tr>					
						<tr>
							<td>
								<a href="<c:url value="ideaList"/>">아이디어 전체보기</a>
							</td>
						</tr>
						<tr>
							<td>
								<a href="<c:url value="ideaList2"/>">아이디어 5개씩 보기(페이징)</a>
							</td>
						</tr>
						<tr>
							<td>
								<a href="<c:url value="ideaHint"/>">아이디어 힌트 얻기</a>
							</td>
						</tr>
						<tr>
							<td>
								<a href="<c:url value="ideaSearch"/>">특허 검색</a>
							</td>
						</tr>
						<tr>
							<td>
								<a href="<c:url value="memberUpdateForm"/>">회원정보 수정</a>
							</td>
						</tr>						
						<tr>
							<td>
								<a href="<c:url value="logout"/>">로그아웃</a>
							</td>
						</tr>	
					</c:if>		
			</table>
		</div>
	</div>
</body>
</html>
