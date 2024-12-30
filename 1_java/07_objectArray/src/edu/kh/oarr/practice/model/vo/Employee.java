package edu.kh.oarr.practice.model.vo;

public class Employee {

	// 필드 (== 멤버 변수)
	private int empNum;
	private String empName;
	private String empTeam;
	private String empGrade;
	private int empSalary;
	
	// 생성자
	public Employee() {}
	
	public Employee(int empNum, String empName, String empTeam, 
			String empGrade, int empSalary) {
		
		this.empNum = empNum;
		this.empName = empName;
		this.empTeam = empTeam;
		this.empGrade = empGrade;
		this.empSalary = empSalary;
	}

	public int getEmpNum() {
		return empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpTeam() {
		return empTeam;
	}

	public void setEmpTeam(String empTeam) {
		this.empTeam = empTeam;
	}

	public String getEmpGrade() {
		return empGrade;
	}

	public void setEmpGrade(String empGrade) {
		this.empGrade = empGrade;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "사번 : " + empNum + ", 이름 : " + empName + ", 부서 : "
				+ empTeam + ", 직급 : " + empGrade + ", 급여 : " + empSalary;
	}

	
	
	// 메소드
	
	
}
