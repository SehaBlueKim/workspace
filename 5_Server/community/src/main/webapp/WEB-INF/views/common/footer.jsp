<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- JSTL은 사용되는 JSP 파일마다 작성돼야 한다!! --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    
    <!-- session에 message 속성이 존재하는 경우 alert 창으로 해당 내용 출력 -->    
    <c:if test="${!empty sessionScope.message}">
		<script>
			alert("${message}")
		</script>
		
		<!-- message 1회 출력 후 session 제거 -->
		<c:remove var="message" scope="session"/>
    </c:if>
</footer>