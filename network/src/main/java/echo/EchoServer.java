package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성 
			serverSocket = new ServerSocket();

			// 2. binding
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 8888));

			// 3. accept - 연결 요청 기다림
			while(true) {
				Socket socket = serverSocket.accept();
				// EchoServerReceiveThread 생성
				new EchoServerReceiveThread(socket).start();
				// Thread thread = new EchoServerReceiveThread(socket);
				// thread.start();
			}
		} catch (IOException e) {
			log("[server] error " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}
}