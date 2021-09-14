package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		
		String ks1 = "one";
		m.put(ks1, 1); 		// auto boxing
		m.put("two", 2); 	
		m.put("three", 3);		
		
//		int i = m.get(new String("one"));	// auto unboxing
		int i = m.get("one");
		int j = m.get(new String("one"));

		System.out.println(i + ":" + j);
		
		m.put("three", 3333333);
		System.out.println(m.get("three"));
		
		// 순회 
		Set<String> s = m.keySet(); // set을 리턴
		for(String key : s) {
//			System.out.println(key); // key 값 꺼내기
			System.out.println(m.get(key)); // 데이터 꺼내기
		}
	}

}
