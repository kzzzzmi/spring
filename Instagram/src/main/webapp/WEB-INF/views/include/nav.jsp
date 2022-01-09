<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> <!-- scurity-taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl-taglib -->

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/nav.css" />
<script src="https://kit.fontawesome.com/498fda3233.js" crossorigin="anonymous"></script>
</head>

<body>
	<nav class="nav-bar">
		<div class="nav-main">
			<div class="nav-logo">
				<a href="/"><img src="/image/instagram_logo.PNG" alt="로고" /></a>
			</div>
			<div class="nav-search">
				<div class="nav-search-border">
					<i class="fas fa-search"></i> <input type="text"
						class="nav-search-ip" placeholder="검색" />
				</div>
			</div>
			<div class="nav-items">
				<c:choose>
					<c:when test="${empty principal.user}">
						<div class="nav-item">
							<button type="button" class="signin-btn" onclick="location.href='/auth/signin'">로그인</button>
						</div>
						<div class="nav-item">
							<button type="button" class="signup-btn" onclick="location.href='auth/signup'">가입하기</button>
						</div>
					</c:when>
					<c:otherwise>
						<div class="nav-item">
							<i class="fas fa-home nav-items-icon"></i>
						</div>
						<div class="nav-item">
							<a href="/upload"> <i
								class="fas fa-plus-square nav-items-icon"></i>
							</a>
						</div>
						<div class="nav-item">
							<a href="/${principal.user.username}">
								<div class="nav-items-profile">
									<img id="nav-profile-image"
										src="/images/${principal.userDtl.profile_img}" />
								</div>
							</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</nav>
</body>
</html>