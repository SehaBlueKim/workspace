<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
        
    <!-- 클릭 시 메인 페이지로 이동 -->
    <section>
        <a href="${contextPath}">

            <!-- header를 별도의 jsp로 분리한 경우
                 상대경로로 작성된 이미지의 경로가 일치하지 않게 됨
                 
                 *해결 방법 : 절대경로 사용을 권장
            -->

            <!-- 
                /community
                <%= request.getContextPath()%>
                ${pageContext.servletContext.contextPath}

                위의 3가지 모두 동일한 결과이나 하자가 좀 있다.
                (불편하거나 너무 길거나 작성규칙이 깨짐)
                -> 모든 주소 요청 시 동작하는 EncodingFilter에서
                   application scope에 최상위 주소를 간단히 부를 수 있는 형태로 저장해뒀음
            -->
            <img src="${contextPath}/resources/images/KH-logo.jpg" id="main-logo">
        </a>
    </section>

    <!-- 검색창 -->
    <section>
        <div class="search-area">
            
            <!-- form 내부 input 태그 값을 서버 또는 페이지로 전달 -->
            <form action="#" name="search-form">

                <!-- fieldset : form 태그 내부에서 input을 종류별로 묶는 용도로 많이 사용 -->
                <fieldset>
                    <!-- form 태그 내부 input은 name 속성이 존재해야 값 전달 가능함! -->
                    <input type="text" name="query" id="query"
                            autocomplete="off" placeholder="검색어를 입력해주세요">

                    <button id="search-btn" class="fa-solid fa-magnifying-glass"></button>
                </fieldset>
            </form>

        </div>
    </section>

    <section></section>
</header>