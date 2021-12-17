const username = document.querySelector("#username");
const idCheck = document.querySelector("#idCheck");
const signupValues = document.querySelectorAll(".signup-ip");

idCheck.onclick = () => {
	alert("아이디 : " + username.value);
	for (let i = 0; i < signupValues.length; i++) {
		alert(signupValues[i].value);
	}
}

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