package com.douzone.paint.point;

public class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String color) {
//		this.x = x;
//		setX(x); // x는 public이고, 부모한테서 내려받은 것이라 사용 가능
//		setY(y);
		super(x,y);
		this.color = color;
 	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println("점[x=" + getX() + ", y=" + getY() + ", color=" + color + "]을 그렸습니다.");

	}
}