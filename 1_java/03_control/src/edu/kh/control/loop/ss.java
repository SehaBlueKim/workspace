package edu.kh.control.loop;

import java.util.Scanner;

public class ss {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		int sum = 0;
		
		for(int i = 1; i <= input; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}
	

}
