package rogMsg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChatWindowController implements Initializable
{
	@FXML private GridPane newUserForm;
	@FXML private VBox uViewer, lViewer, pViewer, announcementBox;
	@FXML private Text actionTarget;
	@FXML private ListView<User> userList;
	@FXML private ListView<Lst> lists;
	@FXML private ListView<Poll> polls;
	@FXML private TabPane announcementsPane;
	@FXML private ScrollPane announcements;
	@FXML private TabPane extras;
	@FXML private Tab listsTab, pollsTab, announcementsTab;
	@FXML private Button setUserNameButton, addUserButton, logoutButton, submitMessageButton, newListButton, newPollButton;
	@FXML private TextField userName, messageField;
	@FXML private Parent root;
	private String usrName;
	private Stage stage;
	private List<Message> messages;
	
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
			Message msg = new Message(messageField.getText());
			msg.setAuthor(usrName);
			//send message here?
			HBox h =  new HBox();
			Label l = new Label(usrName + ": ");
			Text t = new Text(messageField.getText());
			h.getChildren().add(l);
			h.getChildren().add(t);
			announcementBox.getChildren().add(h);
		}
		else if(e.getSource().equals(newListButton))
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("NewListFormFXML.fxml"));
			GridPane page = (GridPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Create new list");
			Scene scene = new Scene(page, 400, 275);
			dialogStage.setScene(scene);
			NewListFormController listForm = loader.getController();
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
			NewPollFormController pollForm = loader.getController();
			dialogStage.show();
		}
		else if(e.getSource().equals(setUserNameButton))
		{
			usrName = userName.getText();
		}
		else
		{
			actionTarget.setText("That's not right.");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		messages = new ArrayList<>();
		usrName = null;
		
		for(Message m : messages)
		{
			HBox h =  new HBox();
			Label l = new Label(m.getAuthor());
			Text t = new Text(m.getStringMsg());
			h.getChildren().add(l);
			h.getChildren().add(t);
			announcementBox.getChildren().add(h);
		}
		
		userList.setCellFactory(param -> new ListCell<User>()
		{
			protected void updateItem(User usr, boolean empty)
			{
				super.updateItem(usr, empty);
				if(empty || usr == null || usr.getName() == null)
				{
					setText(null);
				}
				else
				{
					setText(usr.getName());
				}
			}
		});
		userList.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				
			}
		});		
		lists.setCellFactory(param -> new ListCell<Lst>()
		{
			protected void updateItem(Lst lst, boolean empty)
			{
				super.updateItem(lst, empty);
				if(empty || lst == null || lst.getName() == null)
				{
					setText(null);
				}
				else
				{
					setText(lst.getName());
				}
			}
		});
		lists.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				ListView<String> itemView = new ListView<>();
				itemView.setItems(FXCollections.observableArrayList(lists.getSelectionModel().getSelectedItem().getItems()));
				lViewer.getChildren().add(itemView);
			}
		});
		polls.setCellFactory(param -> new ListCell<Poll>()
		{
			protected void updateItem(Poll poll, boolean empty)
			{
				super.updateItem(poll, empty);
				if(empty || poll == null || poll.getName() == null)
				{
					setText(null);
				}
				else
				{
					setText(poll.getName());
				}
			}
		});
		polls.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				ListView<String> itemView = new ListView<>();
				itemView.setItems(FXCollections.observableArrayList(polls.getSelectionModel().getSelectedItem().getOptions().keySet()));
				pViewer.getChildren().add(itemView);
			}
		});		
	}

	public void setStage(Stage s)
	{
		stage = s;
	}
	
	public void setUserList(List<User> usrs)
	{
		userList.setItems(FXCollections.observableArrayList(usrs));
	}
	
	public void setLstList(List<Lst> lsts)
	{
		lists.setItems(FXCollections.observableArrayList(lsts));
	}
	
	public void setPollList(List<Poll> pls)
	{
		polls.setItems(FXCollections.observableArrayList(pls));
	}
	
	public void setMessages(List<Message> msgs)
	{
		messages = msgs;
	}
}
