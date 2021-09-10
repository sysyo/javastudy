package chapter04;

import java.util.Objects;

public class Rect {
	private int width;
	private int height;
	
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) // getClass() 는 현재 참조하고있는 클래스의 정보를 담고있다.
			return false;
		Rect other = (Rect) obj;
		return height == other.height && width == other.width;
	}


	@Override
	public String toString() {
		return "Rect [width=" + width + ", height=" + height + "]";
	}
}