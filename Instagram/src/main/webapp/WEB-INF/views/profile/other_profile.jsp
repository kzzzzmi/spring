<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> <!-- scurity-taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl-taglib -->

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Instagram</title>
<link rel="stylesheet" href="/css/other_profile.css" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<section>
		<jsp:include page="../include/nav.jsp"></jsp:include>
		<main>
			<div class="container">
				<header class="profile-header">
					<div class="profile-img">
						<img src="/images/${profileRespDto.profile_img}" />
					</div>
					<div class="profile-info">
						<div class="profile-info-top">
							<input type="hidden" id="user-id" value="${profileRespDto.userId}">
							<h1 class="profile-username">${profileRespDto.username}</h1>
							<c:choose>
								<c:when test="${empty principal.user}">
									<button type="button" class="logout-follow-btn">팔로우</button>
								</c:when>
								<c:otherwise>
									<button type="button" class="login-follow-btn">팔로우</button>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="profile-info-middle">
							<div class="profile-info-middle-item">
								게시물 <span id="board-total-count">${profileRespDto.boardTotalCount}</span>
							</div>
							<div class="profile-info-middle-item cursor-pointer">
								팔로워 <span>${profileRespDto.followerCount}</span>
							</div>
							<div class="profile-info-middle-item cursor-pointer">
								팔로우 <span>${profileRespDto.followingCount}</span>
							</div>
						</div>
						<div class="profile-info-bottom">
							<pre>${profileRespDto.introduction}</pre>
						</div>
					</div>
				</header>
				<section>
					<div class="board-menu">
						<div class="board-menu-item">
							<i class="fas fa-table"></i> <span>게시물</span>
						</div>
					</div>
					<div class="board-container">
						
					</div>
				</section>
			</div>
		</main>
	</section>
	<div class="modal-container">
      <i id="close-btn" class="fas fa-times"></i>
      <div class="board-modal-body">
        
      </div>
    </div>
	<input type="hidden" id	="username" value="${profileRespDto.username}">
	<script src="/js/other_profile.js"></script>
</body>
</html>
