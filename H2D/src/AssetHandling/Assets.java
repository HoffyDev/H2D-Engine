package AssetHandling;

import java.awt.image.BufferedImage;

import Interfaces.Preloadable;

public class Assets {

	private static boolean isFullyLoaded = false, isLoaded = false;
	
	public static final BufferedImage defaultImage = new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_GRAY);
	public static BufferedImage loadTest;
	
	public static void initLoadingScreen() {
		System.out.println("Loading Screen initializing now...");
		loadTest = ImageLoader.loadImage("res/gfx/LoadTest.png");
		isLoaded = true;
	}
	
	public static void init() {
		//I will probably introduce a HashMap to automatically load all graphics in the "gfx" folder
		//Then you can call the Graphic through the name, and since its a Hashmap, the access-time should be constant
		//Alternatively you would have to load up every file manually (by using the ImageLoader and the image-path)
		try {
			System.out.println("Assets should sleep now...");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isFullyLoaded = true;
		System.out.println("Finished...");
	}
	
	//Getter
	public static boolean isScreenLoaded() {
		return isLoaded;
	}
	
	public static boolean isFullyLoaded() {
		return isFullyLoaded;
	}
}