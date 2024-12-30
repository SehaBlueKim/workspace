package edu.kh.variable;

import java.util.Scanner;

public class ScannerExample4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 1 : ");
		String input = sc.next() + " "; // 띄어쓰기 추가
		
		
		System.out.println(input); // 오늘_
		
		System.out.print("입력 2 : ");
		input = input + sc.next() + " ";
		// 대입 연산자(=) : 오른쪽에 값을 왼쪽 변수에 대입하겠다
		
		System.out.println(input); // 오늘_점심_
		
		System.out.print("입력 3 : ");
		input = input + sc.next();
		
		System.out.println(input); // 오늘_점심_뭐먹지?
	}
		
	}



