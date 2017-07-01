package observers;

public class AcusaObserver implements AcuseObserver {
	AcuseObserved control, view;
	private static AcusaObserver instance;

	private AcusaObserver() {
	}

	public static AcusaObserver GetInstance() {
		if (instance == null)
			instance = new AcusaObserver();
		return instance;
	}

	public void SetObservedControl(AcuseObserved c) {
		control = c;
	}

	public void SetObservedView(AcuseObserved v) {
		view = v;
	}
}
