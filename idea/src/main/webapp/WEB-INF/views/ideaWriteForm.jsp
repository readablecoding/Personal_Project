<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디어 등록</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/swdo3rd.css"/>" />
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	$(function(){
		//취소 버튼 눌렀을 때 메인으로 돌아가기
		$("#cancelBtn").on("click", function(){
			location.href="/idea";
		});	
	});

	function formCheck(){
		//유효성 검사
		var title = $("#title").val();
		var content = $("#content").val();
		
		if(title == ''){
			alert("제목을 입력하세요.");
			return false;
		}
		
		if(content == ''){
			alert("내용을 입력하세요.");
			return false;
		}		
		return true;				
	}
	
</script>
</head>
<body>
<div>
	<div>
		<div>
			<h1>[아이디어 등록]</h1>
			<form id="inputForm" action="ideaWrite" method="post">		
				<table class="line">
					<tr>
						<td>
							제목 :
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" placeholder="제목 입력" id="title" name="title"><br>
						</td>
					</tr>
					<tr>
						<td>		 
							내용 :
						</td>
					</tr>
					<tr>
						<td>		 
							<textarea placeholder="내용 입력" id="content" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="등록" id="writeBtn" onclick="return formCheck();">
							<input type="button" value="취소" id="cancelBtn"><br/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>	
</body>
</html>