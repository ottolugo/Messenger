package oesia.formacion.messenger.GUI.entities;

import java.time.LocalDateTime;

public class Message {

    private String message;
    private String sender;
    private boolean broadcastedMessage;
    private MessageStatus status;
    private LocalDateTime messageTime;

    /**
     * Constructor for Message
     * 
     * @param message
     *            String of characters message you want to send is made of
     * @param sender
     *            String of the name the person that send the message
     * @param broadcastedMessage
     *            Boolean we you say if its a message for all connected people
     *            or not
     */
    public Message(String message, String sender, boolean broadcastedMessage) {
	this.message = message;
	this.sender = sender;
	this.broadcastedMessage = broadcastedMessage;
	this.status = MessageStatus.SEND;
	this.messageTime = LocalDateTime.now();
    }

    /**
     * Constructor for Message
     * 
     * @param message
     *            String of characters message you want to send is made of
     * @param sender
     *            String of the name the person that send the message
     * @param broadcastedMessage
     *            Boolean we you say if its a message for all connected people
     *            or not
     * @param status
     *            MessageStatus of a message.
     * @param date
     *            LocalDateTime with the creation date of the message
     */
    public Message(String message, String sender, boolean broadcastedMessage, MessageStatus status,
	    LocalDateTime date) {
	this.message = message;
	this.sender = sender;
	this.broadcastedMessage = broadcastedMessage;
	this.status = status;
	this.messageTime = date;
    }

    /**
     * Get the message status
     * 
     * @return MessageStatus
     * 
     */
    public MessageStatus getStatus() {
	return status;
    }

    /**
     * Set a status to the message
     * 
     * @param status
     *            MessageStatus to be set
     */
    public void setStatus(MessageStatus status) {
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
}
