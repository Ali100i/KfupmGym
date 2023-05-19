import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Sign_up extends BorderPane{
	Label usern = new Label("Username");
	Label pass = new Label("Password");
	Label user_Type = new Label("User Type (Trainer/Trainee).");
	TextField usertf = new TextField();
	TextField passtf = new TextField();
	TextField userType = new TextField();
	Button signup = new Button("Sign up");
	Button Back = new Button("Back");
	Label error1 = new Label("Please fill up all the requirements.");
	Label error2 = new Label("The username already exists.");
	
	VBox Cvbox = new VBox();
	VBox Lvbox = new VBox();
	VBox Rvbox = new VBox();
	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	HBox hbox3 = new HBox();
	HBox hbox4 = new HBox();
	HBox hbox5 = new HBox();
	HBox hbox6 = new HBox();
	HBox hbox7 = new HBox();

	Sign_up(){
		hbox1.getChildren().add(usern);
		hbox1.setAlignment(Pos.CENTER);
		
		hbox2.getChildren().add(usertf);
		hbox2.setPadding(new Insets(0,0,10,0));
		hbox2.setAlignment(Pos.CENTER);

		hbox3.getChildren().add(pass);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.getChildren().add(passtf);
		hbox4.setPadding(new Insets(0,0,10,0));
		hbox4.setAlignment(Pos.CENTER);

		hbox5.getChildren().addAll(Back, signup);
		hbox5.setPadding(new Insets(20,0,0,0));
		hbox5.setSpacing(10);
		hbox5.setAlignment(Pos.CENTER);
		
		hbox6.getChildren().add(user_Type);
		hbox6.setAlignment(Pos.CENTER);
		hbox7.getChildren().add(userType);
		hbox7.setAlignment(Pos.CENTER);


		Cvbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox6,hbox7,hbox5);
		Cvbox.setPadding(new Insets(0,200,0,200));
		
		Cvbox.setAlignment(Pos.CENTER);
		Lvbox.setAlignment(Pos.CENTER);
		Rvbox.setAlignment(Pos.CENTER);
		
		setRight(Rvbox);
		setCenter(Cvbox);
		setLeft(Lvbox);
		
		signup.setOnAction(e->{
			String Type = userType.getText();
			String username = usertf.getText();
			String password = passtf.getText();
			User[] users = Main.auth.getUsers();
			boolean exists = false;
			
			
			for(int i=0;i<users.length;i++) {
				if(users[i] != null && users[i].getUser().equals(username)) {
					exists = true;
					break;
				}
			}
			if(exists) {
				Cvbox.getChildren().add(error2);
			}
			else if(Type.length() == 7 && username.length() >= 3 && password.length() >= 3) {
				
				Main.auth.addUser(Type.toLowerCase(), username, password);
				Main.scene.setRoot(new Main_Interface());
			}
			else {
				Cvbox.getChildren().add(error1);
			}
			
		});
		Back.setOnAction(e->{
			Main.scene.setRoot(new Main_Interface());
		});
	}
}
