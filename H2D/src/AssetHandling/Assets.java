package AssetHandling;

import java.awt.image.BufferedImage;

import Interfaces.Preloadable;

public class Assets implements Preloadable{

	private boolean isLoaded = false;
	public final BufferedImage defaultImage = new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_GRAY);
	public static BufferedImage loadTest;
	
	public void initLoadingScreen() {
		loadTest = ImageLoader.loadImage("res/gfx/LoadTest.png");
	}
	
	public void init() {
		try {
			System.out.println("Assets should sleep now...");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isLoaded = true;
		System.out.println("Finished...");
	}
	
	//Getter
	public boolean isLoaded() {
		return isLoaded;
	}
}