import java.io.Serializable;

public class Trainee extends User implements Serializable{
	private Plan plan;
	private Progress progress;
	
	Trainee(String username,String password){
		super(username,password);
	}
	
	public void addPlan(Plan plan){
		this.plan = plan;
	}
	
	public void addProgress(Progress progress) {
		this.progress = progress;
	}
	
	public Plan getPlan() {
		return plan;
	}
	
	public Progress getProgress() {
		return progress;
	}
}
