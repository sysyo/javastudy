
public class WrapperClassTest01 {

	public static void main(String[] args) {
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		// Auto Boxing
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1 == j2); // true
		System.out.println(j1.equals(j2)); // true
		
		// Auto UnBoxing
		int m = j1 + 10;
		// 	int m = j1.intValue() 10;

		System.out.println(m);
	}

}
