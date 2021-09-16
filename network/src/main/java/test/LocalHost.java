package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		// localHost : 프로그램이 돌고 있는 지역 / 자신의 PC		
		// InetAddress : 자바에서 IP 주소를 표현할때 사용하는 클래스
		//               Host 이름 + IP 주소
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			System.out.println("inetAddress : " + inetAddress);
			
			String hostname = inetAddress.getHostName(); // Host 이름
			System.out.println(hostname); // 결과 : 704-31
			
			String hostAddress = inetAddress.getHostAddress();
			System.out.println(hostAddress); // 결과 : 112.162.204.162
			
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
//				System.out.println((int)address); // 결과 : -94 / -52 / -94
				System.out.print(address & 0x000000ff);  // 결과 : 162 / 204 / 162
				// 맨 앞의 바이트를 리셋 (부호비트 - 이기 때문에)
				// 0x00 : 16진수
				System.out.print('.');
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
