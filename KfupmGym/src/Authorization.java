import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Authorization{
	private User[] users = new User[100000];
	private String Type;
	private static String usersPath = "D:\\Eclipse\\SWE206Project\\res\\users.dat";
	
	public void addUser(String Type, String username, String password) {
		this.Type = Type;
		if(Type.equals("trainer")) {
			for(int i=0;i<this.users.length;i++) {
				if(this.users[i] == null) {
					this.users[i] = new Trainer(username,password);
					break;
				}
			}
		}
		else if (Type.equals("trainee")) {
			for(int i=0;i<users.length;i++) {
				if(this.users[i] == null) {
					this.users[i] = new Trainee(username,password);
					break;
				}
			}
		}
		
		saveUsers(usersPath,this.users);
	}
	
	public void saveUsers(String path,User[] user) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
			output.writeObject(user);
			output.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void loadUsers() throws ClassNotFoundException {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(usersPath));
			this.users = (User[]) input.readObject();
			input.close();
			System.out.println("users loaded successfully.");
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public User[] getUsers() {
		return this.users;
	}
}
