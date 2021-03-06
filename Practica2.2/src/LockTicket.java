import java.util.concurrent.atomic.AtomicInteger;

public class LockTicket implements Lock {
	
	volatile int[] turn;
	volatile AtomicInteger number;
	volatile int next = 1;
	
	public LockTicket(int M){
		this.turn = new int[2*M+1];
		this.number = new AtomicInteger(1);
	}
	public void takeLock(int id) {
		this.turn[id] = number.getAndAdd(1);
		while(turn[id]!= next);
	}
	
	public void releaseLock(int id) {
		++this.next;
	}

}
