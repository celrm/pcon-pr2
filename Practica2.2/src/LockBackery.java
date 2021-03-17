public class LockBackery implements Lock {

	volatile WrapInt[] turn;

	public LockBackery(int M) {
		this.turn = new WrapInt[2*M+1];
		for(int j = 1; j < turn.length; ++j) {
			turn[j] = new WrapInt();
		}
	}
	

	public void takeLock(int id) {
		turn[id].value = 1;
		int mx = 0;
		for(int j = 1; j < turn.length; ++j) {
			mx = Math.max(mx,turn[j].value);
		}
		turn[id].value = mx+1;

		for(int j = 1; j < turn.length; ++j) {
			if(j!=id) {
				while(turn[j].value!=0 && 
					comparing(turn[id].value,id,turn[j].value,j));
			}
		}
	}
	
	public void releaseLock(int id) {
		turn[id].value=0;
	}
	
	private boolean comparing(int a, int b, int c, int d) {
		return (a>c) || (a==c && b > d);
	}

}
