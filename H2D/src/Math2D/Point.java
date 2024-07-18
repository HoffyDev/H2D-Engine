package Math2D;

import Frame.Display;

public class Point {
	private double x, y;
	private String ID = "";
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(String ID, double x, double y) {
		this.ID = ID;
		this.x = x;
		this.y = y;
	}
	
	public Point(double x, double y, String ID) {
		this.x = x;
		this.y = y;
		this.ID = ID;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Point) {
			Point p = (Point) o;
			
			//Comparison
			if(p.getXDouble() == this.x && p.getYDouble() == this.y)
				return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "P: [" + x +"|" + y + "] #ID -> " + ID;
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	//Setters
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	//Getters
	public int getXInt() {
		return (int) x;
	}
	
	public double getXDouble() {
		return x;
	}
	
	public int getYInt() {
		return (int) y;
	}
	
	public double getYDouble() {
		return y;
	}
	
	public String getID() {
		return ID;
	}
}
