package prob01;

public class Printer {

	public static void main(String[] args) {

	}

//	public void println(int i) {
//		System.out.println(i);
//		
//	}
//
//	public void println(boolean b) {
//		System.out.println(b);
//	}
//
//	public void println(double d) {
//		System.out.println(d);
//		
//	}
//
//	public void println(String s) {
//		System.out.println(s);
//		
//	}

	public <T> void println(T t) {
		System.out.println(t);
	}

	public <T> void println(T... ts) {
		// 가변인자 - 컬렉션이나 배열 대신 이용 / for문으로 출력
		for(T t: ts) {
			System.out.println(t);
		}
	}

	// --------------------------------------------

	public int sum(Integer... nums) {
		int sum = 0;
		for (Integer i : nums) {
			sum += i;
		}
		return sum;
	}

}
