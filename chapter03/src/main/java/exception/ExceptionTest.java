package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;

		System.out.println("some code1...");
//		int result = (1+2+3)/b;
//		System.out.println("some code2..."); // 예외 발생으로 수행되지 않음

		try {
			System.out.println("some code2...");
			int result = (1 + 2 + 3) / b;
			System.out.println("some code3...");
			System.out.println("some code4...");
		} catch (ArithmeticException e) {
			/* 예외처리 */
			// 1. 사과
			System.out.println("미안합니다~");
			// 2. 로깅
			System.out.println("error:" + e);
			// 3. 정상종료
			return;
		} finally {
			System.out.println("자원 정리");
		}

//		System.out.println("some code4..."); // finally 아래는 코드 안적는 게 좋음
	}

}
