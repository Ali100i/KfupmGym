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

public class Progress_Interface2 extends BorderPane{	
	Button Back = new Button("Back");
	
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

	Progress_Interface2(Trainee trainee){
	    Font font1 = Font.font("Verdana", FontWeight.BOLD, null, 20);
	    Font font2 = Font.font("Verdana", FontWeight.BOLD, null, 20);
		Label Exerc = new Label("Exercise: "+trainee.getProgress().getExerc());
		Exerc.setFont(font1);
		Label Reps = new Label("Repetitions done: "+trainee.getProgress().getReps());
		Reps.setFont(font2);
		Label Sets = new Label("Sets done: "+trainee.getProgress().getSets());
		Sets.setFont(font2);
		
		hbox1.getChildren().add(Exerc);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setPadding(new Insets(0,0,40,0));

		hbox3.getChildren().add(Reps);
		hbox3.setAlignment(Pos.CENTER);
		hbox3.setPadding(new Insets(0,0,40,0));

		hbox5.getChildren().add(Sets);
		hbox5.setAlignment(Pos.CENTER);
		hbox5.setPadding(new Insets(0,0,40,0));

		hbox9.getChildren().addAll(Back);
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
		
		Back.setOnAction(e->{
			Main.scene.setRoot(new Trainee_Interface(trainee));
		});
	}
}
