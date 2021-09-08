package chapter03;

public class Song {

	private String title;
	private String artist;
	private String album;
	private String composer;
	private int year;
	private int track;
	
	public Song(String title, String artist) {
// 중복된 코드는 지우기
//		this.title = title;
//		this.artist = artist;
		// some code... 객체를 만들고 추가로 코드를 생성해야 할 때
		this(title, artist, null, null, 0, 0);

	}
	
	public Song(String title, String artist, String composer, String album, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.composer = composer;
		this.album = album;
		this.year = year;
		this.track = track;
		// some code... 객체를 만들고 추가로 코드를 생성해야 할 때
		System.out.println("some code...");
		
	}
	
	public void show() {
		System.out.println(
				artist + " " + 
				title  + " ( " + 
				album + ", " + 
				year + ", " + 
				track + "번 track, " + 
				composer + " 작곡 )");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getComposer() {
		return composer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	

}
