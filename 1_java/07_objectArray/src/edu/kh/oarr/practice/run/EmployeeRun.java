package edu.kh.oarr.practice.run;

import edu.kh.oarr.practice.model.service.EmployeeService;

public class EmployeeRun {
	
	public static void main(String[] args) {
		
		EmployeeService emp = new EmployeeService();
		
		emp.displayMenu();
		
	}

}
