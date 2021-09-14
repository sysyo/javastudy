package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// WrapperClass는 java.lang 패키지에 포함
		// char와 int 타입이 각각 Character와 Integer로 변경
		// 기본 타입의 첫 문자를 대문자로 바꾼 이름
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		// Boxing : 기본 타입의 값을 포장 객체로 만드는 과정
		// Auto Boxing -> 포장 클래스 타입에 기본값이 대입될 경우 발생
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1 == j2); // true
		System.out.println(j1.equals(j2)); // true
		
		// UnBoxing : 포장 객체에서 기본 타입의 값을 얻어내는 과정
		// "기본타입명 + Value()" 메소드를 호출
		// Auto UnBoxing -> 기본 타입에 포장 객체가 대입될 경우 발생
		int m = j1 + 10;
		// 	int m = j1.intValue() 10;

		System.out.println(m);
	}

}
