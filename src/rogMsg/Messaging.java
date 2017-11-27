package rogMsg;

import java.util.List;

public class Messaging
{
	private List<Message> _msgHistory;
	private boolean _isGroup;

	/**
	 * returns a copy of the message history
	 * @return a list of messages
	 */
	public List<Message> getMsgHistory() {
		List<Message> copy = _msgHistory; 
		return copy;
	}

	/**
	 * Sets the msg history 
	 * @param _msgHistory a list of messages, non-null
	 */
	public void setMsgHistory(List<Message> _msgHistory) {
		if (_msgHistory != null)
		{	
			this._msgHistory = _msgHistory;
		}
	}

	/**
	 * returns a copy of the group flag
	 * @return 
	 */
	public boolean isGroup() {
		boolean copy = _isGroup;
		return copy;

	}

	/**
	 * sets the _isGroup flag to true or false
	 * @param isGroup true if the chat is a groupchat, false if the chat is a single class
	 */
	public void setIsGroup(boolean isGroup) {
		this._isGroup = isGroup;
	}

	/**
	 * checks the server for new, unread messages and updates the user list of message history
	 */
	public void refreshMsgs()
	{

	}

	/**
	 * a basic method to send messages.
	 */
	public void sendMsgs()
	{

	}


	/**
	 * send out a notification when messages are received.
	 */
	public void notification()
	{

	}	
}