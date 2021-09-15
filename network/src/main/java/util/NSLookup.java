package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		String line = "www.douzone.com";
		
		try {
			InetAddress[] inetAddresses = InetAddress.getAllByName(line);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} // 이름으로 IP를 모두 가져오겠다

	}

}
