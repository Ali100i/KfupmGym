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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Trainer_Interface extends VBox {
    private Button EditProfile;
    private Button ViewRepetitions;
    private Button ViewWeight;
    private Button ViewTrainee;
    private Button AddTrainee;
    private Button CreatePlan;
    private Button ModifyPlan;
    private Button LogOut;
    private Label AddName;
    public Trainer_Interface(Trainer trainer){
		Image image = new Image("Sample_User_Icon.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(150);
		imageView.setFitHeight(150);
        
        EditProfile = new Button("Edit Profile");
        ViewRepetitions = new Button("View Repetitions");
        ViewWeight = new Button("View Weight");
        ViewTrainee = new Button("View Trainee");
        AddTrainee = new Button("Add Trainee");
        CreatePlan = new Button("Create Plan");
        LogOut = new Button("Log Out");
        
        
        
        ModifyPlan = new Button("Modify Plan");
        
	    Font font1 = Font.font("Verdana", FontWeight.BOLD, null, 15);
        
        AddName = new Label("Name: "+trainer.getName());
		AddName.setFont(font1);
        Label Addheight = new Label("height: "+trainer.getHeight());
        Addheight.setFont(font1);
        Label Addweight = new Label("weight: "+trainer.getWeight());
        Addweight.setFont(font1);
        Label AddSpecialities = new Label("Specialities: "+trainer.getSpecials());
        AddSpecialities.setFont(font1);
        
        VBox vbPhoto= new VBox();
        vbPhoto.setAlignment(Pos.TOP_CENTER);
        vbPhoto.setSpacing(5);
        vbPhoto.getChildren().add(imageView);
        
        VBox vbProfile= new VBox();
        vbProfile.setAlignment(Pos.TOP_LEFT);
        vbProfile.setSpacing(5);
        vbProfile.getChildren().add(EditProfile);
        
        VBox vbLogOut= new VBox();
        vbLogOut.setAlignment(Pos.TOP_RIGHT);
        vbLogOut.setSpacing(5);
        vbLogOut.getChildren().add(LogOut);
        
        VBox vbAdd = new VBox();
        vbAdd.setAlignment(Pos.CENTER);
        vbAdd.setSpacing(10);
        vbAdd.getChildren().addAll(AddName, Addheight, Addweight, AddSpecialities);
        
        HBox hbButton1 = new HBox();
        hbButton1.setAlignment(Pos.CENTER);
        hbButton1.setSpacing(30);
        hbButton1.getChildren().addAll(ViewTrainee,AddTrainee);
        
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
        this.getChildren().addAll(vbPhoto, vbLogOut, vbProfile, vbAdd, vbButtons );
        
        
        EditProfile.setOnAction(e->{
        	Main.scene.setRoot(
        			new edit_trainer_profile(trainer));
        });
        
        AddTrainee.setOnAction(e->{
        	Main.scene.setRoot(new Add_trainee(trainer));
        });
        
        LogOut.setOnAction(e->{
			Main.scene.setRoot(new Main_Interface());
		});
        
        ViewTrainee.setOnAction(e->{
			Main.scene.setRoot(new View_trainee_Interface(trainer));
		});
        
    }
}
