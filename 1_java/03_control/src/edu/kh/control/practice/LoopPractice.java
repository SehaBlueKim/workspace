package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {



	public void practice1() {
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		// 만일 1 미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요"를 출력하세요.
		Scanner sc = new Scanner(System.in);

		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if(input <= 0) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}
		}
	}




	public void practice2() {
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		Scanner sc = new Scanner(System.in);

		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if(input >= 1) {
			for(int i = input; i >= 1; i--) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}



	public void practice3() {
		// 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();

		int count = 0;

		for(int i = 1; i <= input; i++) { // 출력 반복

			if(i < input) { // 마지막 바퀴가 아닐 때
				System.out.print(i + " + ");

			} else { // 마지막 바퀴
				System.out.print(i + " = ");
			}
			count += i;
		}
		System.out.println(count);
	}



	public void practice4() {
		// 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		// 만일 1 미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요"를 출력하세요.
		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 숫자 : ");
		int input1 = sc.nextInt();

		System.out.print("두 번째 숫자 : ");
		int input2 = sc.nextInt();

		// 입력 받은 두 수가 모두 1 이상인가?
		if(input1 >= 1 && input2 >= 1) {

			// 작은 수 부터 큰 수까지 1씩 증가하며 반복

			if(input1 > input2) {
				// 먼저 입력한 수가 더 큰 경우
				// 두 변수의 값 교환 (임시 변수 필요)
				int temp = input1;
				input1 = input2;
				input2 = temp;
			}

			for(int i=input1; i<=input2; i++) {
				System.out.print(i + " ");
			}
		}



		/*
		// 입력 받은 두 수가 모두 1 이상인지 먼저 확인
		if(input1 <= 0 || input2 <= 0) {
			System.out.println("1 이상의 숫자를 입력해주세요.");

		} else if(input1 > input2) {
			for(; input2 <= input1; input2++) {
				System.out.print(input2 + " ");
			}
		} else if(input1 < input2) {
			for(; input1 <= input2; input1++) {
				System.out.print(input1 + " ");
			}
		}*/
	}



	public void practice5() {
		// 사용자로부터 입력 받은 숫자의 단을 출력하세요.
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int dan = sc.nextInt();

		System.out.println("===== " + dan + "단 =====");

		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan*i);
		}
	}



	public void practice6() {
		// 사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
		// 단, 2~9를 사이가 아닌 수를 입력하면 "2~9 사이 숫자만 입력해주세요"를 출력하세요.
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int dan = sc.nextInt();

		if(dan < 2 || dan > 9) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");

		} else {
			for(int x=dan; x<=9; x++) {

				System.out.println("===== " + x + "단 =====" );
				for(int i=1; i<=9; i++) {
					System.out.printf("%d * %d = %d\n", x, i, x*i);
				}
			}
		}
	}



	public void practice7() {
		// 다음과 같은 실행 예제를 구현하세요.

		// ex.
		// 정수 입력 : 4
		// *
		// **
		// ***
		// ****

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		for(int x=1; x<=input; x++) { // 줄 반복

			for(int i=1; i<=x; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}



	public void practice8() {
		// 다음과 같은 실행 예제를 구현하세요.

		// ex.
		// 정수 입력 : 4
		// ****
		// ***
		// **
		// *
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		for(int x=input; x>=1; x--) {

			for(int i=x; i>=1; i--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}



	public void practice9() {
		// 다음과 같은 실행 예제를 구현하세요.

		// ex.
		// 정수 입력 : 4 
		//    *
		//   **
		//  ***
		// ****
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		for(int x=1; x<=input; x++) {

			// 1) for문 하나 더 작성하는 방법

			// * 1개 출력 전에 띄어쓰기 3번
			// * 2개 출력 전에 띄어쓰기 2번
			// * 3개 출력 전에 띄어쓰기 1번
			// * 4개 출력 전에 띄어쓰기 0번

			/*
			for(int i=1; i<=input-x; i++) {
				System.out.print(" ");
			}

			for(int i=1; i<=x; i++) {
				System.out.print("*");
			}

			System.out.println();
			 */

			// 2) for + if else 으로 작성하는 방법
			for(int i=1; i<=input; i++) {

				if(i <= input - x) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}



	public void practice10() {
		// 다음과 같은 실행 예제를 구현하세요.

		// ex.
		// 정수 입력 : 3
		// *
		// **
		// ***
		// **
		// *
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		// 위쪽 삼각형
		for(int x=1; x<=input; x++) {

			for(int y=1; y<=x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 아래쪽 삼각형
		for(int y=input-1; y>=1; y--) {
			for(int i=1; i<=y; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}



	public void practice11() {
		// 다음과 같은 실행 예제를 구현하세요.

		// ex.
		// 정수 입력 : 4
		//    *
		//   ***
		//  *****
		// *******
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		// 선생님 답안 (훨씬 짧고 간결하다)
		for(int x=1; x<=input; x++) { // 입력 받은 input만큼 줄 반복

			// 공백 출력 for문
			for(int i=input-x; i>=1; i--) {
				System.out.print(" ");
			}

			// * 출력 for문
			// 1 3 5 7 9
			for(int i=1; i<=2 * x - 1; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

		/* 내 답안
		for(int x=1; x<=input; x++) { // 입력 받은 input만큼 줄 반복

			for(int i=1; i<=input-x; i++) { // 공백
				System.out.print(" ");
			}
			for(int i=1; i<=x; i++){ // 첫 번째 삼각형
				System.out.print("*");
			}
			for(int i=1; i<=x-1; i++) { // 두 번째 삼각형
				System.out.print("*");
			}
			System.out.println();
		}*/
	}



	public void practice12() {
		// 정수 입력 : 5
		// *****
		// *   *
		// *   *
		// *   *
		// *****
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		// row : 행(줄)
		// col(column) : 열(칸)

		// 선생님 답
		for(int row=1; row<=input; row++) {

			for(int col=1; col<=input; col++) {
				
				// 테두리만 * 출력
				// row 또는 col이 1 또는 input인 경우에만 * 출력
				if(row == 1 || row == input || col == 1 || col == input) {
					System.out.print("*");			

				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		/* 내 답안
		for(int x=1; x<=input; x++) { // 입력 받은 input만큼 줄 반복

			if(x==1 || x==input) { // 첫 번째 줄과 마지막 줄만 출력
				for(int i=1; i<=input; i++) {
					System.out.print("*");				
				}

			} else { // 그 외의 줄 출력
				System.out.print("*");
				for(int i=1; i<=input-2;i++)
					System.out.print(" ");
				System.out.print("*");
			}
			System.out.println();
		}*/
	}
	
	
	
	public void practice13() {
		// 1부터 사용자에게 입력 받은 수까지 중에서
		// 1) 2와 3의 배수를 모두 출력하고
		// 2) 2와 3의 공배수의 개수를 출력하세요.
		// * '공배수'는 둘 이상의 수의 공통인 배수라는 뜻으로
		// 어떤 수를 해당 수들로 나눴을 때 모두 나머지가 0이 나오는 수
		
		// ex.
		// 자연수 하나를 입력하세요 : 15
		// 2 3 4 6 8 9 10 12 14 15
		// count : 2
		Scanner sc = new Scanner(System.in);
		
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		
		int count = 0;
		
		for(int i=1; i<=input; i++) {
			
			// i가 2의 배수 또는 3의 배수인 경우만 출력
			if(i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");

				// 2와 3의 공배수인 경우
				if (i % 2 == 0 && i % 3 == 0) {
					count++;
				}
			}
		}
		System.out.print("\ncount : " + count);
	}


}// class

