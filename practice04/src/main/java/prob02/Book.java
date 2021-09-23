package prob02;

public class Book {

	int bookNo; // 번호
	String title; // 제목
	String author; // 작가
	// 상태코드 (대여유무를 나타내는 상태코드) - 호출 시에 1로 세팅되도록 설정
	int stateCode; 
	
	// 생성자는 BookShop의 main메소드를 참고하여 각 멤버변수를 초기화할 수 있도록 작업
	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		stateCode = 1;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	// 대여기능을 수행하는 메소드
	public void rent() {
		stateCode = 0;
		System.out.println(title + "이(가) 대여 됐습니다.");
	}
	
	public void print() {
		System.out.println("책 제목:" + title + ", 작가:" + author + ", 대여 유무:" + (stateCode == 1? "재고있음" : "대여중")); 
		
	}
	
	

	

}
