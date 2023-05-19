import java.io.Serializable;

public class Plan implements Serializable{

private String exerc;
private String reps;
private String sets;
	
	public Plan() {
		this.exerc = "none";
		this.reps  = "0";
		this.sets  = "0";
	}
	
	public Plan(String exercise,String reps,String sets) {
		this.exerc = exercise;
		this.reps  = reps;
		this.sets  = sets;
	}
	
	public String getExerc(){
		return this.exerc;
	}
	public String getReps(){
		return this.reps;
	}
	public String getSets(){
		return this.sets;
	}
	
	
}
