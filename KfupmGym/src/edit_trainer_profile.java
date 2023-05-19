import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class edit_trainer_profile extends BorderPane{
	String usersPath = "D:\\Eclipse\\SWE206Project\\res\\users.dat";
	Label Name = new Label("Edit your name.");
	Label height = new Label("Edit your height.");
	Label weight = new Label("Edit your weight.");
	Label Specialities = new Label("Edit your specialities.");
	Label message = new Label("All changes are saved.");

	TextField nametf = new TextField();
	TextField heighttf = new TextField();
	TextField weighttf = new TextField();
	TextField specialstf = new TextField();
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
	HBox hbox7 = new HBox();
	HBox hbox8 = new HBox();
	HBox hbox9 = new HBox();

	edit_trainer_profile(Trainer trainer){
		hbox1.getChildren().add(Name);
		hbox1.setAlignment(Pos.CENTER);

		hbox2.getChildren().add(nametf);
		hbox2.setPadding(new Insets(0,0,10,0));
		hbox2.setAlignment(Pos.CENTER);

		hbox3.getChildren().add(height);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.getChildren().add(heighttf);
		hbox4.setAlignment(Pos.CENTER);

		hbox5.getChildren().add(weight);
		hbox5.setAlignment(Pos.CENTER);
		hbox6.getChildren().add(weighttf);
		hbox6.setAlignment(Pos.CENTER);

		hbox7.getChildren().add(Specialities);
		hbox7.setAlignment(Pos.CENTER);
		hbox8.getChildren().add(specialstf);
		hbox8.setAlignment(Pos.CENTER);

		hbox9.getChildren().addAll(Back,Save);
		hbox9.setPadding(new Insets(20,0,0,0));
		hbox9.setSpacing(10);
		hbox9.setAlignment(Pos.CENTER);

		Cvbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5,hbox6,hbox7,hbox8,hbox9);
		Cvbox.setPadding(new Insets(0,200,0,200));
		
		Cvbox.setAlignment(Pos.CENTER);
		Lvbox.setAlignment(Pos.CENTER);
		Rvbox.setAlignment(Pos.CENTER);
		
		setRight(Rvbox);
		setCenter(Cvbox);
		setLeft(Lvbox);
		
		
		Save.setOnAction(e->{
			trainer.setName(nametf.getText());
			trainer.setHeight(heighttf.getText());
			trainer.setWeight(weighttf.getText());
			trainer.setSpecialities(specialstf.getText());
			Main.auth.saveUsers(usersPath, Main.auth.getUsers());
			Cvbox.getChildren().add(message);
		});
		
		Back.setOnAction(e->{
			Main.scene.setRoot(new Trainer_Interface(trainer));
		});
	}
}
