package edu.kh.control.loop;

import java.util.Scanner;

public class LoopExample2 {


	// 구구단 2단 출력하기
	// 2 x 1 = 2
	// 2 x 2 = 4
	// 2 x 3 = 6
	// 2 x 4 = 8
	// 2 x 5 = 10
	// 2 x 6 = 12
	// 2 x 7 = 14
	// 2 x 8 = 16
	// 2 x 9 = 18
	public void ex1() {

		for(int i=1; i<=9; i++) {
			System.out.printf("2 x %d = %d\n", i, 2*i);
		}
	}



	// 입력 받은 단 출력하기

	// 단 입력 : 3

	// [구구단 3단]
	// 3 x 1 = 3
	// 3 x 2 = 6
	// ...
	// 3 x 9 = 27
	public void ex2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("단 입력 : ");
		int dan = sc.nextInt();

		System.out.println("[구구단 " + dan + "단]");

		for(int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %d\n", dan, i, dan*i);
		}	
	}



	// 입력 받은 단 출력하기
	// 단, 입력 받은 값이 2~9 사이 일때만 구구단 출력
	// 2~9사이가 아닐 경우 "잘못 입력 하셨습니다." 출력

	public void ex3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("단 입력 : ");
		int dan = sc.nextInt();

		// !(dan < 2 || dan > 9)
		if (2<=dan && dan <=9) { // 2~9 사이일 때만
			System.out.println("[구구단 " + dan + "단]");

			for(int i=2; i<=9; i++) {
				System.out.printf("%d x %d = %d\n", dan, i, dan*i);
			}
		} else {
			System.out.println("잘못 입력 하셨습니다.");
		}
	}



	// 중첩 반복문
	// for 예제4 - 구구단 모두 출력하기
	public void ex4() {

		for(int dan = 2; dan <= 9; dan++) { // 2~9단까지 차례로 증가

			// 안쪽 for문이 반복하면서 하나의 단을 한 줄로 출력
			for(int num = 1; num <= 9; num++) { // 각 단에 곱해질 수 1~9
				// 차례대로 증가
				System.out.printf("%2d X %2d = %2d ", dan, num, dan*num);
			}
			System.out.println(); // 아무 내용 없는 println == 줄바꿈
		}
	}



	// 이중 for문 예제5 - 구구단 역순 출력
	// 9단 -> 2단 까지 역방향
	// 곱해지는 수는 1-> 9 까지 정방향
	public void ex5() {

		for(int dan = 9; dan >= 2; dan--) { // 단 출력 9 -> 2

			for(int num = 1; num <= 9; num++) { // 곱해지는 수 출력 1 -> 9
				System.out.printf("%2d X %2d = %2d", dan, num, dan*num);
			}
			System.out.println();
		}
	}



	// for 예제6
	// 12345
	// 12345
	// 12345
	// 12345
	// 12345
	public void ex6() {

		for(int num1 = 1; num1 <= 5; num1++) { // 5퀴 반복하는 for문

			for(int num2 = 1; num2 <= 5; num2++) { // 12345 한 줄 출력하는 for문
				System.out.print(num2);
			}
			System.out.println(); // 줄바꿈
		}
	}



	// 중첩 for 문 예제7
	// 4321
	// 4321
	// 4321
	public void ex7() {

		for(int x = 1; x <= 3; x++) { // 줄 반복

			for(int i = 4; i >= 1; i--) { // 출력 반복
				System.out.print(i);
			}
			System.out.println();
		}
	}



	// for 예제8 - 구구단 출력하기
	// [조건]
	// 1 입력 시 2단 ~ 9단 순서로 출력
	// 2 입력 시 9단 ~ 2단 역순으로 출력
	// 1, 2가 아니라면 "잘못 입력 하셨습니다." 출력
	public void ex8() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1) 2-9 순서대로 / 2) 9-2 역순으로 : ");
		int input = sc.nextInt();

		//switch문
		switch(input) {

		case 1 : 
			for(int dan1 = 2; dan1 <= 9; dan1++) {
				System.out.printf("[%d단]\n",dan1); // 제목 출력
				for(int num1 = 1; num1 <= 9; num1++) {
					System.out.printf("%d x %d = %d\n", dan1, num1, dan1*num1);
				}
				System.out.println("-----------");
			}
			break;

		case 2 : for(int dan = 9; dan >= 2; dan--) {
			System.out.printf("[%d단]\n", dan); // 제목
			for(int num = 1; num <= 9; num++) {
				System.out.printf("%d x %d = %d\n", dan, num, dan*num);
			}
			System.out.println("-----------");
		}
		break;

		default :System.out.println("잘못 입력 하셨습니다.");

		}

		/* if문
		if(input == 1) { // 2-9 순서대로

			for(int dan1 = 2; dan1 <= 9; dan1++) {
				System.out.printf("[%d단]\n",dan1); // 제목 출력
				for(int num1 = 1; num1 <= 9; num1++) {
					System.out.printf("%d x %d = %d\n", dan1, num1, dan1*num1);
				}
				System.out.println("-----------");
			}

		} else if (input == 2) { // 9-2 역순으로

			for(int dan = 9; dan >= 2; dan--) {
				System.out.printf("[%d단]\n", dan); // 제목
				for(int num = 1; num <= 9; num++) {
					System.out.printf("%d x %d = %d\n", dan, num, dan*num);
				}
				System.out.println("-----------");
			}

		} else {
			System.out.println("잘못 입력 하셨습니다.");
		}
		 */
	}



	// for 예제9 - 2중 for문을 이용하여 다음 모양을 출력하시오.

	// 1
	// 12
	// 123
	// 1234
	public void ex9() {

		for(int x = 1; x <= 4; x++) { // 줄 반복

			for(int i = 1; i <= x; i++) { // 출력 반복
				System.out.print(i);
			}
			System.out.println(); // 줄 바꿈
		}
		// x가 1일 때 i == 1
		// x가 2일 때 i == 1, 2
		// x가 3일 때 i == 1, 2, 3
		// x가 4일 때 i == 1, 2, 3, 4
	}


	
	// 4321
	// 321
	// 21
	// 1
	public void ex10() {
	
		for(int x = 4; x >= 1; x--) { // 줄 반복
			
			for(int i = x; i >= 1; i--) { //출력 반복
				System.out.print(i);
			}
			System.out.println();
		}
		// x가 4일 때 i == 4, 3, 2, 1
		// x가 3일 때 i == 3, 2, 1
		// x가 2일 때 i == 2, 1
		// x가 1일 때 i == 1
	}



	// for 예제 11 - 다음과 같은 모양을 출력하시오
	//  1   2   3   4
	//  5   6   7   8
	//  9  10  11  12
	public void ex11() {

		int count = 1;

		for(int x = 1; x <= 3; x++) { // 줄 반복

			for(int i = 1; i <= 4; i++) { // 숫자 출력
				System.out.printf("%3d", count);
				count++;
			}
			System.out.println();
		}
	}



	// 중첩 for문 예제12
	// (0,0) (0,1) (0,2)
	// (1,0) (1,1) (1,2)
	public void ex12() {

		// () 내부 첫번째 칸의 값 0 1
		for(int x = 0; x <= 1; x++) {

			// () 내부 두번째 칸의 값 0 1 2
			for(int i = 0; i <= 2; i++) {
				System.out.printf("(%d,%d)", x, i);
			}
			System.out.println();
		}
	}



	// 1부터 20까지 1씩 증가하면서
	// 3의 배수의 총 개수와 합계 출력

	// 3 6 9 12 15 18 : 6개
	// 3의 배수의 합계 : 63
	public void ex13() {

		int count = 0; // 3의 배수의 개수를 세기 위한 변수
		int sum = 0; // 3의 배수의 합계를 구하기 위한 변수

		for(int i = 1; i <= 20; i++) {
			if(i % 3 == 0) {
				System.out.print(i+" ");
				count++; // if문이 동작할 때마다 1씩 증가
				sum += i; // 3의 배수 누적
			}
		}
		System.out.printf(": %d개", count);
		System.out.printf("\n3의 배수의 합계 : %d", sum);
	}



	// 예제14 - 행/열의 크기를 입력 받아 출력하시오

	// 행 : 2
	// 열 : 3

	// 1 2 3
	// 4 5 6
	public void ex14() {

		Scanner sc = new Scanner(System.in);

		System.out.print("행 : ");
		int row = sc.nextInt();

		System.out.print("열 : ");
		int col = sc.nextInt();

		int count = 0;

		// 초기식, 조건식, 증감식은 상황에 따라서
		// 작성하지 않을 수 있다!

		// for( ; ; ) --> 무한루프 (조건문이 없음 -> false 가 될 수 없음 -> 종료를 못함 -> 무한반복)

		// 초기식 작성 X -> row, col(입력 받은 값) 사용
		for(; row >= 1; row--) { // 2 1 (2바퀴)

			for(int y = col ; y >= 1; y--) { // 3 2 1 (3바퀴)
				System.out.print(++count + " ");
			}
			System.out.println();
		}


		/*
		for(int x = 1; x <= row; x++) { // 줄 반복

			for(int y = 1; y <= col; y++) { // 출력 반복
				System.out.print(++count + " ");
			}
		System.out.println();	
		}*/

	}



}
