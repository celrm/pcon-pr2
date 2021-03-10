
public class LockBackery implements Lock {

	public void takeLock(WrapInt n) {
		
	}
	
	public void releaseLock(WrapInt n) {
		
	}
	
	private boolean comparing(int a, int b, int c, int d) {
		return (a>c) || (a==c && b > d);
	}

}
