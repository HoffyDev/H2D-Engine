package Math2D;

public class Vector {
	private double x, y;
	private String ID = "";
	
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
	
	public Vector clone() {
		return new Vector(x, y);
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
		//>> I think these are obvious
		this.x += x;
	}
	
	public void addY(double y) {
		//>> Just like this
		this.y += y;
	}
	
	public void addVector(Vector v) {
		//>> Adds the x and y of a Vector to this Vector's x and y
		addX(v.getXDouble());
		addY(v.getYDouble());
	}
	
	public void subX(double x) {
		//>> Guess what this does...
		this.x -= x;
	}
	
	public void subY(double y) {
		//>> I mean, even a blind guy can see what this does...
		this.y -= y;
	}
	
	public void subVector(Vector v) {
		//>> Its like addVector(), but different...
		subX(v.getXDouble());
		subY(v.getYDouble());
	}
	
	public void multiplyBy(double f) {
		this.x *= f;
		this.y *= f;
	}
	
	public void divideBy(double d) {
		this.x /= d;
		this.y /= d;
	}
	
	public double length() {
		//>> Returns the length of the Vector... THROUGH THE POWER OF MATH!!!
		return Math.sqrt((x*x) + (y*y)); //>> Pythagoras
	}
	
	public void setLength(double length) {
		//>> Resizes the Vector to the given length
		normalize();
		multiplyBy(length);
	}
	
	public Vector getNormalizedVector() {
		//>> Returns a normalized Variation (length = 1) of the Vector, without altering this instance
		Vector v = this.clone();
		v.normalize();
		return v;
	}
	
	public void normalize() {
		//>> Sets the length to 1 while retaining the Vectors Orientation (is retaining a word?)
		this.x /= length();
		this.y /= length();
	}
	
	public void rotateBy(double degree) {
		//>> This is a Helper-Function to ensure that only Values up to 180° are used
		//>> See the doRotateBy-Function to see how the Rotation works
		degree %= 360;
		if(degree > 180) {
			doRotateBy(180);
			degree -= 180;
		}
		doRotateBy(degree);
	}
	
	private void doRotateBy(double degree) {
		/*
		 * NOTE: This function can only turn a Vector by max 180° (Hence the Helper-Function)
		 */
		
		//>> Convert degree to Radians
        double radians = Math.toRadians(degree);
        
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
