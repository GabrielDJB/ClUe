package observers;
import control.Control;

//
// Observador Singleton
//
public class PalpiteObserver implements GuessObserver {
	private static GuessObserved control, view;
	private static PalpiteObserver instance;

	private PalpiteObserver() {
	}

	public static PalpiteObserver GetPalpiteObserver() {
		if (instance == null)
			instance = new PalpiteObserver();
		return instance;
	}

	public void SetObservedControl(GuessObserved c) {
		control = c;
	}

	public void SetObservedView(GuessObserved v) {
		view = v;
	}
	
	public int[] ProvideCP(int[] p){
		return Control.CounterProof(p);
	}
	
	public void AddCardCurr(int c0, int c1) {
		Control.AddCardCurr(c0, c1);
	}
}
