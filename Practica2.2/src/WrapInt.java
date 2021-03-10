
public class WrapInt {
	volatile int value=0;
	volatile int[] in;
	volatile int[] last;
	public WrapInt(int M) {
		this.in = new int[2*M+2];
		this.last = new int[2*M+2];
	}
	
}
