package AssetHandling;

import java.awt.image.BufferedImage;

import Interfaces.Preloadable;

public class Asset implements Preloadable{

	public static final BufferedImage defaultImage = new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_GRAY);
	public static BufferedImage loadTest;
	
	public static void initLoadingScreen() {
		loadTest = ImageLoader.loadImage("res/gfx/LoadTest.png");
	}
	
	public static void init() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished...");
	}
}