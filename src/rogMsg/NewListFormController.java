package rogMsg;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class NewListFormController implements Initializable
{
	private int rowCount;
	@FXML private GridPane mainPane;
	@FXML private GridPane innerGrid;
	@FXML private Button createButton, addItemButton;
	@FXML private Text actionTarget;
	@FXML private TextField listTitle;
	private List<TextField> listOptions;
	
	@FXML protected void handleButton(ActionEvent e)
	{
		Label label = new Label("");
		TextField field = new TextField();
		
		if(e.getSource().equals(createButton))
		{
			if(listTitle.getText().trim().isEmpty() || listOptions.isEmpty())
			{
				actionTarget.setText("Invalid list.");
			}
			else
			{
				List<String> options = new ArrayList<>();
				for(TextField t : listOptions)
				{
					if(t.getText().trim().isEmpty())
					{
						actionTarget.setText("All options must be filled before list creation.");
						break;
					}
					else
					{
						options.add(t.getText());
					}
				}
				System.out.println(listTitle.getText());
				System.out.println("options:");
				for(String s : options)
				{
					System.out.println(s);
				}
				Lists.createLst(listTitle.getText(), (ArrayList<String>)options);
			}
		}
		else
		{
			rowCount++;
			label.setText("Item " + rowCount + ":");
			innerGrid.add(label, 0, rowCount);
			innerGrid.add(field, 1, rowCount);
			listOptions.add(field);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		rowCount = 0;
		listOptions = new ArrayList<TextField>();
	}
}
