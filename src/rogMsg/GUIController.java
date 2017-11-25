package rogMsg;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIController
{
	@FXML private Text actionTarget;
	@FXML private Button submitButton;
	@FXML private Button registerButton;
	@FXML private Button cancelButton;
	@FXML private TextField userName;
	@FXML private TextField email;
	@FXML private PasswordField passwordField;
	@FXML private PasswordField confirmPassField;
	
	@FXML protected void handleButton(ActionEvent e) throws IOException 
	{
		if(e.getSource().equals(submitButton))
		{
			actionTarget.setText("Not implemented yet.");
		}
		else if(e.getSource().equals(registerButton))
		{
//			actiontarget.setText("switch to register screen now");
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
}
