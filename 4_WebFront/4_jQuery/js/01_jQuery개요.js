// JS와 jQuery 차이점

// 배경 : pink
// 글자색 : white
// 글자 크기 : 24px

// Javascript 버전
document.querySelector("#jsBtn").addEventListener("click", function(){
    this.style.backgroundColor = "pink";
    this.style.color = "white";
    this.style.fontSize = "24px";
})

// jQuery 버전
$("#jQueryBtn").on("click", function(){
    $(this).css("backgroundColor", "lightblue").css("color", "white").css("fontSize", "24px");
})

// window.onload 확인해보기
window.onload = function(){ // 문서 로딩이 완료된 후 수행
    console.log(1);
}

// window.onload 중복으로 작성해보기
window.onload = function(){ // 앞서 작성한 window.onload를 덮어씌우는걸 볼 수 있다
    console.log(3);
}

console.log(2);

// ready() 함수 확인하기
$(document).ready(function(){ // 문서가 준비되면 이 함수를 수행하겠다
    $("#readyTest").on("click", function(){
        alert("ready 함수 확인")
    })
})

// ready() 중복 작성해보기 -> 작성된 모든 ready 내용 적용된다!
$(document).ready(function(){
    $("#readyTest").css("color", "red");
})

// ready() 함수의 다른 형태
$(function(){
    console.log("ready() 함수의 다른 형태");
})

// ready() + 화살표 함수
$(() => {console.log("화살표 함수도 가능")})