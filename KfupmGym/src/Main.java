import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	public static Scene scene = new Scene(new Main_Interface(),700,600);
	public static Authorization auth = new Authorization();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		auth.loadUsers();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("KFUPM Gym");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
	      Application.launch(args);
	   }
	
	
	
}
