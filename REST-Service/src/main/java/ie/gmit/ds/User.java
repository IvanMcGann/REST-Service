package ie.gmit.ds;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User {

    @NotNull
    private int userId;
    @NotBlank @Length(min=2, max=255)
    private String userName;
    @Pattern(regexp=".+@.+\\.[a-z]+")
	private String email;
	private String hashedPassword;
    private String salt;
    @NotNull
    private String password;

	public User() {
        // Needed for Jackson deserialisation
        super();
    }
    // Used for create and update operations.

    public User(int userId, String userName, String email, String password){
        super();
        this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
    }

    // Used to return info on specific users and the list of all users.

	public User(int userId, String userName, String email, String hashedPassword, String salt) {
        super();
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
    
    @Override
    public String toString() {
        return "Emplyee [User id: " + userId + ", User Name: " + userName + ", Email: "
                + email + ", Password: " + hashedPassword + "]";
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    
}
