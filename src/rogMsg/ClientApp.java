/*
 * Basic ClientApp class
 * 
 * Written by ty
 */


package rogMsg;

import java.util.ArrayList;

public class ClientApp {

	/*
	 * This is an example comment
	 * for the github tutorial.
	 */
	
	private User _currentUser;
	private ArrayList<User> _userList;

	//We need to add javadoc to everything at some point. commiting this now to get the skeletons out
	
	public User getCurrentUsr()
	{
		User copy = _currentUser;
		return copy;
	}

	public void setCurrentUsr(User user)
	{
		_currentUser = user;
	}

	public ArrayList<User> getUsrList()
	{
		ArrayList<User> copy = _userList;
		return copy;
	}

	public void setUsrList(ArrayList<User> user)
	{
		_userList = user;
	}
	
	public void loginAttempt(String pass, String email)
	{
		
	}


	public ClientApp() {
		// TODO Auto-generated constructor stub	
	}
	
	
}