package eu.agilejava.cloudeeduke.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("hello")
@RequestScoped
public class HelloWorldEndpoint {

    @Inject
    @ConfigProperty(name = "message", defaultValue = "Hello")
    private String message;

    @Inject
    private JsonWebToken token;

    @GET
    @Produces("text/plain")
    @Metered
    @RolesAllowed({ "admin" })
    public Response doGet() {

        final String greeting = String.format("Duke says %s to %s with role %s. Token issued by %s!",
                message,
                token.getSubject(),
                token.getGroups(),
                token.getIssuer());

        return Response.ok(greeting).build();
    }
}