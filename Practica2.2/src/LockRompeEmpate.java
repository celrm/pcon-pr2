public class LockRompeEmpate implements Lock {
	volatile WrapInt[] in;
	volatile WrapInt[] last;
	public LockRompeEmpate(int M) {
		this.in = new WrapInt[2*M+1];
		this.last = new WrapInt[2*M+1];
		for(int j = 1; j < in.length; ++j) {
			in[j] = new WrapInt();
			last[j] = new WrapInt();
		}
	}

	public void takeLock(int id) {
		for (int j = 1; j < in.length; ++j) {
			in[id].value = j;
			last[j].value = id;
			for(int  k=1; k < in.length; ++k) {
				if(k!=id) {
					while(in[k].value>=in[id].value
							&& last[j].value==id);
				}
			}
		}
	}
	
	public void releaseLock(int id) {
		in[id].value=0;
	}

}
