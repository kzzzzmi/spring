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
    <link rel="stylesheet" href="/css/accounts_password.css" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  </head>

  <body>
    <section>
      <jsp:include page="../include/nav.jsp" />
      <main>
        <div class="container">
          <ul class="menu-list">
            <li class="menu-li">
              <a href="/accounts/edit" class="menu-li-a">프로필 편집</a>
            </li>
            <li class="menu-li">
              <a href="/accounts/password/change" class="menu-li-a-select">비밀번호 변경</a>
            </li>
          </ul>
          <article>
            <div class="password-profile-img">
              <div class="password-profile-img-border">
                <img src="/images/${principal.userDtl.profile_img }" alt="" />
              </div>
              <div class="username-lb">
                <h1>${principal.user.username }</h1>
              </div>
            </div>
            <form action="" class="password-items">
              <div class="password-item">
                <aside>
                  <label for="pre-password-ip" class="password-lb"
                    >이전 비밀번호</label
                  >
                </aside>
                <div class="password-ip">
                  <input type="password" id="pre-password-ip" />
                </div>
              </div>
              <div class="password-item">
                <aside>
                  <label for="new-password-ip" class="password-lb"
                    >새 비밀번호</label
                  >
                </aside>
                <div class="password-ip">
                  <input type="password" id="new-password-ip" />
                </div>
              </div>
              <div class="password-item">
                <aside>
                  <label for="new-repassword-ip" class="password-lb"
                    >새 비밀번호 확인</label
                  >
                </aside>
                <div class="password-ip">
                  <input type="password" id="new-repassword-ip" />
                </div>
              </div>
              <div class="password-item">
                <aside></aside>
                <div class="password-ip">
                  <button type="button" class="password-submit-btn">
                    제출
                  </button>
                </div>
              </div>
            </form>
          </article>
        </div>
      </main>
    </section>
    <script src="/js/accounts_password.js"></script>
  </body>
</html>
    