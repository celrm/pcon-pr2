
public class main {
	static WrapInt n;
	public static void main(String[] args) {
		int M = 5;
		int N = 20;
		n = new WrapInt();
		n.value = 0;
		Lock l = new LockRompeEmpate(M);
		Decrementar[] dt = new Decrementar[M];
		Incrementar[] it = new Incrementar[M];
		for (int i = 0; i < M; ++i){
			it[i] = new Incrementar(n,N,2*(i+1),l);
			dt[i] = new Decrementar(n,N,2*(i+1)-1,l);
			it[i].start();
			dt[i].start();
		}
		for (int i = 0; i < M; ++i){
			try {
				dt[i].join();
				it[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(n.value);
	}
}
