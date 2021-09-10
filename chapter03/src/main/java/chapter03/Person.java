package chapter03;

public class Person {
	private String name;

	// 기본 생성자 생성
	public Person() { // 부모
		System.out.println("Person() called");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
