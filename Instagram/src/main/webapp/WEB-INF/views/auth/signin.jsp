<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Instagram</title>
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/signin.css" />
</head>

<body>
	<section>
		<main>
			<article>
				<div class="si-title-img">
					<img src="/image/signin_title.PNG" alt="이미지" width="350px" />
				</div>
				<div class="si-items">
					<div class="si-items-ip">
						<div class="si-logo">
							<img src="/image/instagram_logo.PNG" alt="로고" />
						</div>
						<div class="si-login-form">
							<form action="/auth/signin" method="POST">
								<div class="si-item">
									<input type="text" class="si-input" name="username"
										placeholder="전화번호, 사용자 이름 또는 이메일" />
								</div>
								<div class="si-item">
									<input type="password" class="si-input" name="password" placeholder="비밀번호" />
								</div>
								<div class="si-item">
									<button class="si-submit-btn">로그인</button>
								</div>
							</form>
							<div class="si-item">
								<div class="hr-sect">
									<span>또는</span>
								</div>
							</div>
							<div class="si-item">
								<a href="/oauth2/authorization/naver" class="si-facebook"> 
								<i class="fab fa-facebook-square"></i> <span>Facebook으로 로그인</span>
								</a>
							</div>
							<div class="si-item">
								<div class="si-message"></div>
							</div>
							<div class="si-item">
								<a href="#" class="si-find-password">비밀번호를
									잊으셨나요?</a>
							</div>
						</div>
					</div>
					<div class="si-signup">
						<div class="si-signup-text">
							계정이 없으신가요? <a href="/auth/signup">가입하기</a>
						</div>
					</div>
					<div class="si-download-text">
						<span>앱을 다운로드하세요.</span>
					</div>
					<div class="si-download-btns">
						<a href="#"><img
							src="/image/signin_download.PNG" alt="앱스토어에서 다운" /></a>
						<a href="#"><img
							src="/image/signin_download2.PNG" alt="구글 플레이에서 다운" /></a>
					</div>
				</div>
			</article>
		</main>
		<footer></footer>
	</section>
	<script src="https://kit.fontawesome.com/498fda3233.js"
		crossorigin="anonymous"></script>
</body>
</html>
