import java.util.concurrent.atomic.AtomicInteger;

public class LockRompeEmpate implements Lock {
	volatile AtomicInteger[] in;
	volatile AtomicInteger[] last;
	public LockRompeEmpate(int M) {
		this.in = new AtomicInteger[2*M+1];
		this.last = new AtomicInteger[2*M+1];
		for(int j = 1; j < in.length; ++j) {
			in[j] = new AtomicInteger(0);
			last[j] = new AtomicInteger(0);
		}
	}

	public void takeLock(int id) {
		for (int j = 1; j < in.length; ++j) {
			in[id].set(j);
			last[j].set(id);
			for(int  k=1; k < in.length; ++k) {
				while(in[k].get()>=in[id].get()
						&& last[j].get()==id);
			}
		}
	}
	
	public void releaseLock(int id) {
		
	}

}
