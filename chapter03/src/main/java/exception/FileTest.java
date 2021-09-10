package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
//			FileInputStream fis = new FileInputStream("hello.txt");
			fis = new FileInputStream("hello.txt");
			int data = fis.read();
			System.out.println((char)data);
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("error : " + e);
		} catch (IOException e) {// IOException 발생
			System.out.println("error : " + e);

		} finally {
//			fis.close(); // try/catch 필요
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
