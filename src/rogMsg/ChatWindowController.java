package rogMsg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChatWindowController implements Initializable
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
	@FXML private Button addUserButton, logoutButton, submitMessageButton, newListButton, newPollButton;
	@FXML private TextField userName, messageField;
	@FXML private Parent root;
	private Stage stage;
	
	@FXML public void handleButton(ActionEvent e) throws IOException
	{
		if(e.getSource().equals(addUserButton))
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("NewUserFormFXML.fxml"));
			GridPane page = (GridPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Add user to group");
			Scene scene = new Scene(page, 300, 175);
			dialogStage.setScene(scene);
//			NewUserFormController userForm = loader.getController();
			dialogStage.show();
		}
		else if(e.getSource().equals(logoutButton))
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreenFXML.fxml"));
			GridPane page = (GridPane) loader.load();
			Stage dialogStage = stage;
			dialogStage.setTitle("ROGMsg - Login");
			Scene scene = new Scene(page, 400, 375);
			dialogStage.setScene(scene);
			LoginController login = loader.getController();
			login.setStage(dialogStage);
		}
		else if(e.getSource().equals(submitMessageButton))
		{
			
		}
		else if(e.getSource().equals(newListButton))
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("NewListFormFXML.fxml"));
			GridPane page = (GridPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Create new list");
			Scene scene = new Scene(page, 400, 275);
			dialogStage.setScene(scene);
//			NewUserFormController userForm = loader.getController();
			dialogStage.show();
		}
		else if(e.getSource().equals(newPollButton))
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("NewPollFormFXML.fxml"));
			GridPane page = (GridPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Create new poll");
			Scene scene = new Scene(page, 300, 175);
			dialogStage.setScene(scene);
//			NewUserFormController userForm = loader.getController();
			dialogStage.show();
		}
		else
		{
			actionTarget.setText("That's not right.");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
		
	}

	public void setStage(Stage s)
	{
		// TODO Auto-generated method stub
		stage = s;
	}
}
