package States;

import AssetHandling.Assets;
import Things.Thing;

public class StartupState extends EState{

	@Override
	public void init() {
		Assets.initLoadingScreen();
		new Thing(Assets.loadTest, 0, 0, 100, 100);
		Assets.init();
	}

	@Override
	public void update() {
		
		
	}

}
