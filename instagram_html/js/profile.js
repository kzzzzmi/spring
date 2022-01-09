const body = document.querySelector('body');
const modalContainer = document.querySelector('.modal-container');
const modalBtns = modalContainer.querySelectorAll('button');
const settingBtn = document.querySelector('#setting-btn');

settingBtn.onclick = () => {
  modalContainer.classList.toggle('show');

  if (modalContainer.classList.contains('show')) {
    body.style.overflow = 'hidden'; // 스크롤이 멈춤
  }
};

modalContainer.onclick = () => {
  modalContainer.classList.toggle('show');

  if (!modalContainer.classList.contains('show')) {
    body.style.overflow = 'auto';
  }
};

modalBtns[0].onclick = () => {
  location.href = '/accounts/password/change';
};

modalBtns[1].onclick = () => {
  location.replace('/logout');
};
