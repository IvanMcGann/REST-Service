package ie.gmit.ds;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {

List<User> user = Arrays.asList(new User(1, "The Test", "Sample", "test", "example"));


    @GET
    public List<User> getArtists() {
        return user;
    }

}