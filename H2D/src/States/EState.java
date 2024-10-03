/*	 _______________
 *	|				|
 *	|  STATE-CLASS  |
 *	|_______________|
 *
 *	DESCRIPTION:
 *	This class is a blueprint for your Game-States.
 *	See a EState as a "section" in your Program.
 *	
 *	Each Section plays his own Role, and this different Things happen in a section.
 *	For example: The Main-Menu could be its own Section. Or a Jump and Run - Section
 *	in your game should be seperated from a Point-and-Click Section.
 *
 *	You can change whatever EState should be run currently by calling the switchState-Function. 
 *
 *	USAGE:
 *	Create a new class (I recommend calling it <name>EState) and let it extend the "EState"-class.
 *	If you use and IDE, you will get a prompt to automatically paste in the init() and update() methods.
 *
 *	If you need something to be setup before the EState, like reading a file or using some sort of randomizer,
 *	I recommend putting it into the init-function.
 *	Anything that is supposed to happen inside the EState should be placed into the update-function.
 *
 *	The Executor-class automatically updates the current EState.
 *
 *	#ShareUrCuriosity&Knowledge
 *
 */

package States;

import Frame.Display;
import Interfaces.Preloadable;

public abstract class EState implements Preloadable {
	
	public static EState menuState = new MenuState();

	public abstract void init();
	
	public abstract void update();
}
