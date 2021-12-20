const idCheck = document.querySelector('#id-check');
const signupInputs = document.querySelectorAll(".signup-ip");
const idCheckFlag = document.querySelector("#id-check-flag");
const signupForm = document.querySelector("form");
const submitFlag = document.querySelector('#submit-flag');
const signupBtn = document.querySelector('#signup-btn')


if (idCheckFlag.value == 'true') {
	alert('사용 가능한 아이디입니다.');
} else if (idCheckFlag.value == 'false') {
	alert('이미 존재하는 아이디입니다.');
}


idCheck.onclick = () => {
	if (signupInputs[0].value.length == 0) {
		alert('아이디를 입력해주세요!');
	} else {
		submitFlag.value = '1';
		signupForm.submit();
	}
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
	
	checkFlag += isEmpty(signupInputs[0], '아이디'); // 레이블 지정했으면 querySelectorAll로 받을 수 있음
	if(checkFlag != 0) return;
	if(idCheckFlag.value != 'true') {
		alert('아이디 중복확인을 해주세요.');
		return;
	}
	checkFlag += isEmpty(signupInputs[1], '비밀번호');
	if(checkFlag != 0) return;
	checkFlag += isEmpty(signupInputs[2], '이름');
	if(checkFlag != 0) return;
	checkFlag += isEmpty(signupInputs[3], '이메일');
	if(checkFlag != 0) return;
	
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