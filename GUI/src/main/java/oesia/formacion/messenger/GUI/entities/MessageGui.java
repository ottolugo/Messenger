package oesia.formacion.messenger.GUI.entities;

import java.time.LocalDateTime;

import oesia.formacion.messenger.GUI.util.DateUtil;

public class MessageGui {

	private String message;
	private String sender;
	private String receiver;
	private boolean broadcastedMessage;
	private MessageStatusGui status;
	private LocalDateTime messageTime;

	/**
	 * Constructor for Message if message is broadcasted
	 * 
	 * @param message
	 *            String of characters message you want to send is made of
	 * @param sender
	 *            String of the name the person that send the message
	 */
	public MessageGui(String message, String sender) {
		this.message = message;
		this.sender = sender;
		this.receiver = null;
		this.broadcastedMessage = true;
		this.status = MessageStatusGui.NEW;
		this.messageTime = LocalDateTime.now();
	}

	/**
	 * Constructor for Message if message is broadcasted
	 * 
	 * @param message
	 *            String of characters message you want to send is made of
	 * @param sender
	 *            String with the name of the person that send the message
	 * @param receiver
	 *            String with the name of the person that receive the message
	 * @param status
	 *            MessageStatus of a message.
	 * @param date
	 *            LocalDateTime with the creation date of the message
	 */
	public MessageGui(String message, String sender, MessageStatusGui status, LocalDateTime date) {
		this.message = message;
		this.sender = sender;
		this.receiver = null;
		this.broadcastedMessage = true;
		this.status = status;
		this.messageTime = date;
	}

	/**
	 * Constructor for Message if message is addressed to an user
	 * 
	 * @param message
	 *            String of characters message you want to send is made of
	 * @param sender
	 *            String with the name of the person that send the message
	 * @param receiver
	 *            String with the name of the person that receive the message
	 * @param status
	 *            MessageStatus of a message.
	 * @param date
	 *            LocalDateTime with the creation date of the message
	 */
	public MessageGui(String message, String sender, String receiver, MessageStatusGui status, LocalDateTime date) {
		this.message = message;
		this.sender = sender;
		this.receiver = receiver;
		this.broadcastedMessage = false;
		this.status = status;
		this.messageTime = date;
	}

	/**
	 * Constructor for Message if message is addressed to an user
	 * 
	 * @param message
	 *            String of characters message you want to send is made of
	 * @param sender
	 *            String with the name of the person that send the message
	 * @param receiver
	 *            String with the name of the person that receive the message
	 * @param status
	 *            MessageStatus of a message.
	 */
	public MessageGui(String message, String sender, String receiver) {
		this.message = message;
		this.sender = sender;
		this.receiver = receiver;
		this.broadcastedMessage = false;
		this.status = MessageStatusGui.NEW;
		this.messageTime = LocalDateTime.now();
	}

	/**
	 * Get the message status
	 * 
	 * @return MessageStatus
	 * 
	 */
	public MessageStatusGui getStatus() {
		return status;
	}

	/**
	 * Set a status to the message
	 * 
	 * @param status
	 *            MessageStatus to be set
	 */
	public void setStatus(MessageStatusGui status) {
		this.status = status;
	}

	/**
	 * Get the message
	 * 
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set message string to the message
	 * 
	 * @param message
	 *            String to be set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get the sender of the message
	 * 
	 * @return String
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Set the sender of the message
	 * 
	 * @param sender
	 *            String to be set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * Get the receiver of the message
	 * 
	 * @return String
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * Set the receiver of the message
	 * 
	 * @param receiver
	 *            String to be set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * Get if the message is broadcasted or directed
	 * 
	 * @return boolean
	 */
	public boolean isBroadcastedMessage() {
		return broadcastedMessage;
	}

	/**
	 * Set if the message is broadcasted (true) or directed (false)
	 * 
	 * @param broadcastedMessage
	 *            boolean to be set
	 */
	public void setBroadcastedMessage(boolean broadcastedMessage) {
		this.broadcastedMessage = broadcastedMessage;
	}

	/**
	 * Get the time the message was created
	 * 
	 * @return LocalDateTime
	 * 
	 */
	public LocalDateTime getMessageTime() {
		return messageTime;
	}

	/**
	 * Set the moment a message was created
	 * 
	 * @param messageTime
	 *            LocalDateTime to be set
	 */
	public void setMessageTime(LocalDateTime messageTime) {
		this.messageTime = messageTime;
	}

	/**
	 * Returns a string of the sender of the message, the hour the message was
	 * send and the message
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return sender + ": " + DateUtil.format(messageTime) + ": " + message;
	}

}
