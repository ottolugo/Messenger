package oesia.formacion.messenger.P2P.domain.managers;

/**
 * 
 * @author ramunoz
 *
 * @param <T> Observer a usar
 * @param <Y> Objeto que observa
 */
public interface ObserNotifier<T, Y> {
	public void add(T value);

	public void drop(T value);

	public void notifyAll(Y value);
}
