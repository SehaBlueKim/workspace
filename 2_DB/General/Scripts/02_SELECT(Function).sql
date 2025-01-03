SELECT *
FROM TB_PROFESSOR ;


-- 1번
SELECT STUDENT_NO 학번 ,STUDENT_NAME 이름 , TO_CHAR(ENTRANCE_DATE,'YYYY-MM-DD') 입학년도
FROM TB_STUDENT 
WHERE DEPARTMENT_NO = 002
ORDER BY ENTRANCE_DATE ASC;



-- 2번
SELECT PROFESSOR_NAME , PROFESSOR_SSN 
FROM TB_PROFESSOR 
WHERE PROFESSOR_NAME NOT LIKE '___';



-- 3번
SELECT PROFESSOR_NAME 교수이름, 
	EXTRACT (YEAR FROM SYSDATE) - SUBSTR(PROFESSOR_SSN,1,2) - 1900 나이
FROM TB_PROFESSOR 
WHERE SUBSTR(PROFESSOR_SSN, 8,1) = 1
ORDER BY 2;

-- 3번 선생님 풀이
SELECT PROFESSOR_NAME 교수이름,
	FLOOR( MONTHS_BETWEEN (SYSDATE, 
			TO_DATE(19 || SUBSTR(PROFESSOR_SSN, 1, 6), 'RRRRMMDD') ) / 12) 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8,1) = 1
ORDER BY 나이;



-- 4번
SELECT SUBSTR(PROFESSOR_NAME, 2) 이름
FROM TB_PROFESSOR ;



-- 5번
SELECT STUDENT_NO , STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT (YEAR FROM(ENTRANCE_DATE)) - SUBSTR(STUDENT_SSN,1,2)-1900 >= 20;

-- 5번 선생님 풀이
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT 
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) -
	EXTRACT(YEAR FROM TO_DATE(SUBSTR(STUDENT_SSN, 1, 6), 'RRMMDD')) > 19;



-- 6번
SELECT TO_CHAR(TO_DATE(20201225),'DAY')
FROM DUAL;



-- 7번
-- 2099년 10월 11일, 2049년 10월 11일
-- 1999년 10월 11일, 2049년 10월 11일
SELECT TO_DATE('99/10/11','YY/MM/DD'), TO_DATE('49/10/11','YY/MM/DD'),
		TO_DATE('99/10/11','RR/MM/DD'), TO_DATE('49/10/11','RR/MM/DD')
FROM DUAL;



-- 8번
SELECT STUDENT_NO , STUDENT_NAME 
FROM TB_STUDENT 
-- WHERE SUBSTR(STUDENT_NO,1,1) != 'A' ;
WHERE STUDENT_NO NOT LIKE 'A%';



-- 9번
SELECT ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178'
GROUP BY STUDENT_NO ; 



-- 10번
SELECT DEPARTMENT_NO 학과번호, COUNT(*) "학생수(명)"
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO 
ORDER BY 1 ;



-- 11번
SELECT COUNT(*)
FROM TB_STUDENT 
WHERE COACH_PROFESSOR_NO IS NULL;



-- 12번
SELECT SUBSTR(TERM_NO,1,4) 년도,ROUND(AVG(POINT),1) "년도 별 평점"
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY 1;



-- 13번 미해결
SELECT DEPARTMENT_NO 학과코드명, COUNT(DECODE(ABSENCE_YN, 'Y', 1)) "휴학생 수"
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO 
ORDER BY 1;

-- 13번 다른 방법
SELECT DEPARTMENT_NO 학과코드명, SUM(DECODE(ABSENCE_YN, 'Y', 1, 0)) "휴학생 수"
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO 
ORDER BY 1;



-- 14번
SELECT STUDENT_NAME 동일이름, COUNT(*) "동명인 수"
FROM TB_STUDENT 
GROUP BY STUDENT_NAME 
HAVING COUNT(*) >= 2
ORDER BY 1;



-- 15번 
SELECT NVL(SUBSTR(TERM_NO,1,4),' ') 년도, NVL(SUBSTR(TERM_NO,5,2),' ') 학기, ROUND(AVG(POINT),1) 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP (SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2));

