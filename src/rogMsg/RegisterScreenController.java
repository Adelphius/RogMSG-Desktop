package rogMsg;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterScreenController
{
	@FXML private Text actionTarget;
	@FXML private TextField userName, email;
	@FXML private PasswordField password, confirmPassField;
	@FXML private Button submitButton, cancelButton;
	private Stage stage;
	
	@FXML public void handleButton(ActionEvent e) throws IOException
	{
		if(e.getSource().equals(submitButton))
		{
			String un = userName.getText();
			String em = email.getText();
			String pw = password.getText();
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
		else
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
	}

	public void setStage(Stage s)
	{
		// TODO Auto-generated method stub
		stage = s;
	}
}
