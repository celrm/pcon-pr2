import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

public class LockBackery implements Lock {

	volatile AtomicInteger[] turn;
	volatile boolean[] max;
	
	public LockBackery(int M) {
		this.turn = new AtomicInteger[2*M+1];
		this.max = new boolean[2*M+1];
		for(int j = 1; j < turn.length; ++j) {
			turn[j] = new AtomicInteger(0);
			max[j] = false;
		}
	}
	

	public void takeLock(int id) {
		max[id]=true;
		int mx = 0;
		for(int j = 1; j < turn.length; ++j) {
			mx = Math.max(mx,turn[j].get());
		}
		turn[id].set(mx+1);
		max[id]=false;

		for(int j = 1; j < turn.length; ++j) {
			if(j!=id) {
				while(max[j]);
				while(turn[j].get()!=0 && 
					comparing(turn[id].get(),id,turn[j].get(),j));
			}
		}
	}
	
	public void releaseLock(int id) {
		turn[id].set(0);
	}
	
	private boolean comparing(int a, int b, int c, int d) {
		return (a>c) || (a==c && b > d);
	}

}
