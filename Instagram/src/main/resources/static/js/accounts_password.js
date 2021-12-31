/**
 * 비밀번호 변경
 */
 
 const passwordSubmitBtn = document.querySelector('.password-submit-btn');
 const prePassword = document.querySelector('#pre-password-ip');
 const newPassword = document.querySelector('#new-password-ip');
 const newRePassword = document.querySelector('#new-repassword-ip');
 
function passwordSubmit() {
	$.ajax({
		type: "PUT",
		url: "/accounts/password/change",
		data: {
			"prePassword": prePassword.value,
			"newPassword": newPassword.value
		},
		dataType: "text",
		success: function(data) {
			let passwordRespObj = JSON.parse(data);
			alert(passwordRespObj.message);
			if(passwordRespObj.code == 200) {
				alert("다시 로그인해주세요.");
				location.replace("/logout"); // replace는 redirect해서 데이터를 없앰 href는 데이터는 살아있음
			}
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	})
}
 
 passwordSubmitBtn.onclick = () => {
	if(newPassword.value != newRePassword.value) {
		alert('새 비밀번호가 일치하지 않습니다.');
		return;
	}
	passwordSubmit();
}