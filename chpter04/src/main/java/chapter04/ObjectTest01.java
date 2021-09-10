package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10, 20);

//		Class klass =  p.getClass(); 
////		klass.g
		// getClass() 는 현재 참조하고있는 클래스의 정보를 담고있다.
		System.out.println(p.getClass()); // reflection // 결과 : class chapter04.Point
		System.out.println(p.hashCode()); // address 기반의 해싱값
										  // 주소값을 기반으로 생성된 정수값	
										  // address x
										  // reference x
		
		System.out.println(p.toString()); // getClass() + "@" + hashCode()
		System.out.println(p);
		
		// Point.java 에 Generate toString 하면 값이 출력됨
		// 하기 전에는 chapter04.Point@15db9742 (getClass() + "@" + hashCode()) 출력됨
		
	}

}
