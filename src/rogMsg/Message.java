package rogMsg;

import java.io.Serializable;

public class Message implements Serializable
{
	/**
	 * Notice this class implements Serializable. 
	 * This allows use to serialize an object into 
	 * a file to be sent over the socket.
	 * 
	 * The serialVersionUID is an ID that Serializable will use to deserialize the object.
	 * We may want to change the UID from 2 to something else. I am unsure if it matters. 
	 */
	private static final long serialVersionUID = 2L;

	private String _stringMsg;
	private String _imageLoc;
	private String _audioLoc;


	//the following are getters/setter for the variables above
	/**
	 * 
	 * @return
	 */
	public String getStringLoc()
	{
		String copy = _stringMsg;
		return copy;
	}

	/**
	 * 
	 * @param stringLoc
	 */
	public void setStringLoc(String stringLoc)
	{
		this._stringMsg = stringLoc;
	}

	/**
	 * 
	 * @return
	 */
	public String getImageLoc()
	{
		String copy = _imageLoc;
		return copy;
	}

	/**
	 * 
	 * @param imageLoc
	 */
	public void setImageLoc(String imageLoc)
	{
		this._imageLoc = imageLoc;
	}

	/**
	 * 
	 * @return
	 */
	public String getAudioLoc()
	{
		String copy = _audioLoc;
		return copy;
	}

	/**
	 * 
	 * @param audioLoc
	 */
	public void setAudioLoc(String audioLoc)
	{
		this._audioLoc = audioLoc;
	}

	/**
	 * 
	 */
	public Message()
	{
		// TODO Auto-generated constructor stub
	}
}
