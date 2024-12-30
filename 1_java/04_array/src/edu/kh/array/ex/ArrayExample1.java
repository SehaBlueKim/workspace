package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {



	/* 배열(Array)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	 * 
	 * - 묶여진 변수들은 하나의 이름(배열명)으로 불려지고
	 *   각 변수들은 index를 이용해서 구분하게 된다.
	 *   
	 * - index의 번호는 0부터 시작(정수)
	 * 
	 */



	public void ex1() {
		// 변수 vs 배열



		// 1-1. 변수 선언
		int num;
		// Stack 영역에 int 자료형을 저장할 수 있는 공간 4byte를 생성(할당)하고
		// 그 공간에 num이라는 이름을 부여한다

		// 1-2. 변수 대입
		num = 10;
		// 생성된 num이라는 변수 공간에 10을 대입하겠다

		// 1-3. 변수 사용
		System.out.println("num에 저장된 값 : " + num);
		// num이 작성된 자리에 num에 저장된 값을 읽어와서 출력한다

		System.out.println("--------------------------------");



		// 2-1. 배열 선언
		int[] arr;
		// Stack 영역에 int[] (int 배열) 자료형 공간을 8byte 생성(할당)하고
		// 그 공간에 arr 이라는 이름을 부여한다
		// ** 해당 변수는 참조형으로 주소값만을 저장할 수 있다

		// 2-2. 배열 할당
		arr = new int[3];

		// new : "new 연산자"라고 하며
		//		 Heap 메모리 영역에 새로운 공간(배열, 객체)을 할당한다

		// int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열

		// new int[3] : heap 영역에 int 3칸 짜리 int[]을 생성(할당)하겠다
		//				** 생성된 int[]에는 시작 주소가 지정된다!! **

		//   arr   = new int[3];
		// (int[])    (int[])     -> 같은 자료형이므로 연산 가능

		// heap 영역에 생성된 int[]의 시작 주소를
		// Stack 영역에 생성된 arr 변수에 대입하겠다
		// -> arr 변수가 int[]를 참조하게 됨!
		//	  (그래서 arr을 참조형이라고 함)

		// 2-3. 배열 요소 값 대입
		// arr은 int[] 참조형 변수지만
		// arr[0](각각의 요소들)은 int 자료형 변수이기 때문에 정수값 대입 가능하다.
		arr[0]=10;
		arr[1]=50;
		arr[2]=100;

		// 2-4. 배열 요소 값 읽어오기
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}



	public void ex2() {

		// 배열 선언 및 할당
		int[] arr = new int[4];

		// 1) Stack 영역에 int[] 자료형 참조 변수 arr을 선언
		// 2) Heap 영역에 int 자료형 4개를 묶음으로 다루는 int[]을 할당
		// 3) 생성된 int[]의 시작 주소를 arr 에 대입하여 참조하는 형태를 만든다

		// 배열 길이(== 몇 칸인가) : 배열.length
		System.out.println("배열의 길이 : " + arr.length);
		arr[0] = 3;
		arr[1] = 4;
		arr[2] = 5;
		arr[3] = 6;

		// 배열과 for문
		// i == index
		for(int i=0; i<arr.length; i++) {
			// 0 이상 arr 배열 길이 미만의 정수만큼 반복

			System.out.printf("arr[%d]에 저장된 값 : %d\n", i, arr[i]);
		}
	}



	// (참고)

	// 비어있다 : stack 영역에 선언된 변수에 값이 대입되지 않음

	// null : 참조형 변수가 선언 되었으나 아무곳도 참조하지 않음
	//			(빈칸 아님!)

	// 0 : int 자료형 0

	// "" : String 자료형이지만 내용 없음(빈 문자열)



	public void ex3() {
		// 5명의 키(cm)를 입력 받고 평균 구하기

		// 1번 키 입력 : 170.5
		// 2번 키 입력 : 165.7
		// 3번 키 입력 : 184.3
		// 4번 키 입력 : 190.2
		// 5번 키 입력 : 174.4

		// 입력 받은 키 : 170.5  165.7  184.3  190.2  174.4
		// 평균 : 177.02cm
		Scanner sc = new Scanner(System.in);
		Double[] height = new Double[5];


		for(int i=0; i<height.length; i++) { // 키 입력받기
			System.out.print(i+1 + "번 키 입력 : ");
			// double input = sc.nextDouble();
			// height[i] = input;
			// 위 두줄을 아래의 한줄로 줄일 수 있다
			height[i] = sc.nextDouble(); // 각 인덱스에 입력 받은 값을 대입(초기화)
		}
		System.out.println();


		System.out.print("입력 받은 키 : "); // 입력 받은 키 표시
		double sum = 0;
		for(int i=0; i<height.length; i++) {
			System.out.print(height[i] + " ");
			sum += height[i]; // 배열에 저장된 값을 sum에 누적
		}


		System.out.printf("\n평균 : %.2f", sum/height.length); // 평균
	}



	public void ex4() {
		// 배열 선언과 동시에 초기화

		char[] arr = new char[5];

		// char[] arr이 참조하는 배열 요소에 A,B,C,D,E 대입하기
		for(int i=0; i<arr.length; i++) {
			arr[i] = (char)('A' + i);
			// A == 65
			// B == 66
			// C == 67

			System.out.println(arr[i]);
		}
		// ** Arrays 클래스
		// -> Java에서 제공하는 배열과 관련된 기능을 모아둔 클래스
		int[] arr2 = new int[4];
		System.out.println(arr2); // [I@626b2d4a (int 배열의 주소)

		// Arrays.toString(배열명) : 모든 요소 값을 출력
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr));

		// 배열 선언과 동시에 할당 및 초기화
		char[] arr3 = {'A','B','C','D','E'};

		// char[] 참조 변수 arr3를 선언하고
		// heap 영역에 char 5칸짜리 char[]을 생성(할당)하고
		// 할당한 자리에 각각 'A','B','C','D','E'로 초기화 후 주소를 arr3에 대입

		// {} (중괄호)는 배열의 리터럴 표기법

		System.out.printf("arr3의 길이 : ", arr3.length);
		System.out.println(Arrays.toString(arr3));
	}



	public void ex6() {
		// 점심 메뉴 뽑기 프로그램
		String[] menu = {"떡볶이", "제육볶음", "순대", "감자튀김", "햄버거"};

		// 배열 index 범위 내 난수를 발생

		int random = (int)(Math.random()*menu.length);
		// 0.0 <= x < 1.0
		// 0.0 <= x*5 < 5.0
		// 0.0 <= (int)(x*5) < 5
		// -> 0 1 2 3 4
		System.out.println("오늘의 점심 메뉴 : " + menu[random]);
	}



	public void ex7() {
		// 디저트 주문 프로그램

		// 배열 2개 생성 후
		// 같은 인덱스 번호에 메뉴명, 가격을 작성

		// ---- 메뉴 ----
		// 1) 치즈케이크 (6400원)
		// 2) 브라우니 (4800원)
		// ...
		// 9) 주문 완료

		// 주문한 메뉴 : 치즈케이크 브라우니
		// 합계 : 13200원

		// 메뉴에 있는 번호만 눌러주세요.
		String[] menu = {"치즈케이크", "브라우니", "티라미수", "식혜", "크로칸슈"};
		int[] price = {6400, 4800, 5500, 3000, 5900};

		Scanner sc = new Scanner(System.in);

		int sum = 0;
		String orderMenu = ""; // 주문한 메뉴를 저장할 변수
		int totalPrice = 0; // 주문한 메뉴의 가격을 저장할 변수

		while(true) {
			System.out.println("---- 메뉴 ----");

			// 메뉴 출력
			for(int i=0; i<menu.length; i++) {
				System.out.printf("%d) %s (%d원)\n", i+1, menu[i], price[i]);
			}
			System.out.println("9) 주문 완료");

			System.out.print("메뉴 선택 >>");
			int input = sc.nextInt();

			// 만약 9번을 입력한 경우 반복문 멈추기
			if(input==9) {
				break;

				// 메뉴 인덱스 범위를 초과할 때 "메뉴에 있는 번호만 눌러주세요."
			} else if(input<=0 || input>=menu.length){
				System.out.println("메뉴에 있는 번호만 눌러주세요.");

				// 정상 입력 -> 누적
			} else {
				orderMenu += menu[input] + " ";
				totalPrice += price[input];
			}
		} // while문 종료

		System.out.println("주문한 메뉴 : " + orderMenu);
		System.out.println("총 합계 : " + totalPrice + "원");
	}



	public void ex8() {
		/* 생성할 배열의 길이 : 3       <- 입력
		 * 
		 * 0번 인덱스 요소 : 40         <- 입력
		 * 1번 인덱스 요소 : 60         <- 입력
		 * 2번 인덱스 요소 : 80         <- 입력
		 * 
		 * 저장된 값을 확인하려는 인덱스(-1 종료) : 0          <- 입력
		 * 0번 인덱스 : 40
		 * 
		 * 저장된 값을 확인하려는 인덱스(-1 종료) : 2          <- 입력
		 * 2번 인덱스 : 80
		 * 
		 * 저장된 값을 확인하려는 인덱스(-1 종료) : 99          <- 입력
		 * 존재하지 않는 인덱스 번호 입니다
		 * 
		 * 저장된 값을 확인하려는 인덱스(-1 종료) : -1          <- 입력
		 * 프로그램 종료
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("생성할 배열의 길이 : ");
		int input = sc.nextInt();

		// 입력 받은 input 만큼의 길이를 가지는 배열 생성
		int[] arr = new int[input];

		// 인덱스 요소 입력 받기
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d번 인덱스 요소 : ", i);
			arr[i] = sc.nextInt();
		}

		while(true) {
			System.out.print("저장된 값을 확인하려는 인덱스(-1 종료) : ");
			int index = sc.nextInt();

			// -1 입력하는 경우
			if(index == -1) { 
				System.out.println("프로그램 종료");
				break;
			} 

			// 배열의 인덱스 범위를 초과하는 경우
			if(index<0 || index>=arr.length) {
				System.out.println("존재하지 않는 인덱스 번호 입니다.");
				continue; // 다음 반복으로 이동(반복문 처음으로 이동)
			}

			// 정상 인덱스 입력된 경우
			System.out.printf("%d번째 인덱스 : %d\n", index, arr[index]);

			// 요즘 개발 트렌드는 if-else 말고 if문만 사용한다!
			// 왜? 유지보수가 편해서 (else if까지 모두 수정해주지 않아도 돼서 편하다)
		}
	}



	public void ex9() {
		// 배열을 이용한 검색

		// 입력 받은 정수가 배열에 있는지 없는지 확인
		// 만약 있다면 몇번 인덱스에 존재하는지 출력
		int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		boolean flag = false; // 검사 전에는 없다고 가정

		// arr 배열 요소 순차 접근(반복 접근)
		for(int i=0; i<arr.length; i++) {

			// arr[i]에 저장된 값과 input이 같을 경우를 찾으면 됨
			if(input == arr[i]) {
				System.out.println(i + "번째 인덱스에 존재");
				flag = true; // 일치하는 값이 있으므로 true로 변경
				break;
			}
		}

		// flag 상태를 검사해서 존재여부 확인
		if(flag == false) { // !flag 로 써도 됨
			System.out.println("존재하지 않습니다.");
		}
	}



	public void ex10() {

		// 입력 받은 값과 일치하는 값이 있으면 인덱스 번호 출력
		// 없으면 "존재하지 않습니다." 출력

		String[] coffee = {"딸기라떼", "달고나라떼","녹차라떼","흑임자라떼","밀크티", 
				"바닐라라떼", "아이스 아메리카노"};
		Scanner sc = new Scanner(System.in);
		System.out.print("음료 입력 : ");
		String input = sc.nextLine();

		boolean flag = true;
		// flag == true : 존재하는게 없고
		// flag == false : 존재하는게 있다

		for(int i=0; i<coffee.length; i++) {

			if(input.equals(coffee[i])) { // String 끼리 비교시 .equals() 사용
				System.out.println(i + "번째 인덱스에 존재합니다");
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("존재하지 않습니다.");
		}		
	}



	public void ex11() {
		// 1. 문자열을 입력 받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		// 2. 문자 하나를 입력 받아 일치하는 문자가 char 배열에 몇개 존재하는지 확인
		// 3. 단, 일치하는 문자가 없을 경우 "존재하지 않습니다." 출력

		// 문자열 입력 : apple
		// 검색할 문자 입력 : p

		// 2개 존재
		// 존재하지 않습니다.

		// [사용해야 되는 기술, 기능]
		// 1. 배열 검색
		// 2. String.length() : 문자열의 길이
		// 3. String.charAt(index) : 문자열에서 특정 index에 위치한 문자 하나를 얻어옴
		//		ex) "Hello".charAt(1) -> 'e' 하나를 얻어옴
		//			 01234 (인덱스 번호)

		// 4. count (숫자 세기)

		Scanner sc = new Scanner(System.in);


		// 1. 문자열을 입력 받아 한 글자씩 잘라내어 char 배열에 순서대로 저장

		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();
		char[] arr = new char[input.length()];

		for(int i=0; i<input.length(); i++) {
			arr[i] = input.charAt(i);
			// input의 i번째 문자를 arr[i]번째 인덱스에다가 대입
		}


		// 중간 확인
		// System.out.println(Arrays.toString(arr));


		// 2. 문자 하나를 입력 받아 일치하는 문자가 char 배열에 몇개 존재하는지 확인
		System.out.print("검색할 문자 입력 : ");
		char ch = sc.nextLine().charAt(0);
		// String.charAt(0) : 문자열 중 제일 앞의 문자 얻어오기

		int count = 0; // 같은 글자의 개수를 세기 위한 변수

		for(int i=0; i<arr.length; i++) {
			if(arr[i] == ch) {
				// arr[i] 값과 검색할 문자 ch가 같은 경우
				// -> 카운트 해주기
				count++;
			}
		}
		// 결과 출력
		if(count > 0) {
			System.out.println(count + "개 있습니다.");

		// 3. 단, 일치하는 문자가 없을 경우 "존재하지 않습니다." 출력
		} else {
			System.out.println("존재하지 않습니다.");
		}

	}

}






