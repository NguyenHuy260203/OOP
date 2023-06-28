package lib;

import java.awt.geom.Point2D;

public class Point extends Point2D {
	private double x, y;
	
	public Point(double d, double e) {
		this.x = d;
		this.y = e;
	}
	public Point() {
		this(0, 0);
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void mul(double x) {
		this.x *=x;
		this.y*=x;
	}
	public void setLocation(Point point) {
		this.x = point.getX();
		this.y = point.getY();
	}
	
	public void add(Point point) {
		this.x += point.getX();
		this.y += point.getY();
	}
	public void sub(Point point) {
		this.x -= point.getX();
		this.y -= point.getY();
	}
	public double doDai() {
		return Math.sqrt(x*x + y*y);
	}
	public double angle() {
		if(y>0) {
			return Math.acos(x/this.doDai());
		}
		else return 2*3.14 - Math.acos(x/this.doDai());
	}
	public void rotateLeft(double angle) {
		angle = this.angle() + angle;
		x = this.doDai() * Math.cos(angle);
		y = this.doDai() * Math.sin(angle);
	}
	public void mul(int x2) {
		// TODO Auto-generated method stub
		this.x *=x2;
		this.y*=x2;
		
	}
}
