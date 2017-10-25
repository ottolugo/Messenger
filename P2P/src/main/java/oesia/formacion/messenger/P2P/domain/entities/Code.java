package oesia.formacion.messenger.P2P.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Code implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7556911829874666039L;
    private String user;
    private LocalDateTime date;

    public Code(String user, LocalDateTime date) {
	super();
	this.user = user;
	this.date = date;
    }

    public String getUser() {
	return user;
    }

    public void setUser(String user) {
	this.user = user;
    }

    public LocalDateTime getDate() {
	return date;
    }

    public void setDate(LocalDateTime date) {
	this.date = date;
    }

    @Override
    public String toString() {
	return "Code [user=" + user + ", date=" + date + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Code other = (Code) obj;
	if (date == null) {
	    if (other.date != null)
		return false;
	} else if (!date.equals(other.date))
	    return false;
	if (user == null) {
	    if (other.user != null)
		return false;
	} else if (!user.equals(other.user))
	    return false;
	return true;
    }

}
