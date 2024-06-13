package Things;

import java.awt.image.BufferedImage;

import Frame.Display;

//Most Basic Object
public class Thing {
	private int x, y, width, height;
	private BufferedImage img;
	
	public Thing(BufferedImage img, int x, int y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = img.getWidth();
		this.height = img.getHeight();
		Display.renderQueue.add(this);
	}
	
	public Thing(BufferedImage img, int x, int y, int width, int height) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		Display.renderQueue.add(this);
	}
	
	public void delete() {
		Display.renderQueue.remove(this);
	}
	
	//GETTERS & SETTERS
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public BufferedImage getImage() {
		return img;
	}
}
