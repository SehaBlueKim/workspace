package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People;

// Service : 특정 기능(비즈니스 로직)을 제공하는 클래스
public class AbstractionService {

	public void ex1() {
		// People 클래스를 이용해서 국민 객체 만들기
		
		// 클래스 == 설계도 == 사용자 정의 자료형
		
		People p1 = new People();
		
		// People p1 : People 객체의 주소를 저장하여 참조하는 변수 p1을 선언
		
		// new : Heap 영역에 새롭게 할당(생성)
		
		// new People() : People 클래스를 이용해서 
		//				  Heap 영역에 People 객체를 생성한다(=메모리를 할당한다)
		//				  -> 할당된 메모리의 시작 주소가 반환됨
		
		// People p1 = new People();
		// People 참조 변수 p1에
		// Heap에 새로 생성된 People 객체의 주소를 대입하겠다 라는 의미
		
		// p1 == People 객체를 참조하는 변수
		// == People 객체를 의미함
		          
		// p1.name = "김세하"; // The field People.name is not visible
		// 직접 접근 방법
		
		p1.setName("김세하");
		// setter를 이용한 간접 접근 방법
		
//		p1.gender = '여';
		p1.setGender('여');
		
//		p1.address = "경기도 안양시";
		p1.setAddress("경기도 안양시");
		
//		p1.phone = "010-1234-5678";
		p1.setPhone("010-1234-5678");
		
//		p1.age = 30;
		p1.setAge(30);
		
//		p1.pNo = "931223-1234567";
		p1.setpNo("931223-1234567");
		
//		p1.job = "학생";
		p1.setJob("학생");
		
		System.out.println("p1의 name : " + p1.getName());
		System.out.println("p1의 gender : " + p1.getGender());
		System.out.println("p1의 address : " + p1.getAddress());
		System.out.println("p1의 phone : " + p1.getPhone());
		System.out.println("p1의 age : " + p1.getAge());
		System.out.println("p1의 pNo : " + p1.getpNo());
		System.out.println("p1의 job : " + p1.getJob());
		
		
		System.out.println("---------------------------------");
		
		People p2 = new People();
		
		/*
		p2.name = "차은우";
		p2.gender = '남';
		p2.address = "서울시 강남구 테헤란로 G강의장";
		p2.phone = "010-1234-5678";
		p2.age = 27;
		p2.pNo = "970330-1234567";
		p2.job = "아이돌";
		
		System.out.println("p2의 name : " + p2.name);
		System.out.println("p2의 gender : " + p2.gender);
		System.out.println("p2의 address : " + p2.address);
		System.out.println("p2의 phone : " + p2.phone);
		System.out.println("p2의 age : " + p2.age);
		System.out.println("p2의 pNo : " + p2.pNo);
		System.out.println("p2의 job : " + p2.job);
		*/
		p2.tax();
		p2.vote();
		p2.introduce();
		p1.introduce();
	}
}
