/*	 _______________
 *	|			 	|
 *	| DISPLAY-CLASS |
 *	|_______________|
 *
 *	DESCRIPTION:
 *	This class creates an accessible window in the form of an JFrame. If you don't
 *	know what that is don't worry. It is basically a build-in class from Java that
 *	allows you to create a window.
 *
 *	So whatever will be shown on screen will run through this class. It has a Queue
 *	responsible for everything that needs to be rendered onto the screen.
 *
 *	Usage:
 *	If you want something to be shown on the Display, you have to add it to the
 *	renderQueue. It is a static Array-List, meaning you just need to call it by:
 *	
 *	Display.renderQueue.add(Thing t); --> to add something to be rendered
 *
 *	Display.renderQueue.remove(Thing t); --> to delete something to be rendered
 *
 *	-> see the "Thing"-class for more information
 *
 *	
 *	#ShareUrCuriosity&Knowledge
 *
 */

package Frame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;

import Things.Thing;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	public static ArrayList<Thing> renderQueue;
	
	public Display() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame();
		frame.setSize(d);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setSize(d);
		canvas.setBackground(Color.white);
		
		frame.add(canvas);
		canvas.createBufferStrategy(3);
		frame.pack();
		
		renderQueue = new ArrayList<>();
	}
	
	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
		
		//Rendering-Queue
		for(Thing t : renderQueue) {
			g.drawImage(t.getImage(), t.getX(), t.getY(), t.getWidth(), t.getHeight(), null);
		}
		
		bs.show();
		g.dispose();
	}
	
	//GETTERS & SETTERS
	public JFrame getFrame() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
}
