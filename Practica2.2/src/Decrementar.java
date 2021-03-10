
public class Decrementar extends Thread {
    WrapInt n;
    int N;
    int id;
    Lock l;
    Decrementar(WrapInt n,int N,int id,Lock l) {
    	this.n = n;
        this.N = N;
        this.id = id;
        this.l = l;
    }

    public void run() {
        for (int i = 0; i < N; ++i){
        	l.takeLock(n,id);
        	
        	--n.value;

        	l.releaseLock(n,id);
        }
    }


}
