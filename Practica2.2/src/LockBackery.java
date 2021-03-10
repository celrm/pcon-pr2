
public class LockBackery implements Lock {
	volatile int[] turn;
	public LockBackery(int M) {
		this.turn = new int[2*M+1];
	}

	public void takeLock(int id) {
		for(int j = 1; j < turn.length; ++j) {
			turn[id] = Math.max(turn[j],turn[id]);
			turn = turn;
		}
		turn[id]++;
		turn = turn;

		for(int j = 1; j < turn.length; ++j) {
			if(j!=id) {
				while(turn[j]!=0 && 
					comparing(turn[id],id,turn[j],j));
			}
		}
	}
	
	public void releaseLock(int id) {
		turn[id]=0;
		turn = turn;
	}
	
	private boolean comparing(int a, int b, int c, int d) {
		return (a>c) || (a==c && b > d);
	}

}
