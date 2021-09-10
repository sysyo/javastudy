package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		// 문자열을 결합하여 리턴하는 메소드 구현
		String result = "";
		for(String s : strArr) {
			result += s;
		}
		return result;
	}
}


