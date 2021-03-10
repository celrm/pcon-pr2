import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

public class LockBackery implements Lock {
	
	volatile AtomicInteger[] turn;
    private IntBinaryOperator max = (x, y) -> (Math.max(x,y));
	
	public LockBackery(int M) {
		this.turn = new AtomicInteger[2*M+1];
		for(int j = 1; j < turn.length; ++j) {
			turn[j] = new AtomicInteger(0);
		}
	}
	

	public void takeLock(int id) {
		for(int j = 1; j < turn.length; ++j) {
			turn[id].accumulateAndGet(turn[j].get(), max);
		}
		turn[id].getAndAdd(1);

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
