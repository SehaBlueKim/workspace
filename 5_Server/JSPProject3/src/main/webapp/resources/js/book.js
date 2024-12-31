console.log("book.js 연결")

// 제목 클릭 시
// alert(OOO은 XXX원 입니다.) 출력

const bookTitleList = document.querySelectorAll(".book-title");
// bookTitleList == 배열
// -> 요소를 하나씩 꺼낸 경우 == 제목 td 요소
// -> 요소를 하나씩 꺼내서 클릭된 경우라는 이벤트 리스너 추가

/* for(let bookTitle of bookTitleList){
    bookTitle.addEventListener("click", function(){
        alert(bookTitle.innerHTML + "은(는) " + bookTitle.nextElementSibling.nextElementSibling.innerHTML + "원 입니다.");
    })
} */

for(let title of bookTitleList){
    title.addEventListener("click", e=> {
        // 제목
        const t = e.target.innerHTML;

        // 가격
        // const p = e.target.nextElementSibling.nextElementSibling.innerText;
        
        // data-price 속성 값 얻어오기
        const p = e.target.getAttribute("data-price");

        // alert(t + "은/는 " + p + "원 입니다.");

        // `${백틱}`
        alert(`${t}은/는 ${p}원 입니다.`);
    })
}