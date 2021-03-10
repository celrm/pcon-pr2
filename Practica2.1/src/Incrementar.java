

// 1
public class Incrementar extends Thread {
    WrapInt n;
    int N;
    Incrementar(WrapInt n,int N) {
    	this.n = n;
        this.N = N;
    }

    public void run() {
        for (int i = 0; i < N; ++i){
        	n.in1=true;
        	n.last=1;
        	while(n.in2 && n.last == 1);
        	
        	++n.value;
        	
        	n.in1 = false;
        }
    }


}
