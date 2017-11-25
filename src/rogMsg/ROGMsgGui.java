package rogMsg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ROGMsgGui extends Application
{

	private Parent root;
	private Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		root = FXMLLoader.load(getClass().getResource("LoginScreenFXML.fxml"));
		scene = new Scene(root, 400, 375);
		primaryStage.setTitle("ROG-Msg - Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
