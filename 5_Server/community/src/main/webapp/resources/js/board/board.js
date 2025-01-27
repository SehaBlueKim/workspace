console.log("board.js");

// 상세조회 - 목록으로 버튼
(function(){
    const goToListBtn = document.getElementById("goToListBtn");
    if(goToListBtn != null){
        goToListBtn.addEventListener("click", function(){

            // location 객체(BOM)

            // 문자열.substring(시작, 끝) : 시작 이상 끝 미만 인덱스까지 문자열 자르기

            // 문자열.indexOf("검색 문자열", 시작 인덱스)
            // : 문자열에서 "검색 문자열"의 위치(인덱스)를 찾아서 반환
            // 단, 시작 인덱스 이후 부터 검색

            const pathname = location.pathname; // 주소상에서 요청 경로 반환
            //   /community/board/detail

            let url = pathname.substring(0, pathname.indexOf("/", 1));
            
            url += "/board/list?"
            // /community/board/list?

            // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
            // URL.searchParams : 쿼리스트링만 별도 객체로 반환
            // location.href : 현재 페이지 주소 + 쿼리스트링

            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type");
            const cp = "cp=" + params.get("cp");

            // url 완성하기
            url += type + "&" + cp;
            // /community/board/list?type=1&cp=2

            // location.href="주소"; -> 해당 주소로 이동
            location.href = url;
        })
    }
})();

