import AssetHandling.Asset;

public class AssetLoader extends Thread{
	
	@Override
	public void run() {
		Asset.init();
	}

}
