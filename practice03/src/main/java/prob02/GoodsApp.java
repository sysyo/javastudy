package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		/*
		 * java.util.Scanner 클래스를 이용하여 상품을 입력받아 Goods 객체를 생성하고 이들을 Goods 객체 배열에 저장하세요.
		 * 상품 즉, Goods 객체를 3개 입력 받으면 이들을 모두 화면에 출력하세요.
		 */

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) { // <= 아님~!!!
			// char, String 입력 받을 때는 nextLine 메서드를 이용 (한 줄 통째로)
			String input_n = scanner.next();
			int input_p = scanner.nextInt();
			int input_c = scanner.nextInt();
			goods[i] = new Goods();
			goods[i].setName(input_n);
			goods[i].setPrice(input_p);
			goods[i].setCount(input_c);
		}

		// 상품 출
		for (int i = 0; i < COUNT_GOODS; i++) {
			System.out.println(
					goods[i].getName() + "(가격:" + goods[i].getPrice() + "원)이 " + goods[i].getCount() + "개 입고 되었습니다.");
		}
		// 자원정리
		scanner.close();
	}
}
