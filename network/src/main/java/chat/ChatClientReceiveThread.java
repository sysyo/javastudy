package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClientReceiveThread extends Thread {
	Socket socket = null;
	BufferedReader bufferedReader = null;

	public ChatClientReceiveThread(Socket socket, BufferedReader bufferedReader) {
		this.socket = socket;
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void run() {
		/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			while (true) {
				String request = bufferedReader.readLine();
				System.out.println(request);
			}

		} catch (IOException e) {
			ChatClient.log("[client] error : " + e);
		} finally { // 자원 정리
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
