package observers;

public class CartaObserver implements CardObserver {
	
	CardObserved control, view;
	private static CartaObserver instance;
	
	private CartaObserver(){}
	
	public static CartaObserver GetInstance(){
		if(instance == null)
			instance = new CartaObserver();
		return instance;
	}
	
	public void SetObservedControl(CardObserved c){
		control = c;
	}
	
	public void SetObservedView(CardObserved v){
		view = v;
	}
}
