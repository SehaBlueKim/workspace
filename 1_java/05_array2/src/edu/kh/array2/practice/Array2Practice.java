package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice {

	public void practice1() {
		// 3행 3열짜리 문자열 배열을 선언 및 할당하고
		// 인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 "(0,0)" 과 같은 형식으로 저장 후 출력하세요.
		String[][] arr = new String[3][3];

		for(int row=0; row<arr.length; row++) { // 행 반복

			for(int col=0; col<arr[0].length; col++) { // 열 반복
				arr[row][col] = "(" + row + "," + col + ")";
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}



	public void practice2() {
		// 4행 4열짜리 정수형 배열을 선언 및 할당하고
		//	1) 1~16까지 값을 차례대로 저장하세요.
		//	2) 저장된 값들을 차례대로 출력하세요.
		int[][] arr = new int[4][4];

		int num = 1;

		for(int row=0; row<arr.length; row++) { // 행 반복(0~3)
			for(int col=0; col<arr[row].length; col++) { // 열 반복(0~3)
				arr[row][col] = num++;

				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
	}



	public void practice3() {
		// 4행 4열짜리 정수형 배열을 선언 및 할당하고
		//	1) 16~1과 같이 값을 거꾸로 저장하세요.
		//	2) 저장된 값들을 차례대로 출력하세요.
		int[][] arr = new int[4][4];

		int num = 16;

		for(int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++){
				arr[row][col] = num--;
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
	}



	public void practice4() {
		// 4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
		// 아래의 내용처럼 처리하세요.

		//  9  3  7 19
		//  3  6  9 18
		//  6 10 10 26
		// 18 19 26 63
		int[][] arr = new int[4][4];

		final int ROW_LAST_INDEX = arr.length-1; // 행 마지막 인덱스 번호
		final int COL_LAST_INDEX = arr[0].length-1; // 열 마지막 인덱스 번호 

		for(int row=0; row<arr.length; row++) { // 행 반복

			for(int col=0; col<arr[row].length; col++) { // 열 반복

				// 마지막 행, 마지막 열이 아닌 경우에만 난수 대입해주겠다
				if(row != ROW_LAST_INDEX && col != COL_LAST_INDEX) {
					int random = (int)(Math.random()*10+1);

					arr[row][col] = random;

					// 각 행의 마지막 열에 난수를 누적
					arr[row][COL_LAST_INDEX] += arr[row][col];

					// 각 열의 마지막 행에 난수를 누적
					arr[ROW_LAST_INDEX][col] += arr[row][col];

					// 생성된 모든 난수를 마지막 행, 마지막 열에 누적
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
				}
				System.out.printf("%4d", arr[row][col]);
			} // 열 반복 끝
			System.out.println();
		}
	}



	public void practice5() {
		// 2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
		// "반드시 1~10 사이의 정수를 입력해야 합니다." 출력 후 다시 정수를 받게 하세요.
		// 크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
		// (char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자)
		Scanner sc = new Scanner(System.in);

		while(true) {

			System.out.print("행 크기 : ");
			int row = sc.nextInt();

			System.out.print("열 크기 : ");
			int col = sc.nextInt();

			if(row < 1 || row > 10 || col < 1 || col > 10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				continue;

			} else { // 올바르게 입력한 경우
				char[][] arr = new char[row][col];

				for(int x=0; x<row; x++) {
					for(int y=0; y<col; y++) {
						arr[x][y] = (char)(Math.random()*26+65);
						// 0.0 <= z < 1.0
						// 0.0 <= z * 26 < 26.0
						// 65.0 <= z * 26 + 65 < 91.0
						// 65 <= (int)(z * 26 + 65) < 91
						System.out.print(arr[x][y] + " ");
					}
					System.out.println();
				}
				break;
			}
		}
	}



	public void practice6() {
		// 사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
		// 문자형 가변 배열을 선언 및 할당하세요.
		// 그리고 각 인덱스에 'a'부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
		Scanner sc = new Scanner(System.in);

		System.out.print("행의 크기 : ");
		int input = sc.nextInt();

		char[][] arr = new char[input][];

		char ch = 'a';

		// 열의 크기를 정하는 for문
		for(int i=0; i<arr.length; i++) {
			System.out.print(i + "열의 크기 : ");
			int col = sc.nextInt();
			arr[i] = new char[col]; // 입력한 열의 크기 만큼의 char 배열 생성
		}

		// 출력용 for문
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				arr[row][col] = ch++;
				System.out.print(arr[row][col]);
			}
			System.out.println(); // 줄바꿈
		}
	}


	public void practice7() {
		// 1차원 문자열 배열에 학생 이름이 초기화되어 있다.
		// 3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
		// 학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
		// (첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};

		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];

		int index = 0; // students 배열에서 0부터 1씩 증가하며 학생들을 선택하는 용도의 변수


		System.out.println("== 1분단 ==");
		for(int row=0; row<arr1.length; row++) {
			for(int col=0; col<arr1[row].length; col++) {
				arr1[row][col] = students[index];
				// students 배열에서 index번째 학생을 arr1[row][col]에 대입

				index++;
				System.out.print(arr1[row][col] + " ");
			}
			System.out.println(); // 줄 바꿈
		}

		System.out.println("== 2분단 ==");
		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length; col++) {
				arr2[row][col] = students[index];
				// students 배열에서 index번째 학생을 arr1[row][col]에 대입

				index++;
				System.out.print(arr2[row][col] + " ");
			}
			System.out.println(); // 줄 바꿈
		}
	}



	public void practice8() {
		// 위 문제에서 자리 배치한 것을 가지고 학생 이름을 검색하여
		// 해당 학생이 어느 자리에 앉았는지 출력하세요.

		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};

		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];

		int index = 0; // students 배열에서 0부터 1씩 증가하며 학생들을 선택하는 용도의 변수


		System.out.println("== 1분단 ==");
		for(int row=0; row<arr1.length; row++) {
			for(int col=0; col<arr1[row].length; col++) {
				arr1[row][col] = students[index];
				// students 배열에서 index번째 학생을 arr1[row][col]에 대입

				index++;
				System.out.print(arr1[row][col] + " ");
			}
			System.out.println(); // 줄 바꿈
		}

		System.out.println("== 2분단 ==");
		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length; col++) {
				arr2[row][col] = students[index];
				// students 배열에서 index번째 학생을 arr1[row][col]에 대입

				index++;
				System.out.print(arr2[row][col] + " ");
			}
			System.out.println(); // 줄 바꿈
		}

		System.out.println("======================");
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.next();

		for(int row=0; row<arr1.length; row++) {
			for(int col=0; col<arr1[row].length; col++) {

				if(name.equals( arr1[row][col] )) {
					if(col==0) {
						System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 왼쪽에 있습니다.",
								name, row+1);
					} else {
						System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 오른쪽에 있습니다.",
								name, row+1);
					}
				}
			}
		}


		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length; col++) {

				if(name.equals( arr2[row][col] )) {
					if(col==0) {
						System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 왼쪽에 있습니다.",
								name, row+1);
					} else {
						System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 오른쪽에 있습니다.",
								name, row+1);
					}
				}
			}
		}
	}



	public void practice9() {
		// String 2차원 배열 6행 6열을 만들고 행의 맨 위와 제일 앞 열은 각 인덱스를 저장하세요.
		// 그리고 사용자에게 행과 열을 입력 받아 해당 좌표의 값을 "X"로 변환해 2차원 배열을 출력하세요.
		Scanner sc = new Scanner(System.in);

		String[][] arr = new String[6][6];

		System.out.print("행 인덱스 입력 : ");
		int rowIndex= sc.nextInt();

		System.out.print("열 인덱스 입력 : ");
		int colIndex = sc.nextInt();

		int num1 = 0;
		int num2 = 0;

		for(int row=0; row<arr.length; row++) { // row = 0,1,2,3,4,5

			for(int col=0; col<arr[row].length; col++) { // col = 0,1,2,3,4,5

				if (row == 0 && col != 0) {
					arr[row][col] = num1++ + " ";
					// 숫자 + 문자열 = 문자열(이어쓰기 됨)
				} else if(col == 0 && row != 0) {
					arr[row][col] = num2++ + " ";
				} else {
					arr[row][col] = "  ";
				}

				arr[rowIndex+1][colIndex+1] = "X";
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
	}



	public void practice10() {
		// 실습문제9와 내용은 같으나 행 입력 시 99가 입력되지 않으면 무한 반복이 되도록 구현하세요.
		Scanner sc = new Scanner(System.in);

		String[][] arr = new String[6][6];

		int num1 = 0;
		int num2 = 0;

		// 기본 실행화면 출력용 for문
		for(int row=0; row<arr.length; row++) { // row = 0,1,2,3,4,5
			for(int col=0; col<arr[row].length; col++) { // col = 0,1,2,3,4,5

				if (row == 0 && col != 0) {
					arr[row][col] = num1++ + " ";
					// 숫자 + 문자열 = 문자열(이어쓰기 됨)
				} else if(col == 0 && row != 0) {
					arr[row][col] = num2++ + " ";
				} else {
					arr[row][col] = "  ";
				}
			}
		}

		while(true){

			System.out.print("행 인덱스 입력 : ");
			int rowIndex= sc.nextInt();

			if(rowIndex==99) {
				System.out.println("\n프로그램 종료");
				break; // 반복문 종료
			}

			System.out.print("열 인덱스 입력 : ");
			int colIndex = sc.nextInt();

			arr[rowIndex+1][colIndex+1] = "X";
			// 화면에 보이는 행, 열에 X값 저장

			for(int row=0; row<arr.length; row++) {
				for(int col=0; col<arr[row].length; col++) {
					System.out.print(arr[row][col]);
				}
				System.out.println();
			}
		}
	}




	public void bingo() {
		// 1. 빙고판 크기를 입력 받아, 그 크기 만큼의 행과 열을 가지는 2차원 배열(빙고판)을 생성하고
		// 1부터 크기*크기 사이의 정수 난수를 무작위 배치. (중복이 없도록)
		// 2. 정수를 입력 받아 빙고판에서 일치하는 부분을 찾아 해당 부분의 숫자를 “★“ 로 변경하고
		// 현재 빙고 카운트가 몇인지 출력.
		// 단, 빙고판에 없는 정수를 입력한 경우 “다시 입력 해주세요.“ 출력
		// 3. 가로, 세로, 대각선 한줄이 모두 “★“로 변경되어 있을 경우 빙고 카운트를 1 증가
		// 4. 빙고 카운트가 3이상이 되면 “***Bingo!***” 를 출력하고 프로그램 종료.
		Scanner sc = new Scanner(System.in);

		System.out.print("빙고판 크기 지정 : ");
		int size = sc.nextInt();

		// 1차원 배열로 빙고판에 입력될 값 생성 + 중복 제거
		int[] randomArr = new int[size*size];
		// 빙고판의 크기는 가로, 세로의 곱 만큼의 공간이 필요

		// 중복 제거하면서 랜덤값 집어넣기
		for(int i=0; i<randomArr.length; i++) {
			randomArr[i] = (int)(Math.random()* (size*size) + 1);

			// 중복 제거
			for(int j=0; j<i; j++) {
				if(randomArr[i] == randomArr[j]) {
					i--;
					break;
				}
			}
		}

		// 위에서 만들어진 중복 제거한 1차원 배열(randomArr)을 2차원 배열에 넣기
		// String 배열로 변경해서 진행
		// 왜? 빙고가 된 부분을 "★"로 변경하기 위해서
		String[][] bingoBoard = new String[size][size];

		int index = 0; // 1차원 배열(randomArr) 인덱스 지정을 위한 변수

		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				bingoBoard[i][j] = randomArr[index++] + "";
				System.out.printf("%4s", bingoBoard[i][j]);
			}
			System.out.println();
		}

		System.out.println("=========빙고게임 시작=========");

		while(true) {

			System.out.print("정수를 입력하시오 : ");
			String input = sc.next();

			boolean flag = true; // 검색된 값이 빙고판에 있는지 확인
			// flag == true  : 값 없음
			// flag == false : 값 있음
			for(int i=0; i<bingoBoard.length; i++) {
				for(int j=0; j<bingoBoard[i].length; j++) {

					// 입력된 값과 일치하는 곳을 ★로 변환
					if(input.equals(bingoBoard[i][j])) {
						bingoBoard[i][j] = "★";
						flag = false;
					}
					System.out.printf("%4s", bingoBoard[i][j]);
				}
				System.out.println(); // 줄바꿈
			}

			if (flag) { // 값 없음
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				continue;
			}

			// 빙고 검사

			// 빙고 기준이 되는 문자열 생성
			// ex) 4*4 크기 빙고의 경우 한 줄이 "★★★★" 면 빙고

			String bingoLine = "";
			for(int i=0; i<size; i++) {
				bingoLine += "★";
			}

			int bingoCount = 0; // 빙고 수를 저장할 변수

			// 가로(행) 또는 세로(열)의 문자열을 더하여 하나의 문자열로 저장
			// -> 저장된 문자열의 모양이 "★★★★"인 경우 == 빙고
			// -> bingoCount 증가 시킴


			for(int i=0; i<bingoBoard.length; i++) {

				// 매 반복 시 마다 rowLine, colLine을 빈 문자열로 초기화 시켜줘야 한다.
				// 왜?! 바깥쪽 for문이 반복될 때마다 검사하는 행과 열이 이동하므로
				// 빙고 여부를 검사하기 위한 rowLine, colLine을 빈 문자열로 초기화 해야 함
				String rowLine = "";
				String colLine = "";

				for(int j=0; j<bingoBoard[i].length; j++) {
					rowLine += bingoBoard[i][j]; // 현재 행의 문자를 모두 더함
					colLine += bingoBoard[j][i]; // i,j(행렬)을 반대로 하여 열의 문자를 모두 더함
				}

				if(rowLine.equals(bingoLine)) { // 가로 빙고가 존재할 경우
					bingoCount++;
				}

				if(colLine.equals(bingoLine)) { // 세로 빙고가 존재할 경우
					bingoCount++;
				}
			}

			// 대각선 빙고 여부
			// 대각선 : diagonal

			// 대각선은 빙고판에서 두 개만 존재
			// -> 대각선 문자를 더해 저장할 변수 두 개 선언 및 빈 문자열로 초기화

			String dia1Line = "";
			String dia2Line = "";

			for(int i=0; i<bingoBoard.length; i++) {
				dia1Line += bingoBoard[i][i]; // 좌상->우하 대각선
				dia2Line += bingoBoard[i][bingoBoard.length-i-1]; // 우상->좌하 대각선
			}

			if(dia1Line.equals(bingoLine)) {
				bingoCount++;
			}

			if(dia2Line.equals(bingoLine)) {
				bingoCount++;
			}

			// 빙고 카운트 출력
			System.out.println("현재 " + bingoCount + "빙고\n");

			if(bingoCount>=3) { // 빙고 개수가 3개 이상인 경우
				System.out.println("***** BINGO!!! *****");
				break;
			}
		}
	}



} // class


