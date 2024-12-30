package edu.kh.poly.ex1.model.vo;

// Car를 상속 받은 자식 클래스 Spark
public class Spark extends Car { // 경차
	
	private double discountRate; // 할인율

	// 기본 생성자
	public Spark() { // super() 생략 시 컴파일러가 자동 추가
	}

	public Spark(int wheel, int seat, String fuel, double discountRate) {
		super(wheel, seat, fuel);
		this.discountRate = discountRate;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return super.toString() + "Spark [discountRate=" + discountRate + "]";
	}
	
	@Override
	public void bindingTest() {
		System.out.println("Spark 자료형 입니다.");
	}
	
}
