package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
//	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 8080;
	// main thread에서 PrintWirter를 담을 수 있는 List 생성
	static List<Writer> listWriters = new ArrayList<Writer>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
//			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
//			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));

			log("연결 기다림 " + hostAddress + ":" + PORT);
			
			// 3. 요청 대기
			while(true) {
				Socket socket = serverSocket.accept();
				// 요청이 수락하고 스레드를 생성할 때, 
				// socket과 List 객체의 스레드를 생성자를 통해 전달한다 
				new ChatServerThread(socket, listWriters).start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void log(String log) {
		System.out.println("[ChatServer] " + log);		
	}

}
