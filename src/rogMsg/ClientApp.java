/*
 * Basic ClientApp class
 * 
 * Written by ty
 */

package rogMsg;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ClientApp
{

	private User _currentUser;
	private ArrayList<User> _userList;

	/**
	 * Returns a copy of the user.
	 * @return a user object. A copy so it does not give away the location it's stored in memory.
	 */
	public User getCurrentUsr()
	{
		User copy = _currentUser;
		return copy;
	}

	/**
	 * Sets the current user
	 * @param user is the desired new current user
	 */
	public void setCurrentUsr(User user)
	{
		if (user != null)
		{
			_currentUser = user;
		}
	}

	/**
	 * Gets the list of users that are logged in the user's group
	 * @return a list of users, non null, can be empty
	 */
	public ArrayList<User> getUsrList()
	{
		ArrayList<User> copy = _userList;
		return copy;
	}

	/**
	 * sets the list of users in the group that are logged in
	 * @param user is the list that is going to be saved, cannot be null
	 */
	public void setUsrList(ArrayList<User> user)
	{
		if (user != null)
		{
			_userList = user;
		}
	}

	/**
	 * Takes the login details and attempts to authenticate it with the server
	 * @param pass, the password that you are using for the login,  non null
	 * @param email, the email that you are using for the login
	 * @return boolean, tru if success, false if failed
	 */
	public boolean loginAttempt(String pass, String email)
	{
		if (pass != null && email != null)
		{
				
			SocketClient authConnetion = new SocketClient("localhost", 1023);
			
			try {
				User attempt = authConnetion.auth(email, pass);
				
				if(attempt!=null)
				{
					_currentUser = attempt;
					return true;
				}
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return false;
		}
		return false;
	}

	
	public static void main (String args[]) throws IOException
	{
		ROGMsgGui.launch(ROGMsgGui.class);
		
	}
	
}