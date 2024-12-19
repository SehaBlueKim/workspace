document.getElementById("btn1").addEventListener("click", function(){
    
    // #test의 자식 "노드"를 모두 얻어오기 (요소 말고 노드)
    // - 요소.childNodes : 요소의 자식 노드를 모두 반환
    const nodeList = document.getElementById("test").childNodes;
    console.log(nodeList);

    // 노드 탐색

    // 1) 부모 노드 탐색 : parentNode
    const li1 = document.getElementById("li1");
    console.log(li1.parentNode); // ul#test 가 나옴

    // 부모 노드의 배경색 변경
    li1.parentNode.style.backgroundColor = "skyblue";

    // 부모 노드 마지막에 새로운 노드 추가
    // (append : (마지막에)덧붙이다)
    li1.parentNode.append("ABCDE");

    // 2) 첫 번째 자식 노드 탐색 : firstChild
    const ul = document.getElementById("test");
    console.log(ul.firstChild);

    // 3) 마지막 자식 노드 탐색 : lastChild
    console.log(ul.lastChild);

    // 4) 중간에 존재하는 자식 노드 탐색 : 부모요소.childNodes[인덱스]
    console.log(nodeList[11]);
    nodeList[11].append("12345");

    // 5) 이전 형제 노드 탐색 : previousSibling
    //    다음 형제 노드 탐색 : nextSibling
    console.log(nodeList[8].previousSibling);
    console.log(nodeList[8].nextSibling);

    // 노드 탐색을 위한 구문은 연달아서 사용 가능
    console.log(nodeList[8].previousSibling.previousSibling.previousSibling);
})

// Element 탐색 확인
document.getElementById("btn2").addEventListener("click", function(){

    // #test의 모든 자식 요소 반환
    const list = document.getElementById("test").children;
    console.log(list);

    // #test의 첫 번쨰 자식 요소
    document.getElementById("test").firstElementChild.style.backgroundColor = "blue";

    // #test의 마지막 자식 요소
    document.getElementById("test").lastElementChild.style.color = "red";

    // #test의 자식 중(list) 2번째 인덱스의 이전/다음 형제 요소
    list[2].previousElementSibling.addEventListener("click", function(){
        alert("2번 인덱스의 이전 형제 요소를 클릭하셨습니다")
    })

    // #test의 자식 중(list) 2번째 인덱스의 이전/다음 형제 요소
    list[2].nextElementSibling.addEventListener("click", function(){
        alert("2번 인덱스의 다음 형제 요소를 클릭하셨습니다")
    })

    console.log(prevEl(list[1]));
    console.log( prevEl(prevEl(list[2]) ) ); // 이전의 이전 요소 선택
    console.log(nextEl(list[2]));
})

// 이전 형제 요소 선택 함수
function prevEl(el){
    return el.previousElementSibling;
}

// 다음 형제 요소 선택 함수
function nextEl(el){
    return el.nextElementSibling;
}

let count1 = 1;
// innerHTML 버튼 클릭 시
document.getElementById("btn3-1").addEventListener("click", function(){

    const div = document.getElementById("div3-1");

    if(count1 <= 10){
        div.innerHTML += "<div>"+ count1++ +"</div>";
    }
})

let count2 = 1;
// createElement 버튼 클릭 시
document.getElementById("btn3-2").addEventListener("click", function(){
    
    const div = document.getElementById("div3-2");

    // createElement를 이용해서 div 요소를 생성해보자

    // document.createElement("태그명") : 해당 태그 요소를 생성해서 반환
    const child = document.createElement("div"); // div 생성만 하고 화면 배치는 아직 안한 상태

    if(count2 <= 10){
        // #div3-2의 마지막 자식 요소로 추가(append)하겠다
        div.append(child);

        // 만들어진 div(즉 child)에 내용 추가하겠다
        child.innerText = count2++;
    }
})

document.getElementById("temp").addEventListener("click", function(){
    alert("temp 클릭");
})