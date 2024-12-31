console.log("main.js loaded");

// #btn1 요소 클릭 시 이벤트
document.getElementById("btn1").addEventListener("click", function(){
    // location.href;        : 현재 주소 반환
    // location.href = 주소; : 대입된 주소로 이동(GET 방식)
    location.href = "jstl/basic";
})

document.getElementById("btn2").addEventListener("click", () => {
    location.href = "jstl/condition";
})

document.getElementById("btn3").addEventListener("click", function(){
    location.href = "jstl/loop";
})