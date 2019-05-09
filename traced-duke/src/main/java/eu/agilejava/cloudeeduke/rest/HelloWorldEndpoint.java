package eu.agilejava.cloudeeduke.rest;

import eu.agilejava.cloudeeduke.birthday.BirthdayService;
import io.opentracing.Scope;
import io.opentracing.Tracer;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("hello")
@RequestScoped
@Traced
public class HelloWorldEndpoint {

    @Inject
    @ConfigProperty(name = "place", defaultValue = "World")
    private String place;

    @Inject
    @RestClient
    private BirthdayService birthdayService;

    @Inject
    Tracer tracer;

    @GET
    public Response greet() throws URISyntaxException {

        try (Scope childScope = tracer.buildSpan("call birthdayService")
                .startActive(true)) {

            System.out.println(birthdayService.daysToBirthday("1973-01-25"));

        }

        return Response.ok("Hello " + place + "!").build();
    }

}