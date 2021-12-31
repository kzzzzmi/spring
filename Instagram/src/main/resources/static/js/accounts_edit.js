/**
 * 프로필 수정
 */
 const principalUsername = document.querySelector('#principal-username');
 
const imgFile = document.querySelector('#file');
const profileImgChangeBtn = document.querySelector('.profile-img-change-btn');
const form = document.querySelector('.edit-items');
const profileImg = document.querySelector('#profile_img');
const submitBtn = document.querySelector('.edit-submit-btn');

const profileLabel = document.querySelectorAll('.edit-lb');
const profileInput = document.querySelectorAll('.profile-ip');


var usernameCheckResult = 'true';
 
var imgFileChangeFlag = false;

var profileImgFile = '';
 
imgFile.style.display = 'none';
 
profileImgChangeBtn.onclick = () => {
	imgFile.click();	
}

imgFile.onchange = () => { /*파일이 바뀌는 이벤트가 발생하면*/
	let reader = new FileReader();
	
	reader.onload = (event) => { // reader.readAsDataURL이 실행된 후
		imgFileChangeFlag = true;
		profileImgFile = event.target.result;
		profileImg.src = profileImgFile;
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
		async: false, // 동기식으로 바꿔줌
		success: function(data) {		
			usernameCheckResult = data;
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	})
}

function inputIsEmpty(str, lb) {
	let result = false;
	if(typeof(str) == undefined || str == null || str == '') {
		alert(lb + '은(는) 빈 값일 수 없습니다.');
		return true;
	}
	return result;
}

function multipartSubmit() {
	let formData = new FormData(form);
	
	$.ajax({
		type: "put",
		url: "/accounts/edit",
		data: formData,
		dataType: "text",
		enctype: "multipart/form-data", // multipart form data를 날릴때는 밑의 2개 설정 필수 / 파일 객체는 multipart form data로 data 전달 가능
		processData: false,
		contentType: false,
		success: function(data) {
			if(data == 'true') {
				alert('회원정보 수정 성공');
				const navProfileImg = document.querySelector('#nav-profile-image');
				navProfileImg.src = profileImgFile;
			}
		},
		error: function() {
			alert("비동기 처리 오류");
		}
	})
}

function editSubmit() {
	$.ajax({
		type: "put",
		url: "/accounts/edit",
		data: {
			"name": profileInput[0].value,
			"username": profileInput[1].value,
			"website": profileInput[2].value,
			"introduction": profileInput[3].value,
			"email": profileInput[4].value,
			"phone": profileInput[5].value,
			"gender": profileInput[6].value
		},
		dataType: "text",
		success: function(data) {
			if(data == "true") {
				alert("회원정보 수정 성공");
				principalUsername.textContent = profileInput[1].value;
			} else {
				alert("회원정보 수정 실패");
			}
		},
		error: function() {
			alert("비동기 처리 오류");
		}
	})
}

submitBtn.onclick = () => {
	let username = profileInput[1].value;
	let pUsername = principalUsername.textContent;
	
	if(inputIsEmpty(profileInput[0].value, profileLabel[0].textContent)) {
		return;
	}
	if(inputIsEmpty(profileInput[1].value, profileLabel[1].textContent)) {
		return;
	}
	if(inputIsEmpty(profileInput[4].value, profileLabel[4].textContent)) {
		return;
	}
	
	if(username != pUsername) {
		usernameCheckResult = false;
		usernameCheck(username);
	}
	
	if(usernameCheckResult == 'true') {
		// submit 실행
		if(imgFileChangeFlag == true) {
			// 파일업로드가 필요
			multipartSubmit();
		} else {
			// 파일업로드 불필요
			editSubmit();
		}
	} else {
		alert(username + '은(는) 이미 사용중인 사용자이름 입니다.');
	}
}