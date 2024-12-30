package edu.kh.oarr.practice.model.service;

import java.util.Scanner;

import edu.kh.oarr.practice.model.vo.Employee;

public class EmployeeService {

	private Scanner sc = new Scanner(System.in);

	private Employee[] empArr = new Employee[3];
	// 사원의 정보를 저장할 Employee 배열

	// 메뉴 화면 출력 기능의 메소드
	public void displayMenu() {

		int menuNum = 0;

		do {
			System.out.println("=== 직원 관리 프로그램 ===");
			System.out.println("1. 직원 정보 입력(3명)");
			System.out.println("2. 모든 직원 정보 출력");
			System.out.println("3. 특정 직원 정보 출력(이름 검색)");
			System.out.println("4. 특정 직원 급여/연봉 출력(사번 검색)");
			System.out.println("5. 모든 직원 급여 합/연봉 합 출력");
			System.out.println("6. 모든 직원 중 급여가 가장 높은 직원의 이름, 부서, 급여 출력");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 >> ");
			menuNum = sc.nextInt();
			System.out.println();

			switch(menuNum) {
			case 1 : signUp(); break;
			case 2 : System.out.println(allEmployeesInfo()); break;
			case 3 : search(); break;
			case 4 : selectSalary(); break;
			case 5 : salarySum(); break;
			case 6 : topSalaryEmp(); break;
			case 0 : System.out.println("프로그램 종료"); break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		} while(menuNum != 0);
	}



	// 1. 직원 정보 입력(3명)
	public void signUp() {

		for(int i=0; i<empArr.length; i++) {
			System.out.printf("=== %d번째 사원 정보 입력 ===\n", i+1);
			System.out.print("사번 : ");
			int inputNum = sc.nextInt();

			System.out.print("이름 : ");
			String inputName = sc.next();

			System.out.print("부서 : ");
			String inputTeam = sc.next();

			System.out.print("직급 : ");
			String inputGrade = sc.next();

			System.out.print("급여 : ");
			int inputSalary = sc.nextInt();
			System.out.println();

			empArr[i] = new Employee(inputNum, inputName, inputTeam, inputGrade, inputSalary);
		}
	}



	// 2.모든 직원 정보 출력용
	// String 버전
	public String allEmployeesInfo() {

		String str = "";
		for(int i=0; i<empArr.length; i++) {
			str += empArr[i].toString() + "\n";
		}
		return str;
	}

	/* 문자열 바로 출력 버전
	 * public void allEmployeesInfo() {

			for(int i=0; i<empArr.length; i++) {
			System.out.println(empArr[i].toString());
		}
		System.out.println();
	}
	 */



	// 3. 특정 직원 정보 출력(이름 검색)
	public void search() {
		System.out.println("=== 특정 사원 정보 출력(이름 검색) ===");

		System.out.print("이름 입력 : ");
		String inputName = sc.next();

		boolean flag = true;

		// 1) empArr 배열의 모든 요소 순차 접근
		for(int i=0; i<empArr.length; i++) {

			// 2) empArr[i] 요소가 null인 경우 반복 종료
			if(empArr[i] == null) {
				break;
			}

			// 3) empArr[i] 요소에 저장된 이름이
			//	  입력 받은 이름과 같을 경우 사원 정보 출력
			if(empArr[i].getEmpName().equals(inputName)) {
				System.out.println(empArr[i].toString()+"\n");

				flag = false;
			}
		}

		// 4) 검색 결과가 없을 경우 "일치하는 이름의 사원이 없습니다."
		if(flag) {
			System.out.println("일치하는 이름의 사원이 없습니다.\n");
		}
	}



	// 4. 특정 직원 급여/연봉 출력(사번 검색)
	// 선생님 답안 String 버전
	public String selectSalary() {
		System.out.println("\n==급여/연봉 조회==");
		System.out.print("사번 입력 : ");
		int inputNum = sc.nextInt();

		for(int i =0; i<empArr.length;i++) {

			if(inputNum == empArr[i].getEmpNum()) {
				return "급여 : " + empArr[i].getEmpSalary() 
						+" / 연봉 : " + 12*empArr[i].getEmpSalary() + "\n";
			}
		}
		return "사번이 일치하는 직원 없습니다.";
	}


	/* 내 답안
	 * public void salary() {
		System.out.println("=== 급여/연봉 조회 ===");

		System.out.print("사번 입력 : ");
		int inputNum = sc.nextInt();

		boolean flag = true;

		// 1) empArr 배열의 모든 요소 순차 접근
		for(int i=0; i<empArr.length; i++) {

			// 2) empArr[i] 요소가 null인 경우 반복 종료
			if(empArr[i] == null) {
				break;
			}

			// 3) empArr[i] 요소에 저장된 사번이
			//	  입력 받은 사번과 같을 경우 사원의 급여, 연봉 출력
			if(empArr[i].getEmpNum()==(inputNum)) {
				System.out.printf("급여 : %d / 연봉 : %d\n", empArr[i].getEmpSalary(), empArr[i].getEmpSalary()*12);
				System.out.println();
				flag = false;
			}
		}
		if(flag) {
			System.out.println("사번이 일치하는 직원이 없습니다.\n");
		}
	} */



	// 5. 모든 직원 급여 합/연봉 합 출력
	public void salarySum() {
		System.out.println("=== 모든 사원 급여 합/연봉 합 ===");

		int salarySum = 0;

		for(int i=0; i<empArr.length; i++) {
			salarySum += empArr[i].getEmpSalary();
		}
		System.out.println("전 직원 급여 합 : " + salarySum);
		System.out.println("전 직원 연봉 합 : " + salarySum*12);
	}



	// 6. 모든 직원 중 급여가 가장 높은 직원 출력
	// 선생님 답안
	public void topSalaryEmp() {
		int max = empArr[0].getEmpSalary();

		// 가장 높은 급여를 찾기 위한 for문
		for(int i=0; i<empArr.length; i++) {
			if(max < empArr[i].getEmpSalary()) {
				max = empArr[i].getEmpSalary();
			}
		}
		// 가장 높은 급여를 가진 직원의 정보 출력
		for(int i=0; i<empArr.length; i++) {
			if(max == empArr[i].getEmpSalary()) {
				System.out.println("이름은 : " + empArr[i].getEmpName()
						+ ", 부서 : " + empArr[i].getEmpTeam()
						+ ", 급여 : " + empArr[i].getEmpSalary() + "\n");
			}
		}
	}

	/* 내 답안
	 * public void maxSalary() {
		int maxSalary = empArr[0].getEmpSalary(); // 첫번째 직원으로 초기화
		String maxName = empArr[0].getEmpName();
		String maxTeam = empArr[0].getEmpTeam();

		for(int i=0; i<empArr.length; i++) {
				if(empArr[i].getEmpSalary() > maxSalary) {
					maxSalary = empArr[i].getEmpSalary();
					maxName = empArr[i].getEmpName();
					maxTeam = empArr[i].getEmpTeam();
				}
			}
		System.out.printf("이름 : %s, 부서 : %s, 급여 : %d\n", maxName, maxTeam, maxSalary);
	} */





}
