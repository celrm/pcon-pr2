import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

public class LockBackery implements Lock {

	volatile AtomicInteger[] turn;

	public LockBackery(int M) {
		this.turn = new AtomicInteger[2*M+1];
		for(int j = 1; j < turn.length; ++j) {
			turn[j] = new AtomicInteger(0);
		}
	}
	

	public void takeLock(int id) {
		turn[id].set(1);
		int mx = 0;
		for(int j = 1; j < turn.length; ++j) {
			mx = Math.max(mx,turn[j].get());
		}
		turn[id].set(mx+1);

		for(int j = 1; j < turn.length; ++j) {
			if(j!=id) {
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
