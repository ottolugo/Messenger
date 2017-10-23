package oesia.formacion.messenger.P2P.domain.configuration;

import java.util.ArrayList;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierReceivedUserList;

/**
 * This class stores the current KeepAlive code and connected users list and 
 * checks if the ACK received is for the last KeepAlive (storing the user if so)
 * and notifies the userlist if we are updating the keepAlive code
 *  
 * @author EXTamarino
 *
 */
public class KeepAliveConfiguration {
	private static Code code;
	private static ArrayList<String> users;

	/**
	 * This sends the userList to the notifier (if the userLists exists),
	 * updates the current keepAlive code and wipes the UserList
	 * @param codeToUpdate
	 */
	public static void updateKeepAliveCode(Code codeToUpdate) {
		if (users != null) {
			NotifierReceivedUserList.getInstance().notify(users);
		}
		else{
			users = new ArrayList<String>();
		}
		code = codeToUpdate;
		users.clear();
	}

	/**
	 * This checks if the ACK is for the current KeepAlive code and, if so, 
	 * stores the user in the userlist
	 * @param msg
	 * @return
	 */
	public static boolean checkACK(ACKMessage msg){
		boolean checks = msg.getCodeResponse().equals(code);
		if(checks){
			users.add(msg.getCodeResponse().getUser());
		}
		return checks;
	}
}
