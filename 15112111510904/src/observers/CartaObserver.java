package observers;
import control.Control;
import control.Player;

public class CartaObserver implements ObserverMV {
	
	ObservedMV control, view;
	private static CartaObserver instance;
	
	private CartaObserver(){}
	
	public static CartaObserver GetInstance(){
		if(instance == null)
			instance = new CartaObserver();
		return instance;
	}
	
	public void SetObservedControl(ObservedMV c){
		control = c;
	}
	
	public void SetObservedView(ObservedMV v){
		view = v;
	}
	
	public Player GetCurrP(){
		return Control.GetCurrP();
	}
}
