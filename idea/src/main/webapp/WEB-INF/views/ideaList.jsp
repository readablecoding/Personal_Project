<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디어 리스트</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/swdo3rd.css"/>" />
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	function ideaReadForm(infonum){
		location.href="ideaReadForm?infonum=" + infonum;
	}	

</script>
</head>
<body>
	<div>
		<h1>[아이디어 리스트]</h1>
		<table class="line">
				<tr>
					<th>번호</th>	
					<th>제목</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="item" items="${list}" varStatus="status">
					<tr>				
						<td>${status.count}</td>		
						<td>
							<a href="javascript:ideaReadForm('${item.infonum}')"> ${item.title}</a>
						</td>
						<td>${item.inputdate}</td>	
					</tr>
				</c:forEach> 
		</table>	
		
		
	</div>	
	<br/>
	<a href="<c:url value='ideaWriteForm'/>">아이디어 등록</a><br/>
	<a href="<c:url value='/'/>">메인 이동</a>
</body>
</html>
