package chapter03;

public class Goods {

	// 변수 설정
	// 접근지시자 아무것도 안 적으면 default
	// 외부에서 접근 못하도록 private 설정
	private String name;
	private int price;
	private int countStock;
	private int countSold;

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

//	void print() {
//		name = "";
//	}

}
