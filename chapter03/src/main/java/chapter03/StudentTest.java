package chapter03;

public class StudentTest {

	public static void main(String[] args) {
//		new Student(); // chapter03.Student
		/* 특별한 지시가 없으면 자식 클래스의 생성자가
		* 기본 생성자이든 매개변수를 가진 생성자이든
		* 부모 클래스의 기본 생성자가 선택되게 된다.
		*/
		
		Student s1 = new Student();
		s1.setGrade(1);
		s1.setMajor("cs");
		
		// UpCasting
		Person p1 = s1; // UpCasting (암시적, Implicity) 
		p1.setName("둘리"); // setName은 부모한테 있는 것 
		// 원래는 ((Person)s1).setName("둘리"); 로 적어야하지만 암시적으로 표현
		// s1.setName 으로도 가능
		
//		Student s2 = p1; // 오류 -> 명시를 해서 다운캐스팅 필요
		Student s2 = (Student)p1;
		s2.setMajor("cs");
		
		
	}

}
