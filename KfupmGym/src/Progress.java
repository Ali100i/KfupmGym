import java.io.Serializable;

public class Progress implements Serializable{
	private String exerc;
	private String reps;
	private String sets;
		
		public Progress() {
			this.exerc = "Exercise: ";
			this.reps  = "Repetitions: ";
			this.sets  = "Sets: ";
		}
		
		public Progress(String exercise,String reps,String sets) {
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
		
		public void setReps(String reps) {
			this.reps = reps;
		}
		
		public void setSets(String sets) {
			this.sets = sets;
		}
		
}
