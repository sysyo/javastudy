package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		try {
			MyClass myClass = new MyClass();
			myClass.danger();
		} catch (Exception e) { // IOException에서 Exception으로 변경
			System.out.println("error : " + e);
		}

	}

}
