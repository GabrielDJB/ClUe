package observers;

import control.Control;

//
// Observador Singleton
//
public class PalpiteObserver implements ObserverMV {
	private static ObservedMV control, view;
	private static PalpiteObserver instance;

	private PalpiteObserver() {}

	public static PalpiteObserver GetPalpiteObserver() {
		if (instance == null)
			instance = new PalpiteObserver();
		return instance;
	}

	public void SetObservedControl(ObservedMV c) {
		control = c;
	}

	public void SetObservedView(ObservedMV v) {
		view = v;
	}

	public int[] ProvideCP(int[] p) {
		return Control.CounterProof(p);
	}

	public void AddCardCurr(int c0, int c1) {
		Control.AddCardCurr(c0, c1);
	}
}
