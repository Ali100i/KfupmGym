import java.io.Serializable;
import java.util.ArrayList;

public class Trainer extends User implements Serializable{
	private String Specialities;
	private ArrayList<Trainee> trainees = new ArrayList<Trainee>();
	
	Trainer(String username,String password){
		super(username,password);
		Specialities = "none";
	}
	
	public void setSpecialities(String Specialities) {
		this.Specialities = Specialities;
	}
	
	public void addTrainee(Trainee trainee) {
		trainees.add(trainee);
	}
	
	public String getSpecials() {
		return Specialities;
	}
	
	public ArrayList<Trainee> getTrainees(){
		return trainees;
	}
}
