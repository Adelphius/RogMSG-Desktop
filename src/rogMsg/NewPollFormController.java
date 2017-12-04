package rogMsg;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class NewPollFormController implements Initializable
{
	@FXML private GridPane innerGrid;
	@FXML private Text actionTarget;
	@FXML private TextField pollQuestion;
	@FXML private DatePicker expDate;
	@FXML private Button createButton, addOptionButton;
	private int rowCount;
	private List<TextField> pollOptions;
	
	@FXML protected void handleButton(ActionEvent e)
	{
		Label label = new Label("");
		TextField field = new TextField();
		
		if(e.getSource().equals(createButton))
		{
			if(pollQuestion.getText().trim().isEmpty() || expDate.getValue() == null || pollOptions.isEmpty())
			{
				actionTarget.setText("Invalid poll.");
			}
			else
			{
				actionTarget.setText("Not implemented yet.");
				//something still needs to be put here.
			}
		}
		else
		{
			rowCount++;
			label.setText("Option " + (rowCount-1) + ":");
			innerGrid.add(label, 0, rowCount);
			innerGrid.add(field, 1, rowCount);
			pollOptions.add(field);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		rowCount = 1;
		pollOptions = new ArrayList<>();
	}
}
