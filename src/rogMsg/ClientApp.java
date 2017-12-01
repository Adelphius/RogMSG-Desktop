/*
 * Basic ClientApp class
 * 
 * Written by ty
 */

package rogMsg;

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
	 * Returns a 
	 * @param user 
	 */
	public void setCurrentUsr(User user)
	{
		_currentUser = user;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<User> getUsrList()
	{
		ArrayList<User> copy = _userList;
		return copy;
	}

	/**
	 * 
	 * @param user
	 */
	public void setUsrList(ArrayList<User> user)
	{
		_userList = user;
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
	 * 
	 * @param pass
	 * @param email
	 */
	public static boolean loginAttempt(String pass, String email)
	{
		/**
		 * some interaction with the server has to go here?
		 */
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
	
	public static void main(String[] args)
	{
		ROGMsgGui.launch(ROGMsgGui.class);
	}
}