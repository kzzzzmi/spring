<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	회원가입페이지

	<form action="/study/signup" method="post">
		<input type="hidden" id="submit-flag" name="submitFlag" value="0">
		<label class="ip-names">아이디</label> <input type="text"
			class="signup-ip" name="username" value="${signupRespDto.username}"
			required> <input type="hidden" id="id-check-flag"
			name="idCheckFlag"
			value="${empty signupRespDto.idCheckFlag ? '' : signupRespDto.idCheckFlag}">
		<button type="button" id="id-check">중복확인</button><br>
		<label class="ip-names">비밀번호</label><input type="password"
			class="signup-ip" name="password" value="${signupRespDto.password}"
			required><br> <label class="ip-names">이름</label><input
			name="name" class="signup-ip" value="${signupRespDto.name}" required><br>
		<label class="ip-names">이메일</label><input type="email" name="email"
			class="signup-ip" value="${signupRespDto.email}" required><br>
		<button type="button" id="signup-btn">회원가입</button>
		<button type="reset">재작성</button>
	</form>

	<div class="test-text">안녕하세요</div>

	<button type="button" onclick="location.href='/study/signin'">로그인</button>
	<script type="text/javascript" src="/study/resources/signup.js"></script>
</body>
</html>