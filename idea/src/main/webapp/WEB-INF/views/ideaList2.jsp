<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디어 리스트</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/swdo3rd.css"/>" />
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script type="text/javascript">
	function ideaReadForm(infonum){
		location.href="ideaReadForm?infonum=" + infonum;
	}	

	function paging(page){
		var pagingForm = document.getElementById("pagingForm");
		var currentpage = document.getElementById("currenPage");
		
		currentPage.value = page;
		pagingForm.submit();		
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
							<a href="javascript:ideaReadForm('${item.INFONUM}')"> ${item.TITLE}</a>
						</td>
						<td>${item.INPUTDATE}</td>	
					</tr>
				</c:forEach> 
		</table>	
		
		<!-- 페이징 처리 -->
		<a href="javascript:paging('${navi.currentPage - navi.pagePerGroup}')">◁◁</a>
		<a href="javascript:paging('${navi.currentPage - 1}')">◀</a>
		<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
			<c:choose>
				<c:when test="${counter == navi.currentPage}">
					<b><a href="javascript:paging('${counter}')">${counter}</a></b>
				</c:when>
				<c:otherwise>
					<small><a href="javascript:paging('${counter}')">${counter}</a></small>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<a href="javascript:paging('${navi.currentPage + 1}')">▶</a>
		<a href="javascript:paging('${navi.currentPage + navi.pagePerGroup}')">▷▷</a>
			
		
		<!-- 페이징  요청시 전달할 폼 -->
		<form action="ideaList2" method="get" id="pagingForm">
			<input type="hidden" id="currentPage" name="currentPage">
		</form>	
	</div>	
	<br/>
	<a href="<c:url value='ideaWriteForm'/>">아이디어 등록</a><br/>
	<a href="<c:url value='/'/>">메인 이동</a>
</body>
</html>
