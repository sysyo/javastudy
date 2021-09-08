package chapter03;

public class StaticMethod {
	// 인스턴스 변수 생성
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(StaticMethod.m); //StaticMethod. 은 생략 가능
		// 같은 클래스에서는 클래스(static) 변수 접근에서는 클래스 이름 생략이 가능하다.
		System.out.println(m);
	}
	
	void f3() {
		f2();
	}
	
	static void s1() {
		// 오류 : static method 에서는 instance 변수에 접근할 수 없다.
//		System.out.println(n);
	}
	
	static void s2() {
		System.out.println(StaticMethod.m);
		// 같은 클래스에서는 클래스(static) 변수 접근에서는 클래스 이름 생략이 가능하다.
		System.out.println(m);
	}
	
	static void s3() {
		// 오류 : static method 에서는 instance method에 접근 할 수 없다.
//		f1(); 
	}
	
	static void s4() {
		StaticMethod.s1(); // StaticMethod. 생략 가능
		s1();
	}
	
	// static 은 순수 함수를 쓸 때 사용한다.
	
}
