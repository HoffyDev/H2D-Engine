/*	 ________________
 *	|				 |
 *	| EXECUTOR-CLASS |
 *	|________________|
 *
 *	DESCRIPTION:
 *	This class contains the main game-loop. So basically the whole program
 *	happens in here. If you want to make changes to the program-flow, like changing FPS
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
 *	USAGE:
 *	Since this this is the "Main-Program", there isn't really a use-case for this.
 *	But again, feel free to look into this if you want to understand what happens
 *	in the back, or want to suggest improvements.
 *
 *	#ShareUrCuriosity&Knowledge
 *
 */


import AssetHandling.Asset;
import Frame.Display;
import States.EState;
import Things.Thing;

public class Main extends Thread {
	
	private static int fps = 0; //Move into run()???
	private final static int TARGETFPS = 60; //change to work with cfg
	
	private static Display d = new Display(); //>> This sets up the window. See the "Display" class for more info
	
	private static EState currState; /* >> This is the EState the Program is in right now, your code should happen inside a
									State. For more info see the abstract class "EState"
							  */
	

	public static void main(String[] args) { // >> This is the main method... do I really need to explain this?
		
		Main main = new Main();						 //>> Creates an Instance of the Main- and AssetLoader-Class for Multi-Threading
		AssetLoader assetLoader = new AssetLoader(); //   For more info, see the "AssetLoader"-Class
		
		assetLoader.start(); //>> Calls the run()-Method of the AssetLoader in a new Thread
		main.start(); //>> Calls the run()-Method of Main in a new Thread
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
			else {
				try {
					Thread.sleep(1); //Appearently this reduces CPU-Space...?
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			if(System.nanoTime()-timer >= 1000000000) {
				timer = System.nanoTime();
				fps = frames;
				frames = 0;
			}
		}
	}
	
	public static void update() {
		currState.update();
	}
	
	public void switchState(State s) {
		//TODO: init and loadingScreen stuff
	}
	
	
	//Getter
	public int getFPS() {
		return fps;
	}

}
