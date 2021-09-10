package com.douzone.paint.point;

import com.douzone.paint.i.Drawable;

public class Point implements Drawable{
	private int x;
	private int y;
	
	public Point() {
		// super를 사용하려면 생성해주어야 함
	}

	public Point(int x, int y) {
		this.x = x; // 생성자를 명시했기 때문에 기본 생성자가 없어짐
		this.y = y;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void show() {
		System.out.println("점[x=" + x + ", y=" + y + "]을 그렸습니다.");

	}
	
	public void show(boolean visible) {
		if(visible) {
//			System.out.println("점[x=" + x + ", y=" + y + "]을 그렸습니다.");
			show();
		} else {
			System.out.println("점[x=" + x + ", y=" + y + "]을 지웠습니다.");
		}
	}

	@Override
	public void draw() {
		// implements 하면 생성됨
		show();
		
	}
	
//	public void disapear() {
//		System.out.println("점[x=" + x + ", y=" + y + "]을 지웠습니다.");
//	}

}
