package chapter03;

public class Student extends Person { // 부모가 Person
	private int grade;
	private String major;
	
	// 생성자 생성
	public Student() {
		super(); // 명시를 해서 호출하려면 super 만들기
		System.out.println("Student() called"); 
//		super(); // 의도적으로 호출하려면 앞으로 넣어야지 뒷쪽에 넣으면 안됨 (원칙) 
		// 자식 클래스의 생성자에서 부모 클래스의 특정 생성자를 호출해야 할 때는
		// super()를 이용하여 명시적으로 부모클래스의 생성자를 호출한다.
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
