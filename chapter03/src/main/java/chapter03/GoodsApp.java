package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		
		// 변수이름은 소문자로, 확인할 수 있는 문자로 설정
		Goods goods = new Goods();
//		goods.		
		// 접근지시자 private 으로 인해 Goods 안의 private 달린 변수로는 접근 불가
		
		// Getter / Setter 생성 후 
		goods.setName("Nikon");
		goods.setPrice(2000);
		goods.setCountStock(10);
		goods.setCountSold(20);
		// 로직을 먼저 세우고 에러뜨면 Create method로 method 생성하기 
		// public void showInfo() {}

		
//		System.out.println(goods);
		// 출력결과 : chapter03.Goods@15db9742
		// toString 결과를 불러옴, 객체의 위치 (address)를 Hashing

		goods.showInfo();
		// 로직 세운 이후 결과 불러오기
		
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		int discountPrice = goods.calDiscountPrice(50);
		System.out.println(discountPrice);

		System.out.println(Goods.countOfGoods);
		
		//-----------------------------------------
		
		String s = "콜라 1000 10";
		String[] tokens = s.split("");
		for(String str : tokens) {
			System.out.printf(str);
		}
	}

}
