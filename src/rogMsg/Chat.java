package rogMsg;

import rogShared.Message;

public class Chat extends Messaging
{
	
	/**
	 * changes functionality of sndMsg to allow for sending to an individual recipient
	 * @param userid the current users id, must be >= 1
	 * @param recipid an int of the recipient id, must be >= 1
	 * @param msg the message that is being sent to the individual, non-null, length >= 1
	 */
	public void sndMsg(int userid, int recipid, Message msg)
	{
		if (userid >=1 && recipid >=1 && msg.getStringMsg().length() > 0 && msg != null)
		{
			
		}
	}
}
