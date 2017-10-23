package oesia.formacion.messenger.GUI.entities;

public enum MessageStatusGui {
	SENT("#F0EA7D"), ARRIVED("#ABEBC6"), CANCELED("#F98282"), NEW("#F0B47D");

	private final String color;

	private MessageStatusGui(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

}
