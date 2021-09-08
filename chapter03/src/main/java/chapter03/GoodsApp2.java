package chapter03;

import mypackage.Goods2;

public class GoodsApp2 {

	public static void main(String[] args) {
		Goods2 g = new Goods2();
		
		// public은 접근 제한이 없다.
		g.name = "camera";
		
		// proteted는 같은 패키지 안에서 접근이 가능하다.
		// 더 중요한 것은 자식에서도 접근이 가능하다는 것이다.
//		g.price = 1000; // mypackage로 Good2 이동시 접근 불가
		
		// 디폴트는 같은 패키지에서 접근이 가능하다.
//		g.countStock = 10; // mypackage로 Good2 이동시 접근 불가
		
		// private은 같은 class 안에서만 접근이 가능하다.
// 		g.countSold = 10; // 접근 불가
	}

}
