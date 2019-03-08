package eu.agilejava.cloudeeduke.birthday;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("birthday")
@Dependent
@RegisterRestClient
public interface BirthdayService {

    @GET
    Integer daysToBirthday(@QueryParam("date") String date);
}