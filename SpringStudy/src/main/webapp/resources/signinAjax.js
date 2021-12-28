const signinInputs = document.querySelectorAll('.signin-ips');
const signinBtn = document.querySelector('.signin-btn');
const inputNames = document.querySelectorAll('.ip-names');

function signin() {
	let signinObj = {
		username: signinInputs[0].value,
		password: signinInputs[1].value
	};
	
	$.ajax({
		type: "POST",
		url: "/study/signin/ajax",
		data: JSON.stringify(signinObj),
		contentType: "application/json; charset:UTF-8", /*JSON으로 전달할 때 쓰는 방식*/
		dataType: "text",
		success: function(data) {
			let signinRespObj = JSON.parse(data);
			let signinFlag = signinRespObj.signinFlag;
			if(signinFlag == 0) {
				alert('존재하지 않는 아이디입니다.');
			} else if(signinFlag == 1) {
				alert('비밀번호가 틀렸습니다.');
			} else {
				alert('로그인 성공 !!');
				location.replace('/study/index');
			}
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	});
}

function isEmpty(signupInput, inputName) {
	let flag = 0;
	if(signupInput.value.length == 0) {
		flag = 1;
		alert(inputName + '을(를) 입력해주세요.');
	}
	return flag;
}

signinBtn.onclick = () => {
	for(let i = 0; i < signinInputs.length; i++) {
		let emptyCheck = isEmpty(signinInputs[i], inputNames[i].textContent);
		if(emptyCheck != 0) {
			return;
		}
	}
	signin();
}