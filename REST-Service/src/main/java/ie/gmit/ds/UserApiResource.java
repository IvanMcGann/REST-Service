package ie.gmit.ds;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {

    private ClientAccount accClient;
	private final Validator validator;

	private final String host = "localhost";
	private final int port = 9999;

	public UserApiResource(Validator validator) {
		this.validator = validator;
		this.accClient = new ClientAccount(host, port);
	}

	public UserApiResource(Validator validator, ClientAccount accClient) {
		this.validator = validator;
		this.accClient = accClient;
	}
	
	@GET
	public Response getUsers() {
		// Returns all users.
		return Response.ok(AccountsDB.getUsers()).build();
	}
	
	@GET
	@Path("/{userId}")
	public Response getUserById(@PathParam("userId") Integer id ) {
		
		User user = AccountsDB.getUser(id);
		if(user != null) {
			return Response.ok(user).build();
		}else {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
	
	@POST
	public Response create(User user) throws URISyntaxException	{
		 Set<ConstraintViolation<User>> violations = validator.validate(user);
	        User u = AccountsDB.getUser(user.getUserId());
	        if (violations.size() > 0) {
	            ArrayList<String> validationMessages = new ArrayList<String>();
	            for (ConstraintViolation<User> violation : violations) {
	                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
	            }
	            return Response.status(Response.Status.BAD_REQUEST).entity(validationMessages).build();
	        }
	        if (u == null) {
	            //client.hash(userId, password);;
	            AccountsDB.create(user.getUserId(), user);

	            return Response.created(new URI("/users/" + user.getUserId()))
	                    .build();
	        } else
	            return Response.status(Status.NOT_FOUND).build();

	    }

}