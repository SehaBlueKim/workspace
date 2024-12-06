package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {

	public void practice1() {
		// 실습문제 1
		// 키보드로 입력 받은 정수가 양수이면서 짝수일 때만 "짝수입니다."를 출력하고
		// 짝수가 아니면 "홀수입니다."를 출력하세요.
		// 양수가 아니면 "양수만 입력해주세요."를 출력하세요.

		/*
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 한 개 입력하세요 : ");
		int number = sc.nextInt();

		if(number <= 0 ) {
			System.out.println("양수만 입력해주세요.");
		}else {
			if(number % 2 == 0) {
				System.out.println("짝수입니다.");
			}else {
				System.out.println("홀수입니다.");
			}
		}*/


		// 선생님 답안 if 버전
		/*
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 한 개 입력하세요 : ");
		int number = sc.nextInt();

		String result; // 결과 저장용 변수

		if(number > 0) { // 양수라면
			if(number % 2 == 0) {
				result = "짝수 입니다.";
			}else {
				result = "홀수 입니다.";
			}
		}else { // 양수가 아니라면
			result = "양수만 입력해주세요.";
		}

		System.out.println(result);
		 */


		// 선생님 답안 if, else-if, else 버전
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 한 개 입력하세요 : ");
		int number = sc.nextInt();

		if(number > 0 && number % 2 == 0) { // 양수 + 짝수
			System.out.println("짝수 입니다.");

		} else if (number > 0 && number % 2 == 1) { // 양수 + 홀수
			System.out.println("홀수 입니다.");

		} else {
			System.out.println("양수만 입력해주세요.");

		}
	}




	public void practice2 () {
		// 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고
		// 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
		// (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우_

		// 합격 했을 경우 과목 별 점수와 합계, 평균, "축하합니다, 합격입니다!" 를 출력하고
		// 불합격인 경우에는 "불합격입니다."를 출력하세요.

		Scanner sc = new Scanner(System.in);

		System.out.print("국어점수 : ");
		int kor = sc.nextInt();

		System.out.print("수학점수 : ");
		int math = sc.nextInt();

		System.out.print("영어점수 : ");
		int eng = sc.nextInt();

		int sum = kor + math + eng;

		double avg = sum / 3.0;

		if(kor >= 40 && math >= 40 && eng >= 40 && avg >= 60) { // 합격했을 경우
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");

		}else { // 불합격인 경우
			System.out.println("불합격입니다.");

		}

	}



	public void practice3() {

		// 1~12 사이의 수를 입력 받아 해당 달의 일수를 출력하세요.(2월 윤달은 생각하지 않습니다.)
		// 잘못 입력한 경우 "OO월은 잘못 입력된 달입니다."를 출력하세요. (switch문 사용)
		// 31일까지 있는 달 : 1.3.5.7.8.10.12

		Scanner sc = new Scanner(System.in);

		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();

		int day = 0;

		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: day = 31; break;
		case 4: case 6: case 9: case 11: day = 30; break;
		case 2 : day = 28;
		}

		if(day != 0) {
			System.out.printf("%d월은 %d일까지 있습니다.", month, day);
		} else {
			System.out.printf("%d월은 잘못 입력된 달입니다.", month);
		}
	}



	public void practice4() {
		// 키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라
		// 저체중/정상체중/과체중/비만을 출력하세요.

		// BMI = 몸무게 / (키(m)*키(m))
		// BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
		// BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
		// BMI가 30이상일 경우 고도비만

		Scanner sc = new Scanner(System.in);

		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();

		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();

		double BMI = weight / (height * height);

		String result; // 결과 저장용 변수

		if(BMI < 18.5){
			result = "저체중";
		} else if(BMI < 23) {
			result = "정상체중";
		} else if(BMI < 25) {
			result = "과체중";
		} else if(BMI < 30) {
			result = "비만";
		} else {
			result = "고도비만";
		}

		System.out.println("BMI 지수 : " + BMI);
		System.out.println(result);
	}



	/*public void practice5() {
		// 중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
		// 평가 비율은 중간고사 20%, 기말고사 30%, 과제 30%, 출석 20%로 이루어져 있고
		// 이 때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 따진 값으로 계산하세요.
		// 70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요.

		Scanner sc = new Scanner(System.in);

		System.out.print("중간 고사 점수 : ");
		int input1 = sc.nextInt();

		System.out.print("기말 고사 점수 : ");
		int input2 = sc.nextInt();

		System.out.print("과제 점수 : ");
		int input3 = sc.nextInt();

		System.out.print("출석 횟수 : ");
		int input4 = sc.nextInt();
		
		if(input4 <= 20 - (20 * 0.3)) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]", input4);				
		
		}else {

			double score1 = input1 * 0.2;
			double score2 = input2 * 0.3;
			double score3 = input3 * 0.3;
			double score4 = input4 * 1.0;

			double sum = score1 + score2 + score3 + score4;

			System.out.println("중간 고사 점수(20) : " + score1);
			System.out.println("기말 고사 점수(30) : " + score2);
			System.out.println("과제 점수    (30) : " + score3);
			System.out.println("출석 점수    (20) : " + score4);
			System.out.println("총점 : " + sum);

			if(sum < 70){
				System.out.println("Fail [점수 미달]");
			} else {
				System.out.println("PASS");
			}
		}
	}*/
	
	
	// 선생님 답안
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int midTerm = sc.nextInt();
		
		System.out.print("기말 고사 점수 : ");
		int finalTerm = sc.nextInt();
		
		System.out.print("과제 점수 : ");
		int homework = sc.nextInt();
		
		System.out.print("출석 점수 : ");
		int attendance = sc.nextInt();
		
		System.out.println("================ 결과 ================");
		
		// 출석 횟수가 부족한 경우 (6번 이상 결석 == 14번 이하 출석)
		if(attendance <= 20 * (1-0.3)) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]", attendance);
		
		} else { // 출석은 잘 했을 때
			
			// 점수 환산
			double midScore = midTerm * 0.2;
			double finalScore = finalTerm * 0.3;
			double homeworkScore = homework * 0.3;
			double attScore = attendance * 0.2 * 5; // == attendance
			
			// 총점
			double sum = midScore + finalScore + homeworkScore + attScore;
			
			System.out.println("중간 고사 점수(20) : " + midScore);
			System.out.println("기말 고사 점수(30) : " + finalScore);
			System.out.println("과제 점수(30) : " + homeworkScore);
			System.out.println("출석 점수(20) : " + attScore);
			System.out.println("총점 : " + sum);
			
			if(sum >= 70) {
				System.out.println("PASS");
			} else {
				System.out.println("Fail [점수 미달]");
			}
		}
	}
}



