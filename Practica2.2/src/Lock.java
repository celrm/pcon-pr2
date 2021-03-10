
public interface Lock {
	void takeLock(WrapInt n,int id);
	void releaseLock(WrapInt n,int id);
}
