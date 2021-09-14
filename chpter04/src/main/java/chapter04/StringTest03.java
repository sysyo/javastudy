package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
//		String s1 = "Hello" + "World" + "Java" + 1.8;
		String s1 = new StringBuffer("Hello")
		.append("World")
		.append("Java")
		.append(1.8)
		.toString();
		
		System.out.println(s1);
		
		String s2 = "";
		for(int i = 0; i < 1000000; i++) {
//			s2 = s2 + i;
//			s2 = new StringBuffer(s2).append(i).toString();
		}
		
		StringBuffer sb2 = new StringBuffer("");
		for(int i = 0; i < 1000000; i++) {
			sb2.append(i);
		}
		String s3 = sb2.toString();
		System.out.println(s3.length());
	
		System.out.println("=====================================");
		
		// String method 들....
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2)); // 문자열에서 문자의 순서 (Index 번호)
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc",7)); // 탐색하려는 문자열이 존재하지 않는다면 -1을 반환
		System.out.println(s4.substring(3)); // 3번부터 끝까지
		System.out.println(s4.substring(3, 5)); // 3번부터 5 -1까지(=4)
		
		String s5 = "    ab    cd    ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6); // concat -> 원래 문자열에 붙여서 새로운 문자열을 리턴
		System.out.println(s7);
		
		// trim
		System.out.println("----" + s5.trim() + "----");
		// replaceAll -> 문자 교체
		System.out.println("----" + s5.replaceAll(" ", "") + "----");
		
		System.out.println("---------------------------------");
		
		// Pashing 할 때 쪼개서 보내는 것 -> tokens
		// split (-> seperate) : "," 을 기준으로 문자 나누기
		String[] tokens = s6.split(",");
		for(String s : tokens) { // 쪼개지지 않을 것 
			System.out.println(s);
		}
		
		String[] tokens2 = s6.split(" ");
		for(String s : tokens2) {
			System.out.println(s);
		}
	}
	

}
