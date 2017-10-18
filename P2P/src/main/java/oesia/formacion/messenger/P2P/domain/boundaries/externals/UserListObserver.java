package oesia.formacion.messenger.P2P.domain.boundaries.externals;

import java.util.List;

public interface UserListObserver {

	/**
	 * Crea un observador para cuando el domain recoge un nuevo listado de usuarios
	 * 
	 * @param connectedUsers Usuarios que segun el dominio estan conectados
	 */
	public void notify(List<String> connectedUsers);

}
