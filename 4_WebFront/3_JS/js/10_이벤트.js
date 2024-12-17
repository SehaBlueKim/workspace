// 인라인 이벤트 모델 확인하기

// 버튼의 배경색, 글자색 변경
function test1(item){
    /* button에는 이벤트가 발생한 요소(==button)가 담겨있음 */
    item.style.backgroundColor = "blue";
    item.style.color = "white";
}

// 고전 이벤트 모델 확인하기

// 고전/표준 이벤트 모델은 렌더링(화면 해석하는 것)된 HTML 요소에
// 이벤트 관련 동작을 부여하는 코드

// -> 랜더링 되지 않은 요소에는 이벤트 관련 동작을 추가할 수 없다!!
//    (문제 원인 : HTML 코드 해석 순서가 위-> 아래 이기 때문에)
// --> 해결 방법 : HTML 요소가 먼저 랜더링 된 후 JS 코드 수행하도록 
//                script 구문을 body 태그 닫히기 전으로 올려줌

// console.log(document.getElementById("test2-1"));

document.getElementById("test2-1").onclick = function(){
    // 익명 함수(이벤트 핸들러에 많이 사용)
    alert("고전 이벤트 모델 알림창");
}

// 이벤트 제거
document.getElementById("test2-2").onclick = function(){
    document.getElementById("test2-1").onclick = null;
    alert("test2-1의 이벤트를 제거하였습니다")
}

// 고전 이벤트 모델 단점
// -> 한 요소에 동일한 이벤트 리스너(onclick)에 대한
//    다수의 이벤트 핸들러(배경색 변경, 폰트 변경)를 작성할 수 없다.
//    (작성 시 마지막으로 해석된 이벤트 핸들러만 적용됨)
document.getElementById("test2-3").onclick = function(event){

    // 버튼 색 바꾸기
    // 방법 1) 요소를 문서에서 찾아서 선택
    // document.getElementById("test2-3").style.backgroundColor = "blue";

    // 방법 2) 매개변수 e 또는 event 활용하기
    // -> 이벤트 핸들러에 e 또는 event를 작성하는 경우
    //    해당 이벤트와 관련된 모든 정보가 담긴 이벤트 객체가 반환된다
    // console.log(event);

    // event.target : 이벤트가 발생한 요소
    // event.target.style.backgroundColor = 'skyBlue';

    // 방법 3) this 활용하기 -> 이벤트가 발생한 요소(== event.target)
    // console.log(this);
    this.style.backgroundColor = 'cornflowerBlue';
}

/* document.getElementById("test2-3").onclick = function(){
    document.getElementById("test2-3").style.fontSize = "30px";
} */

// 표준 이벤트 모델
document.getElementById("test3").addEventListener("click", function(){

    // this : 이벤트가 발생한 요소
    console.log(this.clientWidth); // 현재 요소의 너비(테두리 제외)

    // 현재 요소의 너비를 300px로 변경
    // this.style.width = "300px";

    this.style.width = this.clientWidth + 20 + 'px';
})

// test3에 이미 click 이벤트에 대한 동작이 존재하는데, 중복해서 적용해보도록 하자
document.getElementById("test3").addEventListener("click", function(){
    this.style.height = this.clientHeight + 20 + 'px';
})

/* 복습 문제 */
/* 
document.getElementById("changeBtn1").addEventListener("click", function(){
    
    document.getElementById("div1").style.backgroundColor 
    = document.getElementById("input1").value;
})
*/

// input1에 값이 변경되었을 때 입력된 값으로 배경색 변경
// 변경된 후 작성된 값 초기화
document.getElementById("input1").addEventListener("change", function(){
    // change 이벤트
    // - text 관련 input 태그는
    //   입력된 값이 변할 때 change라고 하지 않고
    //   입력이 완료된 후 포커스를 잃거나, 엔터를 입력하는 경우에
    //   입력된 값이 이전과 다를 경우 change 이벤트가 발생한 걸로 인식함
    document.getElementById("div1").style.backgroundColor
    = this.value;

    this.value = '';
})