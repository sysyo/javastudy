package chapter03;

public class Goods {
	public static int countOfGoods = 0;
	// 변수 설정
	// 접근지시자 아무것도 안 적으면 default
	// 외부에서 접근 못하도록 private 설정
	private String name;
	private int price;
	private int countStock;
	private int countSold;

	public Goods() {
		countOfGoods = countOfGoods + 1;
	}
	
	
	// Getter / Setter 생성
	// public은 외부에서 사용 가능
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		// GoodsApp.java에서 
		// 로직을 먼저 세우고 에러뜨면 Create method로 method 생성하기 
		System.out.println(
//				"name:" + Nikon + 
//				", price:" + 1000 +
//				", countStock:" + 10 +
//				", countSold:" + 10);
				"name:" + name + 
				", price:" + price +
				", countStock:" + countStock +
				", countSold:" + countSold);
		
		// GoodsApp에서 showInfo 호출해서 결과 출력하기
	}

//	void print() {
//		name = "";
//	}
	
	public int calDiscountPrice(int percentage) {
		return price * percentage / 100;
	}

}
