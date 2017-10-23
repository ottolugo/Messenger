package oesia.formacion.messenger.P2P.domain.configuration;

import java.util.ArrayList;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.KeepAliveMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierReceivedUserList;
import oesia.formacion.messenger.P2P.domain.util.CodeGenerator;

/**
 * This class stores the current KeepAlive code and connected users list and 
 * checks if the ACK received is for the last KeepAlive (storing the user if so)
 * and notifies the userlist if we are updating the keepAlive code
 *  
 * @author EXTamarino
 *
 */
public class KeepAliveConfiguration {
	private static ArrayList<String> users = new ArrayList<String>();;

	/**
	 * This sends the userList to the notifier (if the userLists exists),
	 * sends a KeepAliveMessage and wipes the UserList
	 * @param codeToUpdate
	 */
	public static void newKeepAlive() {
		if (users != null) {
			NotifierReceivedUserList.getInstance().notify(users);
		}
		Code newCode = CodeGenerator.getMyCode();
		SocketConfiguration.getService().sendMessage(new KeepAliveMessage(newCode));
		users.clear();
	}

	/**
	 * This checks if the ACK is for the current KeepAlive code and, if so, 
	 * stores the user in the userlist
	 * @param msg
	 * @return
	 */
	public static void receiveKeepAlive(KeepAliveMessage msg){
		if(!users.contains(msg.getCode().getUser())){
			users.add(msg.getCode().getUser());
		}
	}
}
