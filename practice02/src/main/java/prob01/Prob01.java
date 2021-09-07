package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		// final 지시어를 통해 메소드 오버라이드를 제한
		/* 코드 작성 */

		System.out.print("금액 : ");
		int in = scanner.nextInt();

		for (int i = 0; i < MONEYS.length; i++) {
			int count = in / MONEYS[i];
			in -= count * MONEYS[i];

			System.out.println(MONEYS[i] + "원 : " + count + "개");
		}

		scanner.close();
	}
}