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

public class Edit_progress extends BorderPane{
	String usersPath = "D:\\Eclipse\\SWE206Project\\res\\users.dat";
	Label Reps = new Label("Enter the Repetitions");
	Label Sets = new Label("Enter the Sets");
	Label message = new Label("All changes are saved.");
	TextField Exerctf = new TextField();
	TextField Repstf = new TextField();
	TextField Setstf = new TextField();
	Button Back = new Button("Back");
	Button Save = new Button("Save");
	
	VBox Cvbox = new VBox();
	VBox Lvbox = new VBox();
	VBox Rvbox = new VBox();
	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	HBox hbox3 = new HBox();
	HBox hbox4 = new HBox();
	HBox hbox5 = new HBox();
	HBox hbox6 = new HBox();
	HBox hbox9 = new HBox();

	Edit_progress(Trainee trainee){
	    Font font1 = Font.font("Verdana", FontWeight.BOLD, null, 20);
		Label Exerc = new Label("Exercise: "+trainee.getPlan().getExerc());
		Exerc.setFont(font1);
		
		hbox1.getChildren().add(Exerc);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setPadding(new Insets(0,0,35,0));

		hbox3.getChildren().add(Reps);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.getChildren().add(Repstf);
		hbox4.setAlignment(Pos.CENTER);
		hbox4.setPadding(new Insets(0,0,25,0));

		hbox5.getChildren().add(Sets);
		hbox5.setAlignment(Pos.CENTER);
		hbox6.getChildren().add(Setstf);
		hbox6.setAlignment(Pos.CENTER);
		hbox6.setPadding(new Insets(0,0,25,0));

		hbox9.getChildren().addAll(Back,Save);
		hbox9.setPadding(new Insets(20,0,0,0));
		hbox9.setSpacing(10);
		hbox9.setAlignment(Pos.CENTER);

		Cvbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5,hbox6,hbox9);
		Cvbox.setPadding(new Insets(0,200,0,200));
		
		Cvbox.setAlignment(Pos.CENTER);
		Lvbox.setAlignment(Pos.CENTER);
		Rvbox.setAlignment(Pos.CENTER);
		
		setRight(Rvbox);
		setCenter(Cvbox);
		setLeft(Lvbox);
		
		
		Save.setOnAction(e->{
			trainee.addProgress(new Progress(trainee.getPlan().getExerc(),Repstf.getText(),Setstf.getText()));
			Main.auth.saveUsers(usersPath, Main.auth.getUsers());
			Cvbox.getChildren().add(message);
		});
		
		Back.setOnAction(e->{
			Main.scene.setRoot(new Trainee_Interface(trainee));
		});
	}
}
