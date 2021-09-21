package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {
	/*
	 * 1. 스레드의 인스턴스 변수 - 통신을 위한 스트림을 얻어 오기 위해 Socket 객체를 저장해야 한다 - 연결된 클라이언트의 닉네임을
	 * 저장하고 있어야 한다.
	 */

	private String nickname;
	private Socket socket;
	// 데이터 통신 스레드들에서 이 List를 공유해야하기 때문에 스레드에 List 객체를 참조하는 변수 추가
	private List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	BufferedReader bufferedReader = null;
	PrintWriter printWriter = null;

	/*
	 * 
	 * 2. 요청 처리를 위한 Loop 작성 - run 메소드 오버라이딩 - main thread로 부터 전달받은 socket을 통해 IO
	 * Stream을 받아오는데 문자 단위 처리와 라인 단위 읽기를 위해 보조 스트림 객체를 생성해서 사용한다.
	 */

	// run 메소드 오버라이딩 - extends Thread
	@Override
	public void run() {
		// 1. Remote Host Information
		InetSocketAddress remoteAddr = (InetSocketAddress) socket.getRemoteSocketAddress();
		ChatServer.log("[server] connected by client [" + remoteAddr.getAddress().getHostAddress() + ":"
				+ remoteAddr.getPort() + "]");

		try {
			// 2. 스트림 얻기
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			// 3. 요청 처리
			while (true) {
				String request = bufferedReader.readLine();

				if (request == null) {
					// log("클라이언트로 부터 연결 끊김");
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(printWriter);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else {
					ChatServer.log("에러 : 알 수 없는 요청(" + tokens[0] + ")");
					ChatServer.log(request);
				}

			}

		} catch (IOException e) {
			ChatServer.log("[server] error :" + e);
		} finally {
			try {
				if ((socket != null && socket.isClosed()) == false) {
					socket.close();
				}
			} catch (Exception e) {
			}
		}

	}

	private void doQuit(Writer writer) {
		// “OOO님이 퇴장 하였습니다” 메시지가 브로드캐스팅 되어야 한다.

		// 현재 스레드의 writer를 Writer Pool에서 제거한 후, 브로드캐스팅 한다.
		removeWriter(writer);

		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);

	}

	private void removeWriter(Writer writer) {
		// 현재 스레드의 writer를 Writer Pool에서 제거
		synchronized (listWriters) {
			// synchronized : 여러 스레드가 하나의 공유 객체에 접근할 때, 동기화를 보장 해준다
			// ArrayList.remove(Object o)
			// 인자로 삭제하려는 아이템을 전달하고, 리스트에 그 아이템이 존재하여 삭제되는 경우 true를 리턴
			listWriters.remove(writer);
		}

	}

	private void doMessage(String message) {
		// “message:하이 ^^;\r\n”
		// "nickName:message"
		String data = nickname + ":" + message;
		broadcast(data);

	}

	// doJoin은 한 사용자가 채팅 방에 참여했을 때, 다른 사용자들에게
	// "OOO님이 입장하셨습니다." 라는 메세지를 브로드캐스팅 해야 한다.
	private void doJoin(String nickname, Writer writer) {
		this.nickname = nickname;

		String data = nickname + "님이 참여하였습니다.";
		broadcast(data);

		// writer pool에 현재 스레드의 writer인 printWirter를 저장해야 한다.
		addWriter(writer);

		// ack를 보내 방 참여가 성공했다는 것을 클라이언트에게 알려 줘야 한다.
		printWriter = new PrintWriter(writer);
		printWriter.println("join:ok");
		printWriter.flush();
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			// synchronized : 여러 스레드가 하나의 공유 객체에 접근할 때, 동기화를 보장 해준다
			listWriters.add(writer);
		}
	}

	// 서버에 연결된 모든 클라이언트에 메세지를 보내는 broadcast 메소드
	private void broadcast(String data) {
		synchronized (listWriters) {
			// 스레드 간 공유 객체인 listWriters에 접근하기 때문에 동기화 처리를 해 주어야 한다.
			for (Writer writer : listWriters) {
				// PrintWriter의 메서드를 사용해야하기 때문에 다운캐스팅을 명시적으로 사용
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush(); // 버퍼에 있는 데이터를 모두 처리
			}
		}
	}

	// ChatServer.log
//	private void log(String log) {
//		System.out.println("[ChatServer] " + log);
//
//	}

}
