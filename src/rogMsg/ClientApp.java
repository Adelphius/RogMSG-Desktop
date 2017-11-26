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

	/**
	 * 
	 * @param pass
	 * @param email
	 */
	public void loginAttempt(String pass, String email)
	{

	}

	public ClientApp()
	{
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args)
	{
		ROGMsgGui.launch(ROGMsgGui.class);
	}
  
}