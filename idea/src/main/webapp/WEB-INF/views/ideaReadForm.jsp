<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[아이디어 읽기]</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/swdo3rd.css"/>" />
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	$(function(){
		
		$("#btn1").on("click", function(){
			var infonum = $("#infonum").val();
			var title = $("#title").val();
			var content = $("#content").val();

			if(title == ""){
				alert("제목을 입력해주세요");
				return false;
			}
			if(content == ""){
				alert("내용을 입력해주세요.");
				return false;
			}
			$.ajax({
				url: "ideaUpdate",
				type: "get",
				data: {"infonum": infonum, "title": title, "content": content},
				success: function(){alert("업데이트 성공");},
				error: function(){alert("업데이트 실패");}
		
			});		
		});
			
		$("#btn2").on("click", function(){
			var check = confirm("정말 삭제하시겠습니까?");

			if(check == false){
				return;	
			}
			var infonum = $("#infonum").val();
			location.href="ideaRemove?infonum=" + infonum;
		});

		$("#btn3").on("click", function(){
			location.href="ideaList";
		});
		
	});
</script>
</head>
<body>
	<h1>[아이디어 읽기]</h1>
	<div>
	<form>
	<table class="line">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th></th>
			<th></th>	
		</tr>
		<c:forEach var="item" items="${list}" >
			<tr>
				<td><input type="text" id="infonum" name="infonum" value="${item.infonum}" readonly="readonly"></td>
				<td><input type="text" id="title" name="title" placeholder="${item.title}"></td>
				<td><input type="text" id="content" name="content" placeholder="${item.content}"></td>		
				<td>
					<div class="center">	
					<input type="button" id="btn1" value="수정">	
					</div>
				</td>		
				<td>		
					<div class="center">	
					<input type="button" id="btn2" value="삭제">
					</div>
				</td>
				<td>
					<input type="button" id="btn3" value="아이디어 모음 이동">
				</td>
			</tr>	
		</c:forEach>
	</table>
	</form>
	</div>
	<a href="/idea/ideaWriteForm">아이디어 등록</a> <br/>
	<a href="/idea">메인 이동</a>
</body>
</html>