package rogMsg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController implements Initializable
{
	@FXML private Text actionTarget;
	@FXML private GridPane root;
	private Stage stage;
	@FXML private Button submitButton, registerButton;
	@FXML private TextField email, passwordField;
	
	@FXML protected void handleButton(ActionEvent e) throws IOException
	{
		if(e.getSource().equals(submitButton))
		{
			String em = email.getText();
			String pw = passwordField.getText();
			if(ClientApp.loginAttempt(pw, em))
			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatWindowFXML.fxml"));
				GridPane page = (GridPane) loader.load();
				Stage dialogStage = stage;
				dialogStage.setTitle("ROGMsg - Messaging");
				Scene scene = new Scene(page, 800, 600);
				dialogStage.setScene(scene);
				ChatWindowController chat = loader.getController();
				chat.setUserList(ClientApp.getUsrList());
				chat.setLstList(Lists.getListSquared());
				chat.setPollList(Polls.getPollList());
				chat.setMessages(Messaging.getMsgHistory());
				chat.setStage(dialogStage);
			}
			else
			{
				actionTarget.setText("User name or password incorrect. Try again.");
			}
		}
		else
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterScreenFXML.fxml"));
			GridPane page = (GridPane) loader.load();
			Stage dialogStage = stage;
			dialogStage.setTitle("ROGMsg - Login");
			Scene scene = new Scene(page, 400, 375);
			dialogStage.setScene(scene);
			RegisterScreenController register = loader.getController();
			register.setStage(dialogStage);
		}
	}
	
	public void setStage(Stage s)
	{
		stage = s;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO Auto-generated method stub
		
	}
}
