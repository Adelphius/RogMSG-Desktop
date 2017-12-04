/*
 * Basic ClientApp class
 * 
 * Written by ty
 */

package rogMsg;

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
	
	public static void main(String[] args)
	{
		launch();
	}
}