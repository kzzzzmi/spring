<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- scurity-taglib -->

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
	<link rel="stylesheet" href="/css/accounts_menu.css" />
	<link rel="stylesheet" href="/css/accounts_edit.css" />
	<script src="http://code.jquery.com/jquery-latest.min.js" ></script>
</head>

<body>
	<section>
		<jsp:include page="../include/nav.jsp"></jsp:include>
		<main>
			<div class="container">
				<ul class="menu-list">
					<li class="menu-li"><a href="/accounts/edit" class="menu-li-a-select">프로필
							편집</a></li>
					<li class="menu-li"><a href="/accoutns/password/change" class="menu-li-a">비밀번호 변경</a>
					</li>
				</ul>
				<article>
					<div class="edit-profile-img">
						<div class="edit-profile-img-border">
							<img id="profile_img"
								src="/images/${principal.userDtl.profile_img}" />
						</div>
						<div class="username-lb">
							<h1 id="principal-username">${principal.user.username}</h1>
							<div class="profile-img-change-btn">프로필 사진 바꾸기</div>
						</div>
					</div>
					<form enctype="multipart/form-data" action="/accounts/edit"
						method="post" class="edit-items">
						<input type="file" id="file" name="file">
						<!-- input에 file 전달 시 form을 멀티파트로 무조건!!! 바꿔야함 -->
						<div class="edit-item">
							<aside>
								<label for="name-ip" class="edit-lb">이름</label>
							</aside>
							<div class="edit-ip">
								<input type="text" id="name-ip" class="profile-ip" name="name"
									value="${principal.user.name}" />
							</div>
						</div>
						<div class="edit-item">
							<aside>
								<label for="username-ip" class="edit-lb">사용자 이름</label>
							</aside>
							<div class="edit-ip">
								<input type="text" id="username-ip" class="profile-ip" name="username"
									value="${principal.user.username}" />
							</div>
						</div>
						<div class="edit-item">
							<aside>
								<label for="website-ip" class="edit-lb">웹사이트</label>
							</aside>
							<div class="edit-ip">
								<input type="text" id="website-ip" class="profile-ip" name="website"
									value="${principal.userDtl.website}" />
							</div>
						</div>
						<div class="edit-item">
							<aside>
								<label for="introduction-ip" class="edit-lb">소개</label>
							</aside>
							<div class="edit-ip">
								<textarea id="introduction-ip" class="profile-ip" name="introduction">${principal.userDtl.introduction}</textarea>
							</div>
						</div>
						<div class="edit-item">
							<aside>
								<label for="email-ip" class="edit-lb">이메일</label>
							</aside>
							<div class="edit-ip">
								<input type="text" id="email-ip" name="email" class="profile-ip"
									value="${principal.user.email}" />
							</div>
						</div>
						<div class="edit-item">
							<aside>
								<label for="phone-ip" class="edit-lb">전화번호</label>
							</aside>
							<div class="edit-ip">
								<input type="text" id="phone-ip" class="profile-ip" name="phone"
									value="${principal.userDtl.phone}" />
							</div>
						</div>
						<div class="edit-item">
							<aside>
								<label for="gender-ip" class="edit-lb">성별</label>
							</aside>
							<div class="edit-ip">
								<input type="text" list="gender-ip" class="profile-ip" name="gender"
									value="${principal.userDtl.gender}" />
								<datalist id="gender-ip">
									<option value="남성"></option>
									<option value="여성"></option>
									<option value="맞춤 성별"></option>
									<option value="밝히고싶지 않음"></option>
								</datalist>
							</div>
						</div>
						<div class="edit-item">
							<aside></aside>
							<div class="edit-ip">
								<button type="button" class="edit-submit-btn">제출</button>
							</div>
						</div>
					</form>
				</article>
			</div>
		</main>
	</section>
	<script src="/js/accounts_edit.js"></script>
</body>
</html>