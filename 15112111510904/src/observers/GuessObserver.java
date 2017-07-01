package observers;

public interface GuessObserver {
	
	public void SetObservedControl(GuessObserved c);

	public void SetObservedView(GuessObserved v);
	
	public int[] ProvideCP (int[] p);
	
	public void AddCardCurr(int c0, int c1);
}
