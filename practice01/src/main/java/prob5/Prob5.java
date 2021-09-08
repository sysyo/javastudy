package prob5;

public class Prob5 {

	public static void main(String[] args) {
		// 반복문을 이용하여 369게임에서 박수를 쳐야 하는 경우의 수를 순서대로 화면에 출력해보세요.
		// 1부터 99까지만 실행하세요.

		for (int i = 1; i < 100; i++) {
			int x = i % 10; // 10의 자리 숫자
			int y = i / 10;// 1의 자리 숫자

			if (y == 3 || y == 6 || y == 9) { // 1의 자리 숫자가 3 / 6 / 9 일 때
				if (i % 3 == 0 && !(i % 10 == 0)) {
					// 10의 자리 숫자를 3으로 나누었을 때s 나머지가 0 이거나
					// 10으로 나누었을 때 나머지가 0이 아닌 것
					System.out.println(i + " 짝짝");
				} else {
					System.out.println(i + " 짝");
				}
			} else if (x == 3 || x == 6 || x == 9) { // 10의 자리 숫자가 3 / 6 / 9 일 때
				System.out.println(i + " 짝");
			}
		}
	}
}
