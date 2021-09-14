package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>();

		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("도우너");

		// Integer 객체를 넣겠다
//		Vector<Integer> v = new Vector<>();
//		v.addElement(0); // Auto boxing

		// 순회1
		for (int i = 0; i < v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}

		System.out.println("--------------------------");

		// 삭제
		v.removeElementAt(2); // 도우너 삭제

		
		// 순회2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		} 
		
	}

}
