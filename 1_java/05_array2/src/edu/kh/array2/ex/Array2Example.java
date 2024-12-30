package edu.kh.array2.ex;

import java.util.Arrays;

public class Array2Example {

	/* 2차원 배열
	 * - 자료형이 같은 1차원 배열을 묶음으로 다루는 것
	 * -> 행, 열 개념 추가
	 */
	
	public void ex1() {
		// 2차원 배열 선언
		int[][] arr;
		// int 2차원 배열을 참조하는 참조 변수 선언
		// (참조형 == 참조 변수 == 레퍼런스 변수 == 레퍼런스)
		
		// 2차원 배열 할당(생성)
		// new 자료형[행크기][열크기]
		
		arr = new int[2][3];
		// heap 영역에 int 2차원 배열 2행 3열짜리 공간을 할당한다
			
		// 2차원 배열 초기화
		
		// 1) 행, 열 인덱스를 이용해서 직접 초기화
		/*arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		*/
		
		// 2) 2중 for문을 이용한 초기화
		
		// * 배열 길이
		// -> 배열명.length : 변수가 직접 참조하고 있는 배열의 길이를 반환
		
		System.out.println(arr.length); // 2 (행의 길이)
		// arr이 참조하고 있는 2차원 배열의 행의 길이
		
		System.out.println(arr[1].length); // 3 (열 길이)
		// arr[1] 행이 참조하고 있는 1차원 배열의 열의 길이
		
		int num = 10; // 배열 요소 초기화에 사용할 변수
		
		for(int row=0; row<arr.length; row++) { // 행 반복(0,1)
			for(int col=0; col<arr[row].length; col++) { // 열 반복 (0,1,2)
				arr[row][col] = num;
				num += 10;
			}
		}
		
		// Arrays.toString(배열명) : 참조하고 있는 1차원 배열 값을 문자열로 반환
		System.out.println(Arrays.toString(arr));
		
		// Arrays.deepToString(배열명) 
		// - 참조하고 있는 배열의 데이터가 나오는 부분까지 파고 들어가서
		//	 모든 값을 문자열로 반환
		System.out.println(Arrays.deepToString(arr));
	}
	
	
	
	// 배열을 이용한 중복 데이터 제거 + 정렬
	public void createLotto() {
		// 로또 번호 생성
		
		// 1. 1~45 사이의 중복되지 않는 난수 6개 생성
		// 2. 생성된 난수를 오름차순 정렬
		
		// 1) 정수 6개를 저장할 배열 선언 및 할당
		int[] lotto = new int[6];
		
		// 2) 생성된 배열을 처음부터 끝까지 순차 접근하는 for문 작성
		for(int i=0; i<lotto.length; i++) {
			
			// 3) 1 ~ 45 사이의 난수 생성
			int random = (int)(Math.random()*45+1);
			
			// 4) 생성된 난수를 순서대로 배열 요소에 대입
			lotto[i] = random;
			
			// 5) 중복 검사를 위한 for문 작성
			for(int x=0; x<i; x++) {
				
				// 6) 현재 생성된 난수와 같은 수가
				//	  앞 쪽 요소에 있는지 검사
				if(random == lotto[x]) {
					i--;
					// i가 1씩 증가할 때 마다 난수가 하나 생성됨
					// -> 중복되는 값이 있으므로 난수를 하나 더 생성해야된다.
					// --> i는 기본적으로 0~5까지 6회 반복되지만
					//	   i값을 인위적으로 1씩 감소시켜 7회 반복하는 모양을 만듦
					
					break;
					// 앞쪽에서 중복 데이터를 발견한다면
					// 남은 값을 비교할 필요가 없음
					// -> 효율 향상을 위해서 중복 검사하는 for문을 종료시킨다
				}
			}
		}
		
		// 7) 오름차순 정렬
		// -> 선택, 삽입, 버블, 퀵 등등
		// --> 자바가 정렬 방법을 미리 만들어서 제공하고 있음
		
		// Arrays.sort(배열명) : 배열 내 값들이 자동으로 오름차순 정렬됨
		Arrays.sort(lotto);
		
		System.out.println(Arrays.toString(lotto));
	}
	
	
	
	public void ex2() {
		// 2차원 배열 선언과 동시에 초기화
		
		// 3행 3열짜리 정수형 2차원 배열 선언과 동시에
		// 1~9까지 초기화
		
		int[][] arr = { {1,2,3} ,
						{4,5,6} ,
						{7,8,9} };
		
		
		// 전체 합 출력
		int sum = 0;
		
		for(int row=0; row<arr.length; row++) {
			
			for(int col=0; col<arr[row].length; col++) {
				sum += arr[row][col];
			}
		}
		System.out.print("전체 합 : "+sum);
		
		System.out.println("\n---------------------");
		
		
		// 행 별로 합 출력
		for(int row=0; row<arr.length; row++) { // 행 반복
			int rowSum = 0;
			
			for(int col=0; col<arr[row].length; col++) { //열 반복
				rowSum += arr[row][col];
			}
			System.out.println(row + "행의 합 : " + rowSum);
		}
		
		System.out.println("---------------------");
		
		
		// 열 별로 합 출력
		// -> 완전한 사각형의 형태를 지닌 2차원 배열은
		//	  모든 열의 길이가 같다.
		for(int col=0; col<arr[0].length; col++) { // 열 반복
			int colSum = 0;
			
			for(int row=0; row<arr.length; row++) { // 행 반복
				colSum += arr[row][col];
						//	   0	0
						//     1	0
						//     2	0
						//     0	1
			}
			System.out.println(col + "열의 합 : " + colSum);
		}
	}
	
	
	
	public void ex3() {
		// 가변 배열
		// - 2차원 배열 생성 시 마지막 배열 차수(열)을 지정하지 않고
		// 나중에 서로 크기가 다른 1차원 배열을 생성하여 참조하는 배열
		char[][] arr = new char[4][];
		
		arr[0] = new char[3]; // 0행에 3열짜리 1차원 배열을 생성하여 주소값을 저장(대입)한다.
		arr[1] = new char[4]; // 1행에 4열짜리 1차원 배열을 생성하여 주소값을 저장(대입)한다.
		arr[2] = new char[5]; // 2행에 5열짜리 1차원 배열을 생성하여 주소값을 저장(대입)한다.
		arr[3] = new char[2]; // 3행에 2열짜리 1차원 배열을 생성하여 주소값을 저장(대입)한다.
		
		// 각 배열 요소에 'a'부터 차례대로 대입
		
		char ch = 'a';
		
		for(int row=0; row<arr.length; row++) { // 행 반복
						// 행의 길이
			for(int col=0; col<arr[row].length; col++) { // 열 반복
							// 열의 길이
				arr[row][col] = ch++;
			}
		}
		System.out.println(Arrays.deepToString(arr));
		
	}
	
	
} // class