/**
 * 프로필 수정
 */
 
const imgFile = document.querySelector('#file');
const profileImgChangeBtn = document.querySelector('.profile-img-change-btn');
const form = document.querySelector('.edit-items');
const profileImg = document.querySelector('#profile_img');
const submitBtn = document.querySelector('edit-submit-btn');

var usernameCheckResult = true;
 
imgFile.style.display = 'none';
 
profileImgChangeBtn.onclick = () => {
	imgFile.click();	
}

imgFile.onchange = () => { /*파일이 바뀌는 이벤트가 발생하면*/
	let reader = new FileReader();
	
	reader.onload = (event) => { // reader.readAsDataURL이 실행된 후
		profileImg.src = event.target.result;
	}
	
	reader.readAsDataURL(imgFile.files[0]);
}

function usernameCheck(username) {
	$.ajax({
		type: "GET",
		url: "/accounts/username-check",
		data: {
			"username": username
		},
		dataType: "text",
		success: function(data) {
			
			usernameCheck = data;
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	})
}

submitBtn.onclick = () => {
	const usernameInput = document.querySelector('#username-ip');
	const principalUsername = document.querySelector('#principal-usename');
	let username = usernameInput.value;
	let pUsername = principalUsername.textContent;
	
	if(username != pUsername) {
		usernameCheckResult = false;
		usernameCheck(username);
	}
	
	if(usernameCheckResult == true) {
		// submit 실행
	}
}