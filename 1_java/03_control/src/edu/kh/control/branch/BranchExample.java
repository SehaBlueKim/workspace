package edu.kh.control.branch;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class BranchExample {

	// 분기문
	// break : 가장 가까운 반복문을 멈춤
	// continue : 가장 가까운 반복문의 시작 부분으로 이동 (다음 반복을 진행한다)

	public void ex1() {		
		for(int i=1; i<=10000; i++) {

			// 홀수인 경우 출력 안하고 다음 반복으로 넘어감
			if(i % 2 == 1) {
				continue;
			}
			System.out.print(i + " ");

			// i가 20인 경우 반복을 멈춤
			if(i>=20) {
				break;
			}
		}
	}



	public void ex2() {
		// 1 ~ 100까지 1씩 증가하며 출력하는 반복문
		// 단, 5의 배수는 건너뛰고
		// 증가하는 값이 40이 되었을 때 반복을 멈춤
		for(int i=1; i<=100; i++) {

			if(i == 40) { // 40이 되면 반복을 멈춤
				break;
			}

			if(i % 5 == 0) { // 5의 배수가 아니라면 출력
				continue;
			}
			System.out.print(i + " ");	
		}
	}


	// 중첩 반복문 내부에서 break 사용하기

	// 구구단 2~9단까지 모두 출력
	// 단, 2단은 x2까지, 3단은 x3까지 ... 9단은 x9까지만 출력

	// 2 x 1 = 2 2 x 2 = 4
	// 3 x 1 = 3 3 x 2 = 6 3 x 3 = 9
	public void ex3() {

		for(int dan=2; dan<=9; dan++) {

			for(int i=1; i<=9; i++) {
				System.out.printf("%d x %d = %d ", dan, i, dan*i);

				if(dan==i) { // 단과 곱해지는 수가 같을 경우
					break;
					// 분기문이 중첩 반복문 내에서 사용되면
					// 가장 가까운 반복문에 작용한다!
				}
			}
			System.out.println();
		}
	}



	// col이 3의 배수인 경우 출력 X
	// row가 3일 때 반복 종료
	public void ex4() {
		for(int row=1; row<=6; row++) {

			for(int col=1; col<=10; col++) {
				if(col % 3 == 0) { // col이 3의 배수인 경우 출력 X
					continue; // 다음 반복을 수행한다
				}
				System.out.printf("(%d, %d)", row, col);
			}
			System.out.println();

			if(row == 3) { // row가 3일 때 반복 종료
				break;
			}
		}
	}



	// 0이 입력될 때 까지 모든 정수의 합 구하기
	public void ex5() {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int input = 0;

		// 방법 1. while : input에 초기값을 0이 아닌 다른 값을 넣기

		// 방법 2. do-while

		// 방법 3. while(무한루프) + break

		while(true) { // 무한 반복(무한 루프)
			System.out.print("정수 입력 : ");
			input = sc.nextInt();

			if(input== 0) {
				break; // 0 입력 시 반복문 종료
			}
			sum += input;
		}

		System.out.print("합계 : " + sum);
		// Unreachable code : 도달할 수 없는 코드
	}



	/*1번째 입력 : 1000
	 *** 1 ~ 100 사이 수를 입력해주세요 ***
	 1번째 입력 : 51
	 DOWN
	 2번째 입력 : 27
	 UP
	 3번째 입력 : 40
	 [정답!!!]
	 총 입력 횟수 : 3회
	 */
	public void upDownGame() {
		Scanner sc = new Scanner(System.in);

		// Math.random() : 0.0 이상 1.0 미만의 난수를 반환
		int answer = (int)(Math.random()*100+1); // 1 ~ 100

		int count = 1; // 입력 횟수 저장용 변수

		//		System.out.println(answer); // 답안 임시 확인

		while(true) {
			System.out.print(count + "번째 입력 : ");
			int input = sc.nextInt();

			// 잘못 입력한 경우
			if(input < 1 || input > 100) {
				System.out.println("1 ~ 100사이 수를 입력해주세요. \n");
				continue;
			}

			// 제대로 입력한 경우
			if(input < answer) { // 입력값이 정답보다 작은 경우
				System.out.println("UP");

			} else if(input > answer) { // 입력값이 정답보다 큰 경우
				System.out.println("DOWN");

			} else { // 입력한 값이 정답과 같은 경우
				System.out.println("[정답!!!]");
				System.out.printf("총 입력 횟수 : %d회", count);
				break; // while문 반복 종료
			}
			count++;
		}	
	}



	// 입력 받은 모든 문자열을 누적
	// 단, "end!" 입력 시 문자열 누적을 종료하고 결과 출력
	public void ex6() {
		Scanner sc = new Scanner(System.in);

		String str = ""; // 빈 문자열

		while(true) {

			System.out.print("문자열 입력(end! 입력 시 종료) : ");
			String input = sc.nextLine();
			// next() : 다음 한 단어만 얻어옴(띄어쓰기 포함 X / 띄어쓰기, 엔터를 만나면 입력 종료)
			// nextLine(): 다음 한 줄(띄어쓰기 포함 O / 엔터를 만나면 입력 종료)

			// ** next()로 문장을 작성 시 결과가 이상한 이유 **
			// 1) next()는 한 단어만 읽어옴
			// 2) 입력 -> 입력 버퍼에 저장 -> nextXXX() 통해 버퍼 내용을 읽어옴

			// * next(), nextInt(), nextDouble()
			// 모두 입력 버퍼에서 (엔터)를 제외하고 내용만 읽어옴
			// -> 이후 nextLine()을 사용하면 입력받지 못하고 종료됨
			// -> why? 입력 버퍼에 남아있는 (엔터)를 읽었기 때문에

			// [해결 방법]
			// 입력을 위한 nextLine()을 수행하기 전에
			// 입력 버퍼에서 (엔터)를 제거해준다. 
			// 빈 공간에 sc.nextLine() 구문을 한번 작성하면 (엔터)가 제거된다.


			// 입력 받는 문자열이 "end!"면 반복 종료
			// if(input == "end!") 이렇게 쓰면 X
			if(input.equals("end!")) {
				// String 자료형은 비교 연산자(==)로 같은 문자열인지 판별할 수 없음

				// 비교 연산자는 보통 기본 자료형끼리 연산에만 사용 가능
				// -> String은 기본 자료형이 아닌 참조형

				// ** [해결 방법] : 문자열1.equals(문자열2) ** 중요!
				break;
			}
			str += input + "\n";
		}
		System.out.println(str);
	}



	// 가위 바위 보 게임

	// 몇 판? : 3
	// 1번째 게임
	// 가위/바위/보 중 하나를 입력 해주세요 :  가위
	// 컴퓨터는 [보]를 선택했습니다.
	// 플레이어 승!
	// 현재 기록 : 1승 0무 0패

	// 2번째 게임
	// 가위/바위/보 중 하나를 입력 해주세요 :  보
	// 컴퓨터는 [보]를 선택했습니다.
	// 비겼습니다.
	// 현재 기록 : 1승 1무 0패

	// 3번째 게임
	// 가위/바위/보 중 하나를 입력 해주세요 :  가위
	// 컴퓨터는 [바위]를 선택했습니다.
	// 졌습니다ㅠㅠ
	// 현재 기록 : 1승 1무 1패

	public void RPSGame() {
		Scanner sc = new Scanner(System.in);

		System.out.println("[가위 바위 보 게임]");
		System.out.print("몇 판? : ");
		int round = sc.nextInt();

		// 승패 기록할 용도의 변수
		int win = 0;
		int draw = 0;
		int lose = 0;

		for(int i=1; i<=round; i++) {
			System.out.println("\n" + i + "번째 게임");
			System.out.println("가위/바위/보 중 하나를 입력해주세요 : ");
			String input = sc.next(); // 플레이어가 가위/바위/보 중 입력

			// 컴퓨터 가위/바위/보 정하기(랜덤)
			// 1) 1~3 사이의 난수를 생성
			// 2) 1이면 가위, 2이면 바위, 3이면 보 지정
			int random = (int)(Math.random()*3+1);

			String com = null; // 컴퓨터가 선택한 가위/바위/보를 저장하는 변수
			// null : 아무것도 참조하고 있지 않음

			switch(random) { // 숫자에 따라 가위/바위/보 출력
			case 1: com = "가위"; break;
			case 2: com = "바위"; break;
			case 3: com = "보"; break;
			}
			System.out.printf("컴퓨터는 [%s]를 선택했습니다.\n", com);


			// 컴퓨터와 플레이어(기준) 가위/바위/보 판별
			// win, draw, lose

			// String 비교시 .equals() 사용해야함

			if(input.equals(com)) { // 비긴 경우
				System.out.println("비겼습니다.");
				draw++;

			} else {
				boolean win1 = input.equals("가위") && com.equals("보");
				boolean win2 = input.equals("바위") && com.equals("가위");
				boolean win3 = input.equals("보") && com.equals("바위");

				if(win1 || win2 || win3) { // 이긴 경우
					System.out.println("플레이어 승!");
					win++;

				} else { // 진 경우
					System.out.println("졌습니다 ㅠㅠ");
					lose++;
				}
			}
			System.out.printf("현재 기록 : %d승 %d무 %d패", win, draw, lose);
		}



		/* 내 답안
		Scanner sc = new Scanner(System.in);

		int round = 1;
		int win = 0;
		int draw = 0;
		int lose = 0;

		System.out.print("몇 판 ? : ");
		int play = sc.nextInt();

		while(round <= play) {

			System.out.println(round+"번째 게임");
			System.out.print("가위/바위/보 중 하나를 입력 해주세요 : ");
			String user = sc.next();

			// 컴퓨터 가위/바위/보 랜덤 값 지정
			int random = (int)(Math.random()*3+1);
			String com = "";

			if(random == 1) {
				com = "가위";
			} else if(random == 2) {
				com = "바위";
			} else if(random == 3) {
				com = "보";
			}
			System.out.printf("컴퓨터는 [%s]를 선택했습니다.\n", com);

			// 승 무 패 경우의 수
			if (user.equals(com)) {
				System.out.println("비겼습니다.");
				draw++;
			} else if(user.equals("가위") && com == ("보") ||
					user.equals("바위") && com == ("바위") ||
					user.equals("보") && com == ("가위")) {
				System.out.println("플레이어 승!");
				win++;
			} else {
				System.out.println("졌습니다 ㅠㅠ");
				lose++;
			}

			// 결과 출력
			System.out.printf("현재 기록 : %d승 %d무 %d패\n\n", win, draw, lose);
			round++;
		}*/

	}
}
