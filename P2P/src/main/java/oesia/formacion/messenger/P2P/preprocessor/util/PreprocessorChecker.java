package oesia.formacion.messenger.P2P.preprocessor.util;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.GuidedMessage;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.util.DateUtil;

public class PreprocessorChecker {
	private static String whoami = LocalConfiguration.getWhoami();
	
	/**
	 * Checks if the message should pass the preprocessor
	 * 
	 * @param msg
	 * @return
	 */
	public static boolean check(Message msg){
		boolean res = true;
		//If message comes from me, checks false
		if(msg.getCode().getUser().equals(whoami)){
			res = false;
		}
		//Next check only for non keepalives
		else if(!msg.getType().equals(MessageType.KEEPALIVE)){
			//If message is expired, checks false
			if(!DateUtil.isDateValid(msg.getCode().getDate())){
				res = false;
			}
			//Next check only for non broadcasts
			else if(!msg.getType().equals(MessageType.BROADCAST)){
				//If message not destined to me, checks false
				if(!checkDestination(msg).equals(whoami)){
					res = false;
				}
			}
		}
		return res;
	}
	
	/**
	 * Returns the user the message is destined to or null if no specific destiny
	 * 
	 * @param msg
	 * @return
	 */
	public static String checkDestination(Message msg){
		String res = null;
		if(msg.getType().equals(MessageType.ACK)){
			res = ((ACKMessage)msg).getCodeResponse().getUser();
		}
		if(msg.getType().equals(MessageType.GUIDED)){
			res = ((GuidedMessage)msg).getUserDestination();
		}
		return res;
	}
}
