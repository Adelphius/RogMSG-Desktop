package rogMsg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class NewUserFormController implements Initializable 
{
	@FXML private Text actionTarget;
	@FXML private Button submitButton;
	@FXML private TextField userName;
	
	@FXML protected void handleButton(ActionEvent e) throws IOException
	{
		if(e.getSource().equals(submitButton))
		{
			if(userName.getText().trim().isEmpty())
			{
				actionTarget.setText("Must input user name.");
			}
			else
			{
				String usenm = userName.getText();
				User user = new User();
				user.setName(usenm);
				ClientApp.addUserToGroup(user);
				actionTarget.setText("User " + usenm + " added to group.");
			}
		}
	}
	
	/**
	 * This should be used to notify the user if the add was successful or not.
	 * @param s - the string to be passed in. lets the user know if the add passed or failed.
	 */
	public void getNotify(String s)
	{
		actionTarget.setText(s);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
