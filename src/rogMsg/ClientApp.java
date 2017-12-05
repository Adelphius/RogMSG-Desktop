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
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientApp extends Application
{
<<<<<<< HEAD
	private User _currentUser;
=======

	private static User _currentUser;
>>>>>>> c80a37a6b7aab3569f3702983cdb32c0a50352b4
	private static ArrayList<User> _userList;
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
	 * @return boolean, tru if success, false if failed
	 */
	public static boolean loginAttempt(String pass, String email)
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
	
	public static boolean registerAttempt(String username, String email, String pass, String conPass)
	{
		/*
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

<<<<<<< HEAD
	public static void main (String args[]) throws IOException
	{
		launch();
		
//		SocketClient sc = new SocketClient();
//		sc.requestConnection();
=======
	

	public static void main(String[] args) throws IOException
	{
		launch();

		//ROGMsgGui.launch(ROGMsgGui.class); //dont believe this is needed anymore?

		
	}

	public static ObservableList<User> get_userListCpy() {
		// TODO Auto-generated method stub
		return null;
>>>>>>> c80a37a6b7aab3569f3702983cdb32c0a50352b4
	}

}