<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>시맨틱태그</title>
    <link rel="stylesheet" href="/community/resources/css/main-style.css">
    <script src="https://kit.fontawesome.com/d7dbfff85e.js" crossorigin="anonymous"></script>
</head>

<body>
        
    <main>

        <header>
            
            <!-- 클릭 시 메인 페이지로 이동 -->
            <section>
                <a href="#">
                    <img src="resources/images/KH-logo.jpg" id="main-logo">
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

        <!-- 네비게이터 -->
        <nav>
            <ul>
                <li><a href="#">공지사항</a></li>
                <li><a href="#">자유게시판</a></li>
                <li><a href="#">질문게시판</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">1:1 문의</a></li>
            </ul>
        </nav>

        <!-- 컨텐츠 -->
        <section class="content">
            <section class="content-1">
            
            	loginMember : ${sessionScope.loginMember}
            	
            	<hr>
            	
            	message : ${sessionScope.message}
            </section>
            
            <section class="content-2">
            	
            	<c:choose>
            		<%-- choose 내부에는 jsp 주석만 사용 가능하다! --%>
            		<c:when test="${empty sessionScope.loginMember}">
	            		<!-- 현재 위치 : /community/index.jsp -->
		            	<!-- 목표 위치 : /community/member/login -->
		            	
		                <form action="member/login" name="login-form" method="post">
		                    <!-- 아이디/비밀번호/로그인 버튼 영역 -->
		                    <fieldset id="id-pw-area">
		                        <section>
		                            <input type="text" placeholder="아이디" name="inputEmail">
		                            <input type="password" placeholder="비밀번호" name="inputPw">
		                        </section>
		                        <section>
		                            <button>로그인</button>
		                        </section>
		                    </fieldset>
		        
		                    <!-- 회원가입 / ID/PW 찾기 영역 -->
		                    <article id="signup-find-area">
		                        <a href="#">회원가입</a>
		                        <span>|</span>
		                        <a href="#">ID/PW 찾기</a>
		                    </article>
		                    
		                    <label>
		                    	<input type="checkbox">아이디 저장
		                    </label>
		                </form>
            		</c:when>
            		
            		<%-- 로그인이 되어있는 경우 --%>
            		<c:otherwise>
            			<article class="login-area">
                            <!-- 회원 프로필 이미지 -->
                            <a href="#">
                                <img src="resources/images/user.png" id="member-profile">
                            </a>

                            <!-- 회원 정보 + 로그아웃 버튼 -->
                            <div class="my-info">
                                <div>
                                    <a href="#" id="nickname">${loginMember.memberNickname}</a>
                                    <a href="/community/member/logout" id="logout-btn">로그아웃</a>
                                </div>
                                <p>
                                    ${loginMember.memberEmail}
                                </p>
                            </div>
                        </article>
            		</c:otherwise>
            	</c:choose>
            	
            	
            </section>
        </section>

    </main>
    
    <!-- 풋터 -->
    <footer>
        <div>Copyright &copy; KH Information Educational Institute G-Class</div>
        <article>
            <a href="#">프로젝트 소개</a>
                <span>|</span>
            <a href="#">이용약관</a>
                <span>|</span>
            <a href="#">개인정보처리방침</a>
                <span>|</span>
            <a href="#">고객센터</a>
        </article>
    </footer>
</body>

</html>