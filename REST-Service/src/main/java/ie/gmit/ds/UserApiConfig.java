package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class UserApiConfig extends Configuration {
//    @NotEmpty
    private int port;

    @JsonProperty
    public int getPort() {
        return port;
    }
}