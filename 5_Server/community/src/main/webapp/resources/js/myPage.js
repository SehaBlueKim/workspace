console.log("myPage.js loaded");

function infoValidate(){
    memberNickname = document.getElementById("memberNickname");
    memberTel = document.getElementById("memberTel");

    const regExp1 = /^(\d|\w|[가-힣]){2,10}$/;
    const regExp2 = /^0(1[01]|2|[3-6][1-5]|70)\d{7,8}$/;

    // 닉네임 미작성시
    if(memberNickname.value.trim() == ""){
        alert("닉네임을 입력해주세요.");
        memberNickname.focus();
        return false;
    }

    // 닉네임이 유효하지 않은 경우
    if(!regExp1.test(memberNickname.value)){
        alert("닉네임은 영어/숫자/한글 2~10글자 사이로 작성해주세요.");
        memberNickname.focus();
        return false;
    }

    if(memberTel.value.trim() == ""){
        alert("전화번호를 입력해주세요.(- 제외)");
        memberTel.focus();
        return false;
    }

    // 전화번호가 유효하지 않은 경우
    if(!regExp2.test(memberTel.value)){
        alert("전화번호 형식이 올바르지 않습니다.");
        memberTel.focus();
        return false;
    }
}

// 경고 출력 + 포커스 + return false 해주는게 자꾸 반복되니까 함수로 만들어버리자
function printFocus(msg, el){
    alert(msg);
    el.focus();
    return false;
}

// 비밀번호 변경 제출 시 유효성 검사
function changePwValidate(){
    const currentPw = document.getElementById("currentPw");
    const newPw = document.getElementById("newPw");
    const newPwConfirm = document.getElementById("newPwConfirm");

    const regExp = /^[a-z0-9!@#\-_]{6,30}$/i;

    // 비밀번호 미작성 시
    if(currentPw.value == ""){
        return printFocus("현재 비밀번호를 입력해주세요.", currentPw);
    }

    // 새 비밀번호 미작성 시
    if(newPw.value.trim() == ""){
        return printFocus("새 비밀번호를 입력해주세요.", newPw);
    }
    
    // 새 비밀번호 확인 미작성 시
    if(newPwConfirm.value.trim() == ""){
        return printFocus("새 비밀번호 확인을 입력해주세요.", newPwConfirm);
    }
    
    // 새 비밀번호가 유효하지 않은 경우
    if(!regExp.test(newPw.value)){
        return printFocus("영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.", newPw);
    }

    // 새 비밀번호와 새 비밀번호 확인이 일치하지 않는 경우
    if(newPw.value != newPwConfirm.value){
        return printFocus("새 비밀번호가 일치하지 않습니다.", newPwConfirm);
    }
}

// 회원 탈퇴 유효성 검사
function secessionValidate(){
    const memberPw = document.getElementById("memberPw");
    const agree = document.getElementById("agree");

    // 현재 비밀번호 미작성 시
    if(memberPw.value == ""){
        return printFocus("비밀번호를 입력해주세요.", memberPw);
    }

    // 약관 동의 체크박스
    if(!agree.checked){
        alert("약관 동의 후 탈퇴 버튼을 클릭해주세요.");
        return false;
    }

    if(!confirm("정말 탈퇴하시겠습니까?")){ // 취소를 누른 경우
        return false;
    }
}