package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		/*
		* StirngBuffer : 내부 버퍼(buffer: 데이터를 임시로 저장하는 메모리)에
		* 문자열을 저장해 두고, 그 안에서 추가, 수정, 삭제 작업을 할 수 있음
		* append(...) : 문자열 끝에 주어진 매개값을 추가
		* reverse() : 문자열의 순서를 뒤바꿈
		*/ 
		
		StringBuffer sb = new StringBuffer(); 
		sb.append(str);
		System.out.println(sb.reverse());
		
		return null;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println(array);
	}
}