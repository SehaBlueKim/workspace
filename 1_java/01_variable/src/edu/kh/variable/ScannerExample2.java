package edu.kh.variable;

import java.util.Scanner;

public class ScannerExample2 {
	
	public static void main(String[] args) {

	// 사칙 연산 계산기
	// -> 두 실수를 입력 받아 사칙연산 결과를 모두 출력 (소수점 둘째 자리 까지)
		Scanner sc = new Scanner(System.in);
		
	// nextDouble() : 입력 받은 다음 실수를 읽어옴
		System.out.print("실수1 입력 : ");
		double input1 = sc.nextDouble();
		
		System.out.print("실수2 입력 : ");
		double input2 = sc.nextDouble();

	// 출력 예시
	// 실수1 입력 : 1.23
	// 실수2 입력 : 2.01
		
	// 1.23 + 2.01 = 3.24
	// 1.23 - 2.01 = 
	// 1.23 * 2.01 = 
	// 1.23 / 2.01 = 
		
		System.out.printf("%.2f + %.2f = %.2f\n", input1, input2, input1 + input2);
		System.out.printf("%.2f - %.2f = %.2f\n", input1, input2, input1 - input2);
		System.out.printf("%.2f * %.2f = %.2f\n", input1, input2, input1 * input2);
		System.out.printf("%.2f / %.2f = %.2f\n", input1, input2, input1 / input2);

		
	}
	
}
