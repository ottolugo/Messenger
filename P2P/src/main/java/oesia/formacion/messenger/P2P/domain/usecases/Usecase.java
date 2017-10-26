package oesia.formacion.messenger.P2P.domain.usecases;

/**
 * 
 * @author ramunoz
 *
 * @param <T>
 */
public interface Usecase {
	/**
	 * Se ocupa de ejecutar lo necesario para el caso de uso
	 * 
	 * @return dependiendo del caso de uso puede devolver algo
	 */
	public void run();

}
