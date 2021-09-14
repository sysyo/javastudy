package chapter04;

public class MyClassTest {

	public static void main(String[] args) {
		/* 싱글톤(Singleton)
		* 객체가 단 하나만 생성
		* 외부에서 new 연산자로 생성자를 호출할 수 없도록 막아야 한다.
		* 생성자를 호출한 만큼 객체가 생성되기 때문
		*/
		
		// MyClass myClass0 = new MyClass();
		
		MyClass myClass1 = MyClass.getInstance();
		MyClass myClass2 = MyClass.getInstance();

		System.out.println(myClass1 == myClass2);

	}

}
