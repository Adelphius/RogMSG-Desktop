package rogMsg;

import java.io.Serializable;

public class User implements Serializable
{
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

	/**
	 * which returns the name of the user object
	 * @return a name, a string, non-null unless object is null
	 */
	public String getName()
	{
		String copyOfName = this._name;
		return copyOfName;
	}

	/**
	 * sets the name of the user object
	 * @param _name, must be null, must have length > 0
	 */
	public void setName(String _name)
	{
		this._name = _name;
	}

	/**
	 * gets a string of the email
	 * @return the email for the user object, can be null
	 */
	public String getEmail()
	{
		String copyOfEmail = this._email;
		return copyOfEmail;
	}

	/**
	 * sets an email for the user object
	 * @param _email, non-null
	 */
	public void setEmail(String _email)
	{
		this._email = _email;
	}

	/**
	 * gets the id number in the form of an int
	 * @return the id number, must be int, must be > 0
	 */
	public int getIDNo()
	{
		int IDCopy = this._idNo;
		return IDCopy;
	}

	/**
	 * sets the id number for the user object
	 * @param _IDno, must be int, must be >0
	 */
	public void setIDNo(int _IDno)
	{
		this._idNo = _IDno;
	}

	/**
	 * 
	 */
	public User()
	{
		// TODO Auto-generated constructor stub
	}
}