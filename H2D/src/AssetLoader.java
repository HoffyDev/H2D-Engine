import AssetHandling.Asset;

public class AssetLoader extends Thread{ //Genral Loader Thread???

	private boolean isLoading;
	private Preloadable p;

	public AssetLoader() {
		isLoading = true;
	}

	

	@Override
	public void run() {
		Assets.init();
		isLoading = false;
	}

	

	//Getter
	public boolean isLoading() {
		return isLoading;
	}

}
