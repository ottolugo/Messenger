package oesia.formacion.messenger.P2P.domain.notifiers;

/**
 * Interfaz a la que se le entrega lo que tiene que notificar y el tipo de observables que acepta
 * 
 * @author ramunoz
 *
 * @param <T> Tipo de objeto a entregar
 * @param <O> interfaz observer que acepta
 */
public interface DomainNotifier<T, O> {

	/**
	 * Notifies all observers
	 * 
	 * @param notification (object to notify)
	 */
	public void notify(T notification);

	/**
	 * Adds an observer to the list
	 * 
	 * @param observer
	 */
	public void addObserver(O observer);

	/**
	 * eliminates an observer from the list
	 * 
	 * @param observer
	 */
	public void dropObserver(O observer);

}
