package rogMsg;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * Notice this class implements Serializable. 
	 * This allows use to serialize an object into 
	 * a file to be sent over the socket.
	 * 
	 * The serialVersionUID is an ID that Serializable will use to deserialize the object.
	 * We may want to change the UID from 1 to something else. I am unsure if it matters. 
	 */
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _email;
	private int _idNo;
	
	//the following are getters/setter for the variables above
	public String getName() {
		String copyOfName = this._name;
		return copyOfName;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	public String getEmail() {
		String copyOfEmail = this._email;
		return copyOfEmail;
	}

	public void setEmail(String _email) {
		this._email = _email;
	}

	public int getIDNo() {
		int IDCopy = this._idNo;
		return IDCopy;
	}

	public void setIDNo(int _IDno) {
		this._idNo = _IDno;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
}
