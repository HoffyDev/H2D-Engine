package Math2D;

public class Vector {
	private double x, y;
	private String ID = "N/A";
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector(String ID, double x, double y) {
		this.ID = ID;
		this.x = x;
		this.y = y;
	}
	
	public Vector(double x, double y, String ID) {
		this.x = x;
		this.y = y;
		this.ID = ID;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Vector) {
			Vector v = (Vector) o;
			
			//Comparison
			if(v.getXDouble() == this.x && v.getYDouble() == this.y)
				return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "V: [" + x +"|" + y + "] #ID -> " + ID;
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	//VecMath
	public void addX(double x) {
		this.x += x;
	}
	
	public void addY(double y) {
		this.y += y;
	}
	
	public void addVector(Vector v) {
		addX(v.getXDouble());
		addY(v.getYDouble());
	}
	
	public void subX(double x) {
		this.x -= x;
	}
	
	public void subY(double y) {
		this.y -= y;
	}
	
	public void subVector(Vector v) {
		subX(v.getXDouble());
		subY(v.getYDouble());
	}
	
	public double length() {
		return Math.sqrt((x*x) + (y*y)); //>> Pythagoras
	}
	
	public Vector getNormalizedVector() {
		//>> Returns a normalized Variation of the Vector, without altering this instance
		Vector v = new Vector(x, y);
		v.normalize();
		return v;
	}
	
	public void normalize() {
		//>> Sets the length to 1 while retaining the Vectors Orientation
		this.x /= length();
		this.y /= length();
	}
	
	public void rotateBy(double degree) {
		/*
		 * NOTE: This function can only turn a Vector by max 180° at this point
		 */
		
		//>> Convert degree to Radians
        double radians = Math.toRadians(degree);
        
        //>> Normalize the radian to fit in the Interval [-180°, 180°]
        radians = radians % (2 * Math.PI);
        if (radians >= Math.PI) {
        	radians -= 2 * Math.PI;
        } 
        else if (radians < -Math.PI) {
        	radians += 2 * Math.PI;
        }
        
        //>> Calculate new x and y
        this.x = x * Math.cos(radians) - y * Math.sin(radians); //>> Trigonometrical Functions, search for Vector-Rotation to find out more
        this.y = x * Math.sin(radians) + y * Math.cos(radians);
	}
	
	//Setter
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
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
}
