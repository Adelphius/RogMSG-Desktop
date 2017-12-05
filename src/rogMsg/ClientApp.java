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

	private static User _currentUser;
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
	public ArrayList<User> getUsrList()
	{
		ArrayList<User> copy = _userList;
		return copy;
	}
	
	public static List<String> getUserNames()
	{
		List<String> names = new ArrayList<>();
		for(User u : _userList)
		{
			names.add(u.getName());
		}
		return names;
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
	public static boolean loginAttempt(String pass, String email)
	{
		if (pass != null && email != null)
		{
				
			SocketClient authConnetion = new SocketClient("192.168.0.73", 1023);
			
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
	
	/**
	 * adds a user to the group and tells UI to update itself.
	 * 		-> should pass a string back to the addUser controller to let user know if it passed or failed <-
	 * @param user - the user to be added.
	 */
	public static void addUserToGroup(User user)
	{
		
	}
	
	/**
	 * adds a Lst to the Lists and tells the UI to update itself.
	 * 		-> should pass a string back to the addList controller to let user know if it passed or failed <-
	 * @param list - the list to be added.
	 */
	public static void addLsttoLists(Lst list)
	{

	}
	
	/**
	 * adds a Poll to the Polls and tells the UI to update itself.
	 * 		-> should pass a string back to the addPoll controller to let user know if it passed or failed <-
	 * @param poll - the poll to be added
	 */
	public static void addPollstoPolls(Poll poll)
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

	

	public static void main(String[] args) throws IOException
	{
		launch();

		//ROGMsgGui.launch(ROGMsgGui.class); //dont believe this is needed anymore?

		
	}

	public static ObservableList<User> get_userListCpy() {
		// TODO Auto-generated method stub
		return null;
	}

}