import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Trainee_Interface extends VBox {

    private String Name;
    private float height;
    private float weight;
    private Button EditProfile;
    private Button EditWorkoutprogress;
    private Button Viewworkoutprogress;
    private Button ViewPlan;
    private Button LogOut;
    private TextField AddName;
    private TextField Addheight;
    private TextField Addweight;
    
	Trainee_Interface(Trainee trainee){
		Label error = new Label("");
		
		Image image = new Image("Sample_User_Icon.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(150);
		imageView.setFitHeight(150);

        
        EditProfile = new Button("Edit Profile");
        EditWorkoutprogress = new Button("Edit Workout progress");
        Viewworkoutprogress = new Button("View workout progress");
        ViewPlan = new Button("View Plan");
        LogOut = new Button("Log Out");
        
	    Font font1 = Font.font("Verdana", FontWeight.BOLD, null, 15);
	    
        Label AddName = new Label("Name: "+trainee.getName());
        AddName.setFont(font1);
        Label Addheight = new Label("height: "+trainee.getHeight());
        Addheight.setFont(font1);
        Label Addweight = new Label("weight: "+trainee.getWeight());  
        Addweight.setFont(font1);
        
        VBox vbPhoto= new VBox();
        vbPhoto.setAlignment(Pos.TOP_CENTER);
        vbPhoto.setSpacing(5);
        vbPhoto.getChildren().add(imageView);
        
        VBox vbLogOut= new VBox();
        vbLogOut.setAlignment(Pos.TOP_RIGHT);
        vbLogOut.setSpacing(5);
        vbLogOut.getChildren().add(LogOut);
        
        VBox vbProfile= new VBox();
        vbProfile.setAlignment(Pos.TOP_LEFT);
        vbProfile.setSpacing(3);
        vbProfile.getChildren().addAll(EditProfile);
        
        VBox vbAdd = new VBox();
        vbAdd.setAlignment(Pos.CENTER);
        vbAdd.setSpacing(10);
        vbAdd.getChildren().addAll(AddName, Addheight, Addweight);
        
        HBox hbButton1 = new HBox();
        hbButton1.setAlignment(Pos.CENTER);
        hbButton1.setSpacing(30);
        hbButton1.getChildren().addAll(EditWorkoutprogress, ViewPlan,Viewworkoutprogress);
        
        HBox hbButton2 = new HBox();
        hbButton2.setAlignment(Pos.CENTER);
        hbButton2.setSpacing(30);
        
        VBox vbButtons = new VBox();
        vbButtons.setAlignment(Pos.CENTER);
        vbButtons.setSpacing(20);
        vbButtons.getChildren().addAll(hbButton1, hbButton2);
        
        this.setPadding(new Insets(30,30,30,30));
        this.setSpacing(40);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(vbPhoto, vbLogOut, vbProfile, vbAdd, vbButtons, error);
        
        EditProfile.setOnAction(e->{
        	Main.scene.setRoot(
        			new edit_trainee_profile(trainee));
        });
        
        LogOut.setOnAction(e->{
			Main.scene.setRoot(new Main_Interface());
		});
        
        ViewPlan.setOnAction(e->{
        	try {
        	Main.scene.setRoot(new View_Plan(trainee));
        	}
        	catch(Exception e1) {
        		error.setText("There is no plan added at the moment.");
        	}
        });
        
        EditWorkoutprogress.setOnAction(e->{
        	try {
        	Main.scene.setRoot(new Edit_progress(trainee));
        	}
        	catch(Exception e1) {
        		error.setText("Please wait for your trainer to add a plan before recording progress.");
        	}
        });
        
        Viewworkoutprogress.setOnAction(e->{
        	try {
        	Main.scene.setRoot(new Progress_Interface2(trainee));
        	}
        	catch(Exception e1) {
        		error.setText("There is no progress to be viewed.");
        	}
        });
	}

	

}
