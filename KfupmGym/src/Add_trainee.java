import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Add_trainee extends BorderPane{
	String usersPath = "D:\\Eclipse\\SWE206Project\\res\\users.dat";
	Label username = new Label("Enter the trainee's username.");
	TextField usernametf = new TextField();
	TextField heighttf = new TextField();
	TextField weighttf = new TextField();
	TextField specialstf = new TextField();
	Button Back = new Button("Back");
	Button Save = new Button("Save");
	Label message = new Label("The trainee has been added.");
	Label error = new Label("");
	
	VBox Cvbox = new VBox();
	VBox Lvbox = new VBox();
	VBox Rvbox = new VBox();
	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	HBox hbox9 = new HBox();

	Add_trainee(Trainer trainer){
		hbox1.getChildren().add(username);
		hbox1.setAlignment(Pos.CENTER);

		hbox2.getChildren().add(usernametf);
		hbox2.setPadding(new Insets(0,0,10,0));
		hbox2.setAlignment(Pos.CENTER);

		hbox9.getChildren().addAll(Back,Save);
		hbox9.setPadding(new Insets(20,0,0,0));
		hbox9.setSpacing(10);
		hbox9.setAlignment(Pos.CENTER);

		Cvbox.getChildren().addAll(hbox1,hbox2,hbox9,error);
		Cvbox.setPadding(new Insets(0,200,0,200));
		
		Cvbox.setAlignment(Pos.CENTER);
		Lvbox.setAlignment(Pos.CENTER);
		Rvbox.setAlignment(Pos.CENTER);
		
		setRight(Rvbox);
		setCenter(Cvbox);
		setLeft(Lvbox);
		
		
		Save.setOnAction(e->{
			try {
			String username = usernametf.getText();
			User[] users = Main.auth.getUsers();
			boolean exists = false;
			for(int i=0;i<users.length;i++) {
				if(users[i].getUser().equals(username) &&
						users[i] instanceof Trainee) {
					
					for(int j=0;j<trainer.getTrainees().size();j++) {
						if(trainer.getTrainees().get(j).getUser().equals(users[i].getUser())) {
							error.setText("this trainee has already been added before.");
							throw new Exception();
						}
					}
					
					trainer.addTrainee((Trainee) users[i]);
					break;
				}
			}
			
			Main.auth.saveUsers(usersPath, Main.auth.getUsers());
			error.setText("The trainee has been added.");
			}
			
			catch(Exception e1) {
				
			}
		});
		
		Back.setOnAction(e->{
			Main.scene.setRoot(new Trainer_Interface(trainer));
		});
	}
}
