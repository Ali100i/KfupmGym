import java.io.Serializable;

public class User implements Serializable{
	private String username;
	private String password;
	private String Name;
	private String height;
	private String weight;
	
	User(String username,String password){
		this.username = username;
		this.password = password;
		this.Name = username;
		this.height = "0.0";
		this.weight = "0.0";
	}
	
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	
	public void setHeight(String height) {
		this.height = height;
	}
	
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String getUser(){
		return username;
	}
	
	public String getPass() {
		return password;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getHeight() {
		return height;
	}
	
	public String getWeight() {
		return weight;
	}
}
