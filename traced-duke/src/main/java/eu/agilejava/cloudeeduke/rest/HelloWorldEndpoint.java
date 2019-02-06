package eu.agilejava.cloudeeduke.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.opentracing.Traced;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("hello")
@RequestScoped
@Traced
public class HelloWorldEndpoint {

    @Inject
    @ConfigProperty(name = "place", defaultValue = "World")
    private String place;

    @GET
    public Response greet() {
        return Response.ok("Hello " + place + "!").build();
    }

}