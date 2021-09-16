package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitTread();
		Thread thread2 = new AlphabetThread();
		Thread thread3 = new Thread(new UpperCaseAlphabetRunnableImpl());
		// Thread라는 생성자에 Runnable interface를 구현해 안에있는 run()을 부르는 것
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
