package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {
	// [ChatServer] 연결 기다림 192.168.35.61:8080
//	private static final String SERVER_IP = "192.168.35.61";
	private static final String SERVER_IP = "210.113.134.157";
	private static final int SERVER_PORT = 8080;
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			log("Connected To Server.");

			// 4. reader/writer 생성
			// 들어오는 데이터 (입력)
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			// 나가는 데이터 (출력)
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			printWriter.println("join:" + nickname);
			printWriter.flush();

			// 6. ChatClientReceiveThread 시작
			// creat field 'thread'
			ChatClientReceiveThread thread = new ChatClientReceiveThread(socket, bufferedReader);
			// Thread.Start() : 운영 체제에서 현재 인스턴스의 상태를 Running으로 변경
			thread.start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input)) {
					// 8. quit 프로토콜 처리
					log("quit:" + nickname);
					break;
				} else {
					// 9. 메시지 처리
					printWriter.println("message:" + input);
				}
			}
		} catch (SocketException e) {
			log("suddenly closed by client");
		} catch (IOException e) {
			log("error:" + e);
		} finally { // 10. 자원 정리
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				log("자원 정리 error:" + e);
			}
		}
	}

	static void log(String logString) {
		System.out.println("[ChatClient] " + logString);
	}

}

// cd C:\douzone2021\eclipse-workspace\javastudy\network\target\classes
// java chat.ChatClient
