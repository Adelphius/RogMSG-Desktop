/*
 * Basic ClientApp class
 * 
 * Written by ty
 */

package rogMsg;

import java.io.IOException;
import java.util.ArrayList;

public class ClientApp
{

	private User _currentUser;
	private ArrayList<User> _userList;
	private static ArrayList<User> _userListCpy;
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
	
	public static ArrayList<User> get_userListCpy()
	{
		return _userListCpy;
	}

	public static void set_userListCpy(ArrayList<User> _userListCpy)
	{
		ClientApp._userListCpy = _userListCpy;
	}
  
	/**
	 * Takes the login details and attempts to authenticate it with the server
	 * @param pass, the password that you are using for the login,  non null
	 * @param email, the email that you are using for the login
	 */
	public static boolean loginAttempt(String pass, String email)
	{
		if (pass != null && email != null)
		{

		}
		return true;
	}
	
	public static boolean registerAttempt(String username, String email, String pass, String conPass)
	{
		/**
		 * some server interaction probably goes here too
		 */
		return false;
	}
	
	/**
	 * adds a user to the group and tells UI to update itself.
	 * @param user the user to be added.
	 */
	public static void addUserToGroup(User user)
	{
		
	}
	
	public static void addLsttoLists(Lst list)
	{

	}

	public ClientApp()
	{
		set_userListCpy(getUsrList());
	}

	
	public static void main (String args[]) throws IOException
  {
		ROGMsgGui.launch(ROGMsgGui.class);
		
		SocketClient sc = new SocketClient();
		sc.requestConnection();
	}

}