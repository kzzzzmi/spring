<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원가입</title>
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/signup.css" />
    <script
      src="https://kit.fontawesome.com/498fda3233.js"
      crossorigin="anonymous"
    ></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  </head>
  
  <body>
    <section>
      <main>
        <div class="su-items">
          <div class="su-items-ip">
            <div class="su-logo">
              <img src="/image/instagram_logo.PNG" alt="로고" />
            </div>
            <div class="su-item">
              <button class="su-submit-btn">
                <i class="fab fa-facebook-square"></i>
                <span>Facebook으로 로그인</span>
              </button>
            </div>
            <div class="su-item">
              <div class="hr-sect"><span>또는</span></div>
            </div>
            <div class="su-login-form">
              <div class="su-item">
                <input
                  type="text"
                  class="su-input"
                  placeholder="휴대폰 번호 또는 이메일 주소"
                />
              </div>
              <div class="su-item">
                <input type="text" class="su-input" placeholder="성명" />
              </div>
              <div class="su-item">
                <input type="text" class="su-input" placeholder="사용자 이름" />
              </div>
              <div class="su-item">
                <input
                  type="password" class="su-input" placeholder="비밀번호"
                />
              </div>
              <div class="su-item">
                <button class="su-submit-btn">가입</button>
              </div>
            </div>
          </div>
          <div class="su-signin">
            <div class="su-signin-text">
              계정이 있으신가요? <a href="/auth/signin">로그인</a>
            </div>
          </div>
          <div class="su-download-text">
            <span>앱을 다운로드하세요.</span>
          </div>
          <div class="su-download-btns">
            <a href="#"
              ><img src="/image/signin_download.PNG" alt="앱스토어에서 다운"
            /></a>
            <a href="#"
              ><img
                src="/image/signin_download2.PNG"
                alt="구글 플레이에서 다운"
            /></a>
          </div>
        </div>
      </main>
    </section>
    <script src="/js/signup.js"></script>
  </body>
</html>
