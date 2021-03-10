
public class LockBackery implements Lock {
	volatile int[] turn;
	public LockBackery(int M) {
		this.turn = new int[2*M+2];
	}

	public void takeLock(WrapInt n,int id) {
		for(int j = 1; j < turn.length; ++j) {
			
		}
	}
	
	public void releaseLock(WrapInt n,int id) {
		
	}
	
	private boolean comparing(int a, int b, int c, int d) {
		return (a>c) || (a==c && b > d);
	}

}
