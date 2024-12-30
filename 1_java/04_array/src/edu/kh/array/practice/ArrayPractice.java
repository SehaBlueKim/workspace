package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {


	public void practice1() {
		// 길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
		// 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		// 짝수 번째 인덱스 값의 합을 출력하세요. (0번째 인덱스는 짝수로 취급)

		// [실행 화면]
		// 1 2 3 4 5 6 7 8 9
		// 짝수 번째 인덱스 합 : 25

		// 길이가 9인 배열을 선언 및 할당
		int[] arr = new int[9];

		// 1~9까지 배열의 각 인덱스 요소에 대입
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}

		// 중간 확인
		System.out.println(Arrays.toString(arr));

		// 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		// 짝수 번째 인덱스 값의 합
		int sum = 0;
		for(int i=0; i<arr.length; i+=2) {
			sum += arr[i];
		}
		System.out.println("\n짝수 번째 인덱스 합 : "+sum);

		/* 다른 답안
		int[] arr = new int[9]; 
		int sum = 0;
		for(int i = 0; i < arr.length; i++){ 
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
			if((i + 1) % 2 != 0) {
				sum += arr[i];
			}
		}
		System.out.print("\n짝수 번째 인덱스 합 : " + sum);
		 */
	}





	public void practice2() {
		// 길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
		// 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		// 홀수 번째 인덱스 값의 합을 출력하세요. (0번째 인덱스는 짝수로 취급)

		// [실행 화면]
		// 9 8 7 6 5 4 3 2 1
		// 홀수 번째 입덱스 합 : 20

		// 길이가 9인 배열을 선언 및 할당
		int[] arr = new int[9];

		// 9부터 1까지 배열의 각 인덱스 요소에 대입
		for(int i=0; i<arr.length; i++) {
			arr[i] = 9-i; 
		}

		// 중간 확인
		System.out.println(Arrays.toString(arr));

		// 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		//홀수 번째 인덱스 합
		int sum = 0;
		for(int i=1; i<arr.length; i+=2) {
			sum += arr[i];
		}

		// 출력
		System.out.println("\n홀수 번째 인덱스 합 : "+sum);

	}



	public void practice3() {
		// 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
		// 1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.

		// 실행 화면
		// 양의 정수 : 5
		// 1 2 3 4 5
		Scanner sc = new Scanner(System.in);

		// 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];

		// 1부터 입력 받은 값까지 배열에 초기화
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}

		// 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}



	public void practice4() {
		// 정수 5개를 입력 받아 배열을 초기화 하고
		// 검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
		// 배열에 같은 수가 없을 경우 "일치하는 값이 존재하지 않습니다" 출력
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];

		// 정수 5개를 입력 받아 배열을 초기화
		for(int i=0; i<arr.length; i++) {
			System.out.print("입력 "+i+" : ");
			// int input = sc.nextInt();
			// arr[i] = input;
			arr[i] = sc.nextInt();
		}

		// 검색할 정수를 하나 입력 받기
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();

		// 배열에서 같은 수가 있는 인덱스를 찾아 출력
		boolean flag = false;

		for(int i=0; i<arr.length; i++) {
			if(search==arr[i]) {
				System.out.print("인덱스 : "+i);
				flag = true;
				break;
			}
		}

		// 배열에 같은 수가 없을 경우 "일치하는 값이 존재하지 않습니다" 출력
		if(flag == false) { // == !flag
			System.out.println("일치하는 값이 존재하지 않습니다");
		}


	}


	public void practice5() {
		// 문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지
		// 개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.

		// [실행 화면]
		// 문자열 : application
		// 문자 : i
		// application에 i가 존재하는 위치(인덱스) : 4 8
		// i 개수 : 2

		// 문자열 입력 받기
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String input = sc.nextLine();

		// 입력받은 문자열 크기만큼 문자형 변수 배열 칸 생성
		char[] ch = new char[input.length()];

		// 하나씩 값 대입
		for (int i= 0; i < input.length(); i++) {
			ch[i] += input.charAt(i);
		}

		System.out.print("문자 : ");
		char s = sc.nextLine().charAt(0); // 문자열 중 제일 앞 문자 얻어오기

		System.out.printf("%s 에 %s가 존재하는 위치(인덱스) : ", input, s);
		int num = 0;
		for (int i= 0; i < input.length(); i++) {
			if (s == ch[i]) {
				System.out.print(i + " ");
				num++;
			}
		}
		System.out.printf("\n%s 개수 : %d", s, num);
	}



	public void practice6() {
		// 사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
		// 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
		// 그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.

		//사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];

		int sum = 0;

		String value = "";

		for(int i=0; i<arr.length; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();

			sum += arr[i];
			value += arr[i] + " ";
		}

		System.out.println(value);
		System.out.println("총 합 : " + sum);
	}



	public void practice7() {
		// 주민등록번호 번호를 입력 받아 char 배열에 저장한 후 출력하세요.
		// 단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
		Scanner sc = new Scanner(System.in);

		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();

		char[] arr = new char[input.length()];

		for(int i=0; i<arr.length; i++) {


			if(i <= 7) { // 7번 인덱스 이하(생년월일, -, 성별)
				arr[i] = input.charAt(i);

			} else { // 8번 인덱스 이상 부터는 *
				arr[i] = '*';
			}
			System.out.print(arr[i]);
		}	
	}



	public void practice8() {
		// 3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
		// 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
		// 단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 "다시 입력하세요"를 출력하고
		// 다시 정수를 받도록 하세요.
		Scanner sc = new Scanner(System.in);

		while(true) { // 3 이상의 홀수가 입력 될 때까지 무한 반복
			System.out.print("정수 : ");
			int input = sc.nextInt();

			// 3 미만이거나 짝수인 경우 -> 다시 가까운 반복문부터 반복
			if(input < 3 || input % 2 == 0) {
				System.out.println("다시 입력하세요.");
				continue;

			} else {
				// 입력 받은 정수 만큼의 크기를 가지는 배열 생성
				int[] arr = new int[input];

				int num = 1; // arr 배열에 대입될 값을 생성

				for(int i=0; i<arr.length; i++) {

					if(i<arr.length / 2) { // 중간 이전 까지는 증가
						arr[i] = num++;						
					} else { // 중간 이후 부터 감소
						arr[i] = num--;
					}

					// 출력 시 , 추가 (단, 마지막은 제외)
					if(i==arr.length-1) { // 마지막 바퀴면						
						System.out.print(arr[i]);
					} else {
						System.out.print(arr[i] + ", ");
					}
				}
				break; // while문 반복 종료
			}
		}
	}



	public void practice9() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
		// 1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
		int[] arr = new int[10];

		System.out.print("발생한 난수 : ");

		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);

			System.out.print(arr[i] + " ");
		}
	}



	public void practice10() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고.
		// 1~10 사이의 난수를 발생시켜 배열에 초기화 후
		// 배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
		int[] arr = new int[10];

		System.out.print("발생한 난수 : ");

		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);

			System.out.print(arr[i] + " ");
		}

		// 최고 / 최저점 구하기
		int min = arr[0];
		int max = arr[0];

		// for문을 이용해서 arr 배열에 있는 모든 값과 max, min 값 비교
		// 이 때,
		// arr[i] 값이 max 보다 크면 max에 대입
		// arr[i] 값이 min 보다 작으면 min에 대입
		for(int i=0; i<arr.length; i++) {

			if(arr[i] > max) { // 최고점 비교
				max = arr[i];
			}

			if (min > arr[i]){ // 최저점 비교
				min = arr[i]; 
			}
		}
		System.out.println("\n최대값 : "+max);
		System.out.println("최소값 : "+min);
	}



	public void practice11() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		// 1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요
		int[] arr = new int[10];

		for(int i=0; i<arr.length; i++){

			// 난수 생성 -> 대입 (단, 중복X)
			arr[i] = (int)(Math.random()*10+1);

			// 중복 확인 시 i값 감소 시켜서
			// 다음 반복에서 현재 인덱스에 난수 덮어쓰기
			for(int x=0; x<i; x++) {
				// x값은 최대값은 i보다 1 작은 수

				// 현재 생성된 난수가 앞서 대입된 난수와 같은 경우 == 중복
				if(arr[i]==arr[x]) {
					i--; // i를 1 감소
					// 바깥쪽 for문 반복하러 감 -> 다시 i가 1 증가 -> 제자리
					// -1 + 1 == 0 (제자리)
					break; // 중복되는 값을 찾으면 더 이상 검사할 필요X
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	
	
	public void practice13() {
		// 문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
		// 문자의 개수와 함께 출력하세요.

		// 문자열 : application
		// 문자열에 있는 문자: a, p, l, i, c, t, o, n
		// 문자 개수 : 8
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.nextLine();

		char[] arr = new char[input.length()];

		int count = 0; // 카운트용 변수

		System.out.print("문자열에 있는 문자 : ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = input.charAt(i); // 문자열 -> char 배열에 옮겨 담기

			boolean flag = true; // 신호용 변수
			// flag == true  : 중복 없음
			// flag == false : 중복 있음

			for(int x=0; x<i; x++) { // 중복 검사용 for문
				if(arr[i]==arr[x]) { // 현재 대입된 문자가 앞서 대입된 문자와 같다면 중복
					flag = false;
					break;
				}
			}
			if(flag) { // 중복이 없을 경우 : flag == true
				count++; // 카운트 1씩 증가
				if(i == 0) { // 첫 바퀴인 경우
					System.out.print(arr[i] + " ");
				} else { // 첫 바퀴가 아닌 경우
					System.out.print(", " + arr[i]);
				}
			}

		} // 바깥쪽 for문 끝
		System.out.println("\n문자 개수 : "+count);
	}



	public void practice14() {
		// 사용자가 입력한 배열의 길이만큼의 문자열 배열을 선언 및 할당하고
		// 배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
		// 단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지.
		// 늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
		// 사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		sc.nextLine(); // 입력 버퍼에 남은 개행 문자 제거

		String[] arr = new String[size]; // 배열 선언 및 할당

		int start = 0; // while문 내에 있는 for문의 초기식에 사용할 변수

		while(true) {

			for(int i=start; i<arr.length; i++) {
				System.out.print((i+1) + "번째 문자열 : ");
				arr[i] = sc.nextLine();
			}

			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char input = sc.nextLine().charAt(0);
			// 입력 받은 문자열 중 제일 앞 문자 하나만 얻어옴

			if(input == 'Y' || input == 'y') {
				start = arr.length;
				// 추가 입력 받기 위한 추가 배열 부분의 시작 위치
				System.out.print("더 입력하고 싶은 개수 : ");
				int addSize = sc.nextInt();
				sc.nextLine();

				// 증가된 크기의 배열을 생성하여 arr 배열 깊은 복사
				String[] copyArr = new String[arr.length + addSize];

				for(int i=0; i<arr.length; i++) { // 기존 배열 크기 만큼만 반복
					copyArr[i] = arr[i]; // 복사본 배열에 기존 배열 값을 같은 인덱스에 대입
				}

				// 배열 얕은 복사
				arr = copyArr; // arr이 참조하는 주소 값을
				// copyArr 의 주소 값으로 바꿔서
				// arr이 참조하는 배열의 크기가 증가한 것처럼 보이게 함

			} else {
				System.out.print(Arrays.toString(arr));
				break; // while문 반복 종료
			}
		}





	}

}
