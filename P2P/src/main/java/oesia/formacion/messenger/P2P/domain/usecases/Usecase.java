package oesia.formacion.messenger.P2P.domain.usecases;

public interface Usecase<T> {
	/**
	 * Se ocupa de ejecutar lo necesario para el caso de uso
	 * 
	 * @return dependiendo del caso de uso puede devolver algo
	 */
	public T run();

}
