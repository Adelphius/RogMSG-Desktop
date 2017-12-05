/*
 * Basic ClientApp class
 * 
 * Written by ty
 */

package rogMsg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientApp extends Application
{
	private User _currentUser;
	private static ArrayList<User> _userList;
	
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
	public static ArrayList<User> getUsrList()
	{
		ArrayList<User> copy = _userList;
		return copy;
	}

	/**
	 * sets the list of users in the group that are logged in
	 * @param user is the list that is going to be saved, cannot be null
	 */
	public void setUsrList(ArrayList<User> users)
	{
		if (users != null)
		{
			_userList = users;
		}
	}
	
	public List<String> getUserNames()
	{
		List<String> names = new ArrayList<>();
		for(User u : _userList)
		{
			names.add(u.getName());
		}
		return names;
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
	
	public static void addUserToGroup(User usr)
	{
		
	}
	
	public static void removeUserFromGroup(User usr)
	{
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreenFXML.fxml"));
		GridPane page = (GridPane) loader.load();
		Stage dialogStage = new Stage();
		dialogStage.setTitle("ROGMsg - Login");
		Scene scene = new Scene(page, 400, 375);
		dialogStage.setScene(scene);
		LoginController login = loader.getController();
		login.setStage(dialogStage);
		dialogStage.show();
	}

	public static void main (String args[]) throws IOException
	{
		launch();
		
//		SocketClient sc = new SocketClient();
//		sc.requestConnection();
	}

}