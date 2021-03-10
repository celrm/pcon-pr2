
public class LockRompeEmpate implements Lock {
	volatile int[] in;
	volatile int[] last;
	public LockRompeEmpate(int M) {
		this.in = new int[2*M+2];
		this.last = new int[2*M+2];
	}

	public void takeLock(WrapInt n) {
		
	}
	
	public void releaseLock(WrapInt n) {
		
	}

}
