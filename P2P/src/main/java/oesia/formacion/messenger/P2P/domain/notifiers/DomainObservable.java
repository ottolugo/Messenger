package oesia.formacion.messenger.P2P.domain.notifiers;

/**
 * Interfaz a la que se le entrega lo que tiene que notificar y el tipo de observables que acepta
 * 
 * @author ramunoz
 *
 * @param <T> Tipo de objeto a entregar
 * @param <O> interfaz observer que acepta
 */
public interface DomainObservable<T, O> {

	/**
	 * Notifica a todos los observadores
	 * 
	 * @param notification objeto que se notifica
	 */
	public void notify(T notification);

	/**
	 * Observador a agregar
	 * 
	 * @param observer observador a agregar
	 */
	public void addObserver(O observer);

	/**
	 * observador a eliminar
	 * 
	 * @param observer observador a eliminar
	 */
	public void dropObserver(O observer);

}
