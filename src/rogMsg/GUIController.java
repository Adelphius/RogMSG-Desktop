package rogMsg;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIController
{
	@FXML private Text actionTarget;
	@FXML private Text groupName;
	@FXML private ScrollPane userList;
	@FXML private TabPane announcementsPane;
	@FXML private ScrollPane announcements;
	@FXML private ScrollPane lists;
	@FXML private ScrollPane polls;
	@FXML private TabPane extras;
	@FXML private Tab listsTab;
	@FXML private Tab pollsTab;
	@FXML private Tab announcementsTab;
	@FXML private Button submitButton;
	@FXML private Button registerButton;
	@FXML private Button cancelButton;
	@FXML private Button addUserButton;
	@FXML private Button logoutButton;
	@FXML private Button submitMessageButton;
	@FXML private Button newListButton;
	@FXML private Button newPollButton;
	@FXML private TextField userName;
	@FXML private TextField email;
	@FXML private TextField messageField;
	@FXML private PasswordField passwordField;
	@FXML private PasswordField confirmPassField;
	
	@FXML protected void handleButton(ActionEvent e) throws IOException 
	{
		/***
		 * change this to a switch statement for handling all buttons
		 * 
		 */
		
		if(e.getSource().equals(submitButton))
		{
//			actionTarget.setText("switch to main chat window now");
			Parent p = FXMLLoader.load(getClass().getResource("ChatWindowFXML.fxml"));
			Scene s = new Scene(p, 400, 375);
			Stage ps = (Stage)submitButton.getScene().getWindow();
			ps.setTitle("ROG-Msg - Group Name");
			ps.setScene(s);
		}
		else if(e.getSource().equals(registerButton))
		{
//			actionTarget.setText("switch to register screen now");
			Parent p = FXMLLoader.load(getClass().getResource("RegisterScreenFXML.fxml"));
			Scene s = new Scene(p, 400, 375);
			Stage ps = (Stage)registerButton.getScene().getWindow();
			ps.setTitle("ROGMsg - Register");
			ps.setScene(s);
		}
		else
		{
//			actiontarget.setText("switch back to login screen");
			Parent p = FXMLLoader.load(getClass().getResource("LoginScreenFXML.fxml"));
			Scene s = new Scene(p, 400, 375);
			Stage ps = (Stage)cancelButton.getScene().getWindow();
			ps.setTitle("ROGMsg - Login");
			ps.setScene(s);
		}
	}
	
	public TextField getUserName()
	{
		return userName;
	}

	public void setUserName(TextField userName)
	{
		this.userName = userName;
	}

	public TextField getEmail()
	{
		return email;
	}

	public void setEmail(TextField email)
	{
		this.email = email;
	}

	public PasswordField getPasswordField()
	{
		return passwordField;
	}

	public void setPasswordField(PasswordField passwordField)
	{
		this.passwordField = passwordField;
	}

	public PasswordField getConfirmPassField()
	{
		return confirmPassField;
	}

	public void setConfirmPassField(PasswordField confirmPassField)
	{
		this.confirmPassField = confirmPassField;
	}
}
