import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class View_trainee_Interface extends BorderPane {
	int Index = -1;
	Trainee trainee;
	View_trainee_Interface(Trainer trainer){
		 ArrayList<Trainee> trainees = trainer.getTrainees();
		 ListView<String> Traineelist = new ListView(FXCollections.observableArrayList());
		 
		 Label lb1 = new Label("Name: ");
		 Label lb2 = new Label("Height: ");
		 Label lb3 = new Label("Weight: ");
		 Label lb4 = new Label("Trainee list.");
		 Label err1 = new Label("Please select a trainee first.");
		 Label err2 = new Label("The trainee did not record his progress at the moment.");
		 
		 for(int i=0; i<trainees.size();i++) {
			 Traineelist.getItems().add(trainees.get(i).getUser());
		 }
		 
		 Button back = new Button("Back");
		 Button previous = new Button("< Previous");
		 Button next = new Button("Next >");
		 Button progress = new Button("View Workout Progress");
		 Button addPlan = new Button("Add Plan");
		 
		 HBox hbox1 = new HBox();
		 HBox hbox2 = new HBox();
		 HBox hbox3 = new HBox();
		 HBox hbox4 = new HBox();
		 HBox hbox5 = new HBox();
		 HBox hbox6 = new HBox();
		 HBox hbox7 = new HBox();
		 
		 VBox vboxL = new VBox();
		 VBox vboxR = new VBox();
		 VBox vboxC = new VBox();
		 
		 vboxL.getChildren().addAll(lb4,Traineelist);
		 
		 hbox1.getChildren().add(lb1);
		 hbox2.getChildren().add(lb2);
		 hbox3.getChildren().add(lb3);
		 
		   hbox1.setPadding(new Insets(10,10,10,10));
		   hbox1.setSpacing(55);
		   hbox2.setPadding(new Insets(10,10,10,10));
		   hbox2.setSpacing(35);
		   hbox3.setPadding(new Insets(10,10,10,10));
		   hbox3.setSpacing(40);
		 
		 hbox7.getChildren().addAll(back,previous,next,progress,addPlan);
		 hbox7.setAlignment(Pos.CENTER);
		 hbox7.setSpacing(10);
		 
		 vboxC.getChildren().addAll(hbox1,hbox2,hbox3);
		 
		 vboxL.setAlignment(Pos.CENTER);
		 vboxR.setAlignment(Pos.CENTER);
		 vboxC.setAlignment(Pos.CENTER);
		 
		 setLeft(vboxL);
		 setRight(vboxR);
		 setCenter(vboxC);
		 setBottom(hbox7);
		 setPadding(new Insets(20,20,20,20));
		 
		 
		 back.setOnAction(e->{
			 Main.scene.setRoot(new Trainer_Interface(trainer));
		 });
		 
		 previous.setOnAction(e->{
			 if(Index > 0) {
				 Index--;
			 }
			 
			 else {
				 Index = trainees.size() - 1;
			 }
			 
			 Traineelist.getSelectionModel().select(Index);
			 lb1.setText("Name: "+trainees.get(Index).getName());
			 lb2.setText("Weight: "+trainees.get(Index).getWeight());
			 lb3.setText("Height: "+trainees.get(Index).getHeight());
			 			 
			 trainee = trainees.get(Index);
		 });
		 
		 next.setOnAction(e->{
			 if(Index+1 < trainees.size()) {
				 Index++;
			 }
			 
			 else {
				 Index = 0;
			 }
			 
			 Traineelist.getSelectionModel().select(Index);
			 lb1.setText("Name: "+trainees.get(Index).getName());
			 lb2.setText("Weight: "+trainees.get(Index).getWeight());
			 lb3.setText("Height: "+trainees.get(Index).getHeight());
			 
			 trainee = trainees.get(Index);
		 });
		 
		 progress.setOnAction(e->{
			 try {
				 if(Index >= 0) {
					 Main.scene.setRoot(new Progress_Interface(trainee,trainer));
				 }
				 
				 else {
					 vboxC.getChildren().add(err1);
				 }
			 }
			 catch(Exception e1) {
				 vboxC.getChildren().add(err2);
			 }
		 });
		 
		 addPlan.setOnAction(e->{
			 if(Index >= 0) {
				 Main.scene.setRoot(new Add_Plan(trainer,trainee));
			 }
		 });
		 
	}
	
}
