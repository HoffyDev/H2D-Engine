/*	 ________________
 *	|				 |
 *	| EXECUTOR-CLASS |
 *	|________________|
 *
 *	DESCRIPTION:
 *	This class contains the main game-loop. So basically the whole program
 *	happens in here. If you want to make changes to the program-flow, like changing
 *	or other stuff, I recommend doing this in the "General.txt"-config file. You can
 *	find it in the "cfg" directory in "res".
 *	It is not recommended to do changes in here if you are not sure what you are
 *	doing.
 *	Feel free to explore or even try to make improvements. Each Functon will have
 *	its own Explanation.
 *
 *	More notably, this class takes care of FPS-Management, setting up the Window or
 *	loading the required resources.
 *
 *	Usage:
 *	Since this this is the "Main-Program", there isn't really a use-case for this.
 *	But again, feel free to look into this if you want to understand what happens
 *	in the back, or want to suggest improvements.
 *
 *	#ShareUrCuriosity&Knowledge
 *
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import AssetHandling.Asset;
import AssetHandling.ImageLoader;
import Frame.Display;
import Things.Thing;

public class Main extends Thread{
	private static int fps = 0; //Move into run()?
	private final static int TARGETFPS = 60; //change to work with cfg
	
	private static Display d = new Display(); //>> This sets up the window. See the "Display" class for more info
	
	private static State currState; /* 
									   >> This is the State the Program is in right now, your code should happen inside a
									   >> State. For more info see the abstract class "State"
									*/

	public static void main(String[] args) { // >> This is the main method... do I really need to explain this?
		Main main = new Main();
		AssetLoader assetLoader = new AssetLoader();
		/*
		 	>> Creates an Instance of the Main- and AssetLoader-Class for Multi-Threading
		 	>> For more info, see the "AssetLoader"-Class
		 */
		
		assetLoader.start(); //Calls the run()-Method of the AssetLoader in a new Thread
		main.start(); //Calls the run()-Method of Main in a new Thread
	}
	
	@Override
	public void run() {
		Asset.initLoadingScreen();
		
		int frames = 0;
		long timePerFrameInNano = 1000000000/TARGETFPS;
		long lastUpdate = System.nanoTime();
		long timer = System.nanoTime();
		
		new Thing(Asset.loadTest, 100, 100, 100, 100);
		
		while(true) {
			if(System.nanoTime()-lastUpdate >= timePerFrameInNano) {
				frames++;
				lastUpdate = System.nanoTime();
				update();
				d.render();
			}
			
			if(System.nanoTime()-timer >= 1000000000) {
				timer = System.nanoTime();
				fps = frames;
				frames = 0;
			}
		}
	}
	
	public static void update() {
		
	}

}
