package rogMsg;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	@FXML private Button submitButton, registerButton, cancelButton, addUserButton, logoutButton, submitMessageButton, submitAddUserButton, newListButton, createNewListButton, addNewListItemButton, newPollButton, addNewPollOptionButton, createNewPollButton;
	@FXML private TextField userName, email, messageField, field0;
	@FXML private ArrayList<TextField> listOptions, pollOptions;
	@FXML private PasswordField passwordField, confirmPassField;
	@FXML private GridPane innerGrid;
	private int rowCount;
	
	public GUIController()
	{
		rowCount = 0;
		listOptions = new ArrayList<TextField>();
		pollOptions = new ArrayList<TextField>();
		initLists();
	}
	
	@FXML protected void handleButton(ActionEvent e) throws IOException 
	{
		Parent p;
		Scene s;
		Stage ps;
		Label label = new Label("");
		TextField field = new TextField();
		
		//Submit login info
		if(e.getSource().equals(submitButton))
		{
//			actionTarget.setText("switch to main chat window now");
			
			
			
			p = FXMLLoader.load(getClass().getResource("ChatWindowFXML.fxml"));
			s = new Scene(p, 800, 600);
			ps = (Stage)submitButton.getScene().getWindow();
			ps.setTitle("ROG-Msg - Group Name");
			ps.setScene(s);
		}
		//Register
		else if(e.getSource().equals(registerButton))
		{
//			actionTarget.setText("switch to register screen now");
			p = FXMLLoader.load(getClass().getResource("RegisterScreenFXML.fxml"));
			s = new Scene(p, 400, 375);
			ps = (Stage)registerButton.getScene().getWindow();
			ps.setTitle("ROGMsg - Register");
			ps.setScene(s);
		}
		//Add user to group
		else if(e.getSource().equals(addUserButton))
		{
//			actionTarget.setText("open pop up now");
			p = FXMLLoader.load(getClass().getResource("NewUserFormFXML.fxml"));
			s = new Scene(p, 300, 200);
			ps = new Stage();
			ps.setTitle("ROGMsg - Add user to group");
			ps.setScene(s);
			ps.show();
		}
		//Submit new user to group
		else if(e.getSource().equals(submitAddUserButton))
		{
			String usenm = userName.getText();
			User newUser = new User();
			newUser.setName(usenm);
			addUserToGroup(newUser);
			actionTarget.setText("Add user " + usenm + " to group now");
		}
		//new list button
		else if(e.getSource().equals(newListButton))
		{
			p = FXMLLoader.load(getClass().getResource("NewListFormFXML.fxml"));
			s = new Scene(p, 300, 200);
			ps = new Stage();
			ps.setTitle("ROGMsg - Create a new list");
			ps.setScene(s);
			ps.show();
		}
		//add new item to list
		else if(e.getSource().equals(addNewListItemButton))
		{
			rowCount++;
			label.setText("Item " + rowCount + ":");
			innerGrid.add(label, 0, rowCount);
			innerGrid.add(field, 1, rowCount);
			listOptions.add(field);
		}
		else if(e.getSource().equals(createNewListButton))
		{
			
		}
		else if(e.getSource().equals(newPollButton))
		{
			p = FXMLLoader.load(getClass().getResource("NewPollFormFXML.fxml"));
			s = new Scene(p, 300, 200);
			ps = new Stage();
			ps.setTitle("ROGMsg - Create a new poll");
			ps.setScene(s);
			ps.show();
		}
		else if(e.getSource().equals(addNewPollOptionButton))
		{
			rowCount++;
			label.setText("Option " + rowCount + ":");
			innerGrid.add(label, 0, rowCount);
			innerGrid.add(field, 1, rowCount);
			listOptions.add(field);
		}
		else if(e.getSource().equals(createNewPollButton))
		{
			
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
	
	public void initLists()
	{
		ObservableList<User> users =  FXCollections.<User>observableArrayList();
		userList = new ListView<User>(users);
	}
	
	public void addUserToGroup(User user)
	{
		userList.getItems().add(user);
	}
}
