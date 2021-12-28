const inputNames = document.querySelectorAll('.ip-names');
const idCheck = document.querySelector('#id-check');
const signupInputs = document.querySelectorAll(".signup-ip");
const signupForm = document.querySelector("form");
const signupBtn = document.querySelector('#signup-btn');

var idCheckFlag = false;

function usernameCheck() {
	let signupObj = {
		username: signupInputs[0].value,
		password: signupInputs[1].value,
		name: signupInputs[2].value,
		email: signupInputs[3].value
	}
	
	$.ajax({ /* jquery 쌍 따옴표 */
		type: "GET",
		url: "/study/signup/username-check",
		data: signupObj,
		dataType: "text", /*응답 받을때의 타입*/
		success: function(data) { /* 위의 data와 다름, 매개변수임 */
			let signupRespObj = JSON.parse(data); /* Object 형태로 변환시켜줌 */
			
			idCheckFlag = signupRespObj.idCheckFlag;
			
			if(idCheckFlag == true) {
				alert('가입 가능한 아이디입니다!');
			} else {
				alert('이미 존재하는 아이디입니다.');
			}
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	})
}

idCheck.onclick = () => {
	let checkFlag = isEmpty(signupInputs[0], inputNames[0].textContent);
	if(checkFlag != 0) return;
	usernameCheck();
}

function isEmpty(signupInput, inputName) {
	let flag = 0;
	if(signupInput.value.length == 0) {
		flag = 1;
		alert(inputName + '을(를) 입력해주세요.');
	}
	return flag;
}

signupBtn.onclick = () => {
	let checkFlag = 0;
	
	for(let i = 0; i < inputNames.length; i++) {
		checkFlag += isEmpty(signupInputs[i], inputNames[i].textContent);
		if(checkFlag != 0) return;
	}
	
	if(idCheckFlag != true) {
		alert('아이디 중복확인을 해주세요.');
		return; 
	}
	
	signupForm.submit();
}
/*
signupValues[0].onblur = () => {
	const testText = document.querySelector('.test-text');
	//testText.innerHTML = '<a href="#">테스트</a>';
	const aTag = document.createElement('a');
	const aText = document.createTextNode('테스트');
	const aHref = document.createAttribute('href');
	aTag.setAttributeNode(aHref);
	aTag.href = '#';
	aTag.appendChild(aText);
	testText.appendChild(aTag);
}
*/