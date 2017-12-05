package rogMsg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import rogShared.User;

public class GUIController
{
	@FXML private GridPane newUserForm;
	@FXML private Text actionTarget;
	@FXML private Text groupName;
	@FXML private ListView<User> userList;
	@FXML private ListView<Lst> lists;
	@FXML private ListView<Poll> polls;
	@FXML private TabPane announcementsPane;
	@FXML private ScrollPane announcements;
	@FXML private TabPane extras;
	@FXML private Tab listsTab, pollsTab, announcementsTab;
	@FXML private Button submitButton, registerButton, submitRegisterButton, cancelButton, addUserButton, logoutButton, submitMessageButton, submitAddUserButton, newListButton, createNewListButton, addNewListItemButton, newPollButton, addNewPollOptionButton, createNewPollButton;
	@FXML private TextField userName, email, messageField, field0;
	@FXML private ArrayList<TextField> listOptions, pollOptions;
	@FXML private PasswordField passwordField, confirmPassField;
	@FXML private GridPane innerGrid;
	@FXML private DatePicker expDate;
	private int rowCount;
	
	public GUIController()
	{
		rowCount = 0;
		listOptions = new ArrayList<TextField>();
		pollOptions = new ArrayList<TextField>();
		initUserList();
	}
	
	@FXML protected void handleButton(ActionEvent e) throws IOException 
	{
		Parent p;
		Scene s;
		Stage ps;
		Label label = new Label("");
		TextField field = new TextField();
		
		if(e.getSource().equals(submitButton)) 									//pretty much done
		{
			String em = email.getText();
			String pw = passwordField.getText();
			if(ClientApp.loginAttempt(pw, em))
			{
				p = FXMLLoader.load(getClass().getResource("ChatWindowFXML.fxml"));
				s = new Scene(p, 800, 600);
				ps = (Stage)submitButton.getScene().getWindow();
				ps.setTitle("ROG-Msg - Group Name");
				ps.setScene(s);
			}
			else
			{
				actionTarget.setText("User name or password incorrect. Try again.");
			}
		}
		else if(e.getSource().equals(registerButton)) 							//done. just changes windows.
		{
//			actionTarget.setText("switch to register screen now");
			p = FXMLLoader.load(getClass().getResource("RegisterScreenFXML.fxml"));
			s = new Scene(p, 400, 375);
			ps = (Stage)registerButton.getScene().getWindow();
			ps.setTitle("ROGMsg - Register");
			ps.setScene(s);
		}
		else if(e.getSource().equals(submitRegisterButton)) 					//pretty much done.
		{
			String un = userName.getText();
			String em = email.getText();
			String pw = passwordField.getText();
			String cp = confirmPassField.getText();
			if(ClientApp.registerAttempt(un, em, pw, cp))
			{
				actionTarget.setText("Registration successful. Press cancel to log in.");
			}
			else
			{
				actionTarget.setText("Registration failed. Try again.");
			}
		}
		else if(e.getSource().equals(cancelButton)) 							//done
		{
			p = FXMLLoader.load(getClass().getResource("LoginScreenFXML.fxml"));
			s = new Scene(p, 400, 375);
			ps = (Stage)cancelButton.getScene().getWindow();
			ps.setTitle("ROGMsg - Login");
			ps.setScene(s);
		}
		else if(e.getSource().equals(addUserButton))							//done. opens window.
		{
//			actionTarget.setText("open pop up now");
			p = FXMLLoader.load(getClass().getResource("NewUserFormFXML.fxml"));
			s = new Scene(p, 300, 200);
			ps = new Stage();
			ps.setTitle("ROGMsg - Add user to group");
			ps.setScene(s);
			ps.show();
		}
		else if(e.getSource().equals(submitAddUserButton))						//done.
		{
			String usenm = userName.getText();
			User user = new User();
			user.setName(usenm);
			ClientApp.addUserToGroup(user);
			initUserList();
			actionTarget.setText("Added user " + usenm + " to group.");
		}
		else if(e.getSource().equals(newListButton))							//done. opens window.
		{
			p = FXMLLoader.load(getClass().getResource("NewListFormFXML.fxml"));
			s = new Scene(p, 300, 200);
			ps = new Stage();
			ps.setTitle("ROGMsg - Create a new list");
			ps.setOnCloseRequest(new EventHandler<WindowEvent>()
			{
				public void handle(WindowEvent w)
				{
					field0 = null;
					listOptions.clear();
					rowCount=0;
		        }
			});
			ps.setScene(s);
			ps.show();
		}
		else if(e.getSource().equals(addNewListItemButton))						//done. adds a list item.
		{
			rowCount++;
			label.setText("Item " + rowCount + ":");
			innerGrid.add(label, 0, rowCount);
			innerGrid.add(field, 1, rowCount);
			listOptions.add(field);
		}
		else if(e.getSource().equals(createNewListButton))						//done. I think this should work.
		{
			ArrayList<String> options = new ArrayList<String>();
			for(TextField t : listOptions)
			{
				options.add(t.getText());
			}
			Lists.createLst(field0.getText(), options);
			listOptions.clear();
			field0.clear();
			rowCount=0;
		}
		else if(e.getSource().equals(newPollButton))
		{
			p = FXMLLoader.load(getClass().getResource("NewPollFormFXML.fxml"));
			s = new Scene(p, 300, 200);
			ps = new Stage();
			ps.setTitle("ROGMsg - Create a new poll");
			ps.setOnCloseRequest(new EventHandler<WindowEvent>()
			{
				public void handle(WindowEvent w)
				{
					field0 = null;
					pollOptions.clear();
					rowCount=0;
		        }
			});
			ps.setScene(s);
			ps.show();
		}
		else if(e.getSource().equals(addNewPollOptionButton))
		{
			if(rowCount == 0)
			{
				rowCount=1;
			}
			rowCount++;
			label.setText("Option " + (rowCount-1) + ":");
			innerGrid.add(label, 0, rowCount);
			innerGrid.add(field, 1, rowCount);
			listOptions.add(field);
		}
		else if(e.getSource().equals(createNewPollButton))
		{
			Map<String, Integer> optionMap = new HashMap<String, Integer>();
			Date date = new Date(expDate.getValue().toEpochDay());
			for(TextField t : pollOptions)
			{
				optionMap.put(t.getText(), 0);
			}
			Polls.createPoll(field0.getText(), date, optionMap);
			pollOptions.clear();
			field0=null;
			rowCount=0;
		}
		else if(e.getSource().equals(logoutButton))
		{
//			actionTarget.setText("switch back to login screen");
			p = FXMLLoader.load(getClass().getResource("LoginScreenFXML.fxml"));
			s = new Scene(p, 400, 375);
			ps = (Stage)logoutButton.getScene().getWindow();
			ps.setTitle("ROGMsg - Login");
			ps.setScene(s);
		}
		else
		{
			actionTarget.setText("that's not right");
		}
	}
	
	/**
	 * pulls the list of users in the group from the ClientApp at login.
	 */
	@SuppressWarnings("unchecked")
	public void initUserList()
	{
		ObservableList<User> users =  FXCollections.<User>observableArrayList();
		users = (ObservableList<User>) ClientApp.get_userListCpy();
		userList = new ListView<User>(users);
	}
}