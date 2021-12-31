const uploadFile = document.querySelector('.upload-file');
const addImgBtn = document.querySelector('.add-img-btn');
const uploadImg = document.querySelector('.upload-img');
const imgPreview = document.querySelector('.img-preview');
const imgDeleteBtn = document.querySelector('#img-delete-btn');
const imgAdd = document.querySelector('.img-add');
const uploadContent = document.querySelector('.upload-content');
const uploadSubmitBtn = document.querySelector('.upload-submit-btn');
const form = document.querySelector('form');


imgPreview.style.display = 'none';

var uploadImgFile = '';

uploadFile.onchange = () => {
  let reader = new FileReader();

  reader.onload = (event) => {
    imgPreview.style.display = 'flex';
    imgAdd.style.display = 'none';
    uploadImgFile = event.target.result;
    uploadImg.src = uploadImgFile;
  };

  reader.readAsDataURL(uploadFile.files[0]);
};

addImgBtn.onclick = () => {
  uploadFile.click();
};

imgDeleteBtn.onclick = () => {
  uploadFile.value = '';
  uploadFile.files[0] = null;
  uploadImg.src = null;
  
  imgPreview.style.display = 'none';
  imgAdd.style.display = 'flex';
};


function isEmpty(str) {
	if(typeof(str) == undefined || str == null || str == '') {
		return true;
	} else {
		return false;
	}
}

function uploadSubmit() {
	let formData = new FormData(form); // 파일이 들어있어서 formData가 필요
	
	$.ajax({
		type: "post",
		url: "/upload",
		data: formData,
		dataType: "text",
		enctype: "multipart/form-data", // multipart form data를 날릴때는 밑의 2개 설정 필수 / 파일 객체는 multipart form data로 data 전달 가능
		processData: false,
		contentType: false,
		success: function(data) {
			if(data == 'true') {
				alert('게시글 작성 완료');
				location.replace("/");
			}
		},
		error: function() {
			alert("비동기 처리 오류");
		}
	})
}

uploadSubmitBtn.onclick = () => {
	if(isEmpty(uploadFile.value)) {
		alert('이미지를 추가해주세요.');
	} else if(isEmpty(uploadContent.value)) {
		alert('내용을 입력해주세요.');
	} else {
		uploadSubmit();
	}
}