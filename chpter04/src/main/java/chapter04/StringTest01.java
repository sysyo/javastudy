package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// escape 문자
		// : 제어문자, 화면에 출력하는 문자가 아니라 제어하는 문자
		// ex) \n, \r, \t 
		
		// c:\temp 출력하기
//		System.out.println("c:\tmep"); // c:	mep 출력
		System.out.println("c:\\tmep");
		
		// "hello"
		System.out.println("\"hello\"");
		
		// \t : tab
		// \r : carrige return
		// \n : newline
		// \b : beep
		System.out.println("hello\tworld\n");
		System.out.println("hello\tworld");
		
		// '
		char c = '\'';
		System.out.println(c);
	}

}
