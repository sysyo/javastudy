package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;
	private static ChatClientReceiveThread thread;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		// 1. 키보드 연결
		scanner = new Scanner(System.in);

		// 2. socket 생성
		socket = new Socket();

		// 3. 연결
		try {
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			log("Connected To Server.");

			// 4. reader/writer 생성
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			printWriter.println("join:" + nickname);
			printWriter.flush();

			// 6. ChatClientReceiveThread 시작
			// creat field 'thread'
			thread = new ChatClientReceiveThread();
			// Thread.Start() : 운영 체제에서 현재 인스턴스의 상태를 Running으로 변경
			thread.start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					break;
				} else {
					// 9. 메시지 처리
				}
			}

		} catch (IOException e) {
			log("[client] error: " + e);
		}
	}

	private static void log(String logString) {
		System.out.println(logString);

	}

}
