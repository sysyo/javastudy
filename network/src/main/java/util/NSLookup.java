package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
//		String line = "www.douzone.com";
		Scanner scanner = new Scanner(System.in);

		try {
			String line = scanner.nextLine();
			
			// 이름으로 IP를 모두 가져오겠다
			// getAllByName -> 배열
			InetAddress[] inetAddresses = InetAddress.getAllByName(line);

			for (InetAddress inetAddress : inetAddresses) {
				System.out.println("이름 : " + line);
				System.out.println("Address : " + inetAddress.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 

	}

}