package ie.gmit.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
public class AccountsDB {

     public static HashMap<Integer, User> account = new HashMap<>();
    static{
        account.put(1, new User(1, "John Smith", "J.Smith@gmail.com", "12345"));
        account.put(2, new User(2, "John Doe", "JohnDoe@gmail.com", "98765"));
        account.put(3, new User(3, "Jane Doe", "JaneD@gmail.com", "02468"));
    }
     
    public static List<User> getUsers(){
		return new ArrayList<User>(account.values());
	}
	
	public static User getUser(Integer id) {
		return account.get(id);
	}
	
	public static void updateUser(Integer id, User u) {
		account.put(id, u);
	}
	
	public static void create(Integer id, User u) {
		account.put(id, u);
	}
	
	public static void remove(Integer id) {
		account.remove(id);
	}
}