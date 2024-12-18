// 문자열 관련 함수
document.getElementById("btn1").addEventListener("click", function(){

    // 문자열.indexOf("str")
    // 문자열에서 "str"과 일치하는 부분이 시작되는 인덱스를 반환
    // 없으면 -1 반환

    const str1 = "Hello World";
    console.log(str1.indexOf("e")); // 1
    console.log(str1.indexOf("l")); // 2(가장 먼저 검색된 인덱스 반환)
    console.log(str1.indexOf("f")); // -1(없는 값이라 -1 반환)

    // 문자열.substring(시작인덱스, 종료인덱스(미포함)) : 문자열 일부 잘라내기
    // - 시작 이상 종료 미만
    const str2 = "abcdefg";

    console.log(str2.substring(0,3)); // abc (0번째 a ~ 2번째 c)
    console.log(str2.substring(2,6)); // cdef

    // 문자열.split("구분자") : 문자열을 "구분자"로 잘라서 배열로 반환

    const str3 = "햄버거, 쫄면, 파스타, 돈까스, 피자, 치킨";

    const arr = str3.split(", ");
    console.log(arr);
})

// 숫자 관련 함수
document.getElementById("btn2").addEventListener("click", function(){

    // Infinity 리터럴 확인
    console.log(5/0);

    if(10/0 == Infinity){
        console.log("무한");
    }

    // NaN 리터럴 확인
    console.log("abc" * 100); // NaN

    // if("abc"*100 == NaN){ <- false 뜸

    // isNaN(값) : 값이 NaN이면 true, 아니면 false
    if(isNaN("abc")){
        console.log("숫자가 아닙니다");
    }

    // Math.random() : 0 이상 1 미만의 난수 발생 (0 <= random < 1)
    this.innerText = Math.random();

    // 소수점 관련 함수
    // round(), ceil(), floor(), trunc()
    // 반올림    올림     내림    버림(절삭)
    // -> 소수점 자리 지정 불가

    console.log(Math.round(55.5)); // 56
    console.log(Math.ceil(55.5)); // 56

    console.log(Math.floor(-55.5)); // -56
    console.log(Math.trunc(-55.5)); // -55

    // 버튼 배경색 랜덤으로 바꾸기
    const r = Math.floor(Math.random() * 256); // 0~255
    const g = Math.floor(Math.random() * 256); // 0~255
    const b = Math.floor(Math.random() * 256); // 0~255

    this.style.backgroundColor = "rgb(" + r + "," + g + "," + b + ")";

    // 숫자.toFixed(자릿수) : 지정된 자릿수까지 반올림해서 표현
    console.log((2.55).toFixed(1));
    console.log((1.45).toFixed(1));
})

// 형변환 확인
document.getElementById("btn3").addEventListener("click", function(){

    console.log(parseInt("1.234"));
    console.log(parseFloat("1.234"));
    console.log(Number("1.234"));
})

// 동등/동일 확인
document.getElementById("btn4").addEventListener("click", function(){

    console.log(1 == '1'); // true
    console.log(1 === '1'); // false

    console.log(1 == true); // true
    console.log(1 === true); // false
})
