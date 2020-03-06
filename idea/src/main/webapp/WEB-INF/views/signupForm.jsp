<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/swdo3rd.css" />"/>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	function formCheck(){
		var userid = $("#userid").val();
		var userpwd = $("#userpwd").val();
		var userpwdchk = $("#userpwdchk").val();

		if(userid.length < 3 || userid.length > 10){
			alert("아이디는 3~10 글자를 입력하세요");
			return false; //submit버튼을 수행 안함
		}
		
		if(userpwd.length < 3 || userpwd.length > 10){
			alert("비밀번호는 3~10 글자를 입력하세요");
			return false; //submit버튼을 수행 안함
		}

		if(userpwd != userpwdchk){
			alert("비밀번호가 일치하지 않습니다");
			return false; //submit버튼을 수행 안함
		}
		return true; //submit버튼을 그대로 수행
	}
</script>
</head>
<body>	
	<div>
		<h1>[회원가입]</h1>
		<div>
			<form action="signup" method="post">
				<table class="line">
					<tr>
						<td id="txt">아이디</td>
						<td><input type="text" id="userid" name="userid"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" id="userpwd" name="userpwd"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" id="userpwdchk" name="userpwdchk"></td>
					</tr>
					<tr>
						<td colspan="2" class="center">
							<div class="center">
								<input type="submit" value="가입" onclick="return formCheck()">
								<a href="<c:url value="/"/>">
									<input type="button" value="취소">
								</a>
							</div>
						</td>
					</tr>	
				</table>
			</form>
		</div>
	</div>
	
</body>
</html>
