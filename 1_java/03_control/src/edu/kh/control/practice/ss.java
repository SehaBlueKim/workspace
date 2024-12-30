package edu.kh.control.practice;

import java.util.Scanner;

public class ss {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		
		int input = sc.nextInt();
		
		for(int i = 1; i <= 9; i ++) {
			
			System.out.printf("%d x %d = %d\n", input, i, input * i);
			
		}
		
	}

}
