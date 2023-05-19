import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main_Interface extends BorderPane {
	Label title = new Label("KFUPM GYM");
	Label usern = new Label("Username");
	Label pass = new Label("Password");
	TextField usertf = new TextField();
	TextField passtf = new TextField();
	Button signin = new Button("Sign in");
	Button signup = new Button("Sign up");
	Label error = new Label("your username or password is incorrect");
	
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
	
	Main_Interface(){
	    Font font1 = Font.font("Verdana", FontWeight.BOLD, null, 40);
		title.setFont(font1);
		hbox7.getChildren().add(title);
		hbox7.setPadding(new Insets(0,0,40,0));
		hbox7.setAlignment(Pos.CENTER);
		
		hbox1.getChildren().add(usern);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.getChildren().add(usertf);
		hbox2.setPadding(new Insets(0,0,10,0));
		hbox2.setAlignment(Pos.CENTER);
		
		hbox3.getChildren().add(pass);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.getChildren().add(passtf);
		hbox4.setAlignment(Pos.CENTER);

		hbox5.getChildren().addAll(signin,signup);
		hbox5.setPadding(new Insets(20,0,0,0));
		hbox5.setSpacing(10);
		hbox5.setAlignment(Pos.CENTER);

		Cvbox.getChildren().addAll(hbox7,hbox1,hbox2,hbox3,hbox4,hbox5,hbox6);
		Cvbox.setPadding(new Insets(0,200,0,200));
		
		Cvbox.setAlignment(Pos.CENTER);
		Lvbox.setAlignment(Pos.CENTER);
		Rvbox.setAlignment(Pos.CENTER);
		
		setRight(Rvbox);
		setCenter(Cvbox);
		setLeft(Lvbox);
		
		signup.setOnAction(e->{
			Main.scene.setRoot(new Sign_up());
		});
		
		signin.setOnAction(e->{
			try {
			String username = usertf.getText();
			String password = passtf.getText();
			User[] users = Main.auth.getUsers();
			
			for(int i=0;i<users.length;i++) {
				if(users[i].getUser().equals(username) &&
					users[i].getPass().equals(password)) {
					
					if(users[i] instanceof Trainer) {
						Main.scene.setRoot(new Trainer_Interface((Trainer) users[i]));
						break;
					}
					else if(users[i] instanceof Trainee) {
						Main.scene.setRoot(new Trainee_Interface((Trainee) users[i]));
						break;
					}
				}
			}
			
			}
			catch(Exception e1) {
				Cvbox.getChildren().add(error);
				System.out.println(e1);
			}
		});
	}
	
}
