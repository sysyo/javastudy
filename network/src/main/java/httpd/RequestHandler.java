package httpd;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RequestHandler extends Thread {
	private Socket socket;
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
					
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
			outputStream.write( "HTTP/1.1 200 OK\n".getBytes("UTF-8") ); // HTTP 프로토콜에 있는 형식으로 맞춘 것
			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8") );
			outputStream.write( "\n".getBytes() ); // 경계로 윗쪽은 Header 아래쪽은 body
			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );

		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	public void consoleLog( String message ) {
		// Thread Id -> getId => extends Thread이기 때문에
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
