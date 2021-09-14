package chapter04;

public class MyClass {
	private static MyClass instance = null;

	private MyClass(){		
	}

	
	// Singleton + Factory Method
	public static MyClass getInstance() {
		
		if(instance == null) {
			// private이라 new 가능 -> 내부에서 접근 가능
			instance = new MyClass();
		}
		
		return instance;
	}
	
}
