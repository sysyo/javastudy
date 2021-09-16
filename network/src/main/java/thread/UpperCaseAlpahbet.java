package thread;

public class UpperCaseAlpahbet {
	public void print() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
