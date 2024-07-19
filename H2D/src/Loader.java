import AssetHandling.Asset;
import Interfaces.Preloadable;

public class Loader extends Thread{ //Genral Loader Thread???
	
	private boolean isLoading;
	private Preloadable p;
	
	public Loader(Preloadable p) {
		this.p = p;
		isLoading = true;
	}
	
	@Override
	public void run() {
		p.init();
		isLoading = false;
	}
	
	//Getter
	public boolean isLoading() {
		return isLoading;
	}

}
