
public class main {
	static WrapInt n;
	public static void main(String[] args) {
		int M = 1;
		int N = 20000;
		n = new WrapInt();
		n.value = 0;
		Decrementar[] dt = new Decrementar[M];
		Incrementar[] it = new Incrementar[M];
		for (int i = 0; i < M; ++i){
			it[i] = new Incrementar(n,N);
			dt[i] = new Decrementar(n,N);
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
