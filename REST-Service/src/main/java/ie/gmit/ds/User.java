package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private int userId;
	private String userName;
	private String email;
	private String hashedPassword;
    private String salt;
    
    private String password;

	public User() {
		// Needed for Jackson deserialisation
    }
    // Used for create and update operations.

    public User(int userId, String userName, String email, String password){
        this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
    }

    // Used to return info on specific users and the list of all users.

	public User(int userId, String userName, String email, String hashedPassword, String salt) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.salt = salt;
	}

	@JsonProperty
	public int getUserId() {
		return userId;
	}

	@JsonProperty
	public String getUserName() {
		return userName;
	}

	@JsonProperty
	public String getEmail() {
		return email;
	}

	@JsonProperty
	public String getHashedPassword() {
		return hashedPassword;
	}

	@JsonProperty
	public String getSalt() {
		return salt;
    }
    
    @JsonProperty
	public String getPassword() {
		return password;
	}

}
