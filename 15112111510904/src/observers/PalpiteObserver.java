package observers;

//
// Observador Singleton
//

public class PalpiteObserver implements GuessObserver {
	private static GuessObserved control, view;
	private static PalpiteObserver instance;
	
	private PalpiteObserver(){}
	
	public static PalpiteObserver GetPalpiteObserver(){
		if(instance == null)
			instance = new PalpiteObserver();
		return instance;
	}
	
	public void SetObservedControl(GuessObserved c){
		control = c;
	}
	public void SetObservedView(GuessObserved v){
		view = v;
	}
}
