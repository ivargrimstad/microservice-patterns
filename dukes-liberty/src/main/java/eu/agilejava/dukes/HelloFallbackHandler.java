/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.agilejava.dukes;

import javax.enterprise.context.Dependent;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

/**
 *
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Dependent
public class HelloFallbackHandler implements FallbackHandler<Response> {

    @Override
    public Response handle(ExecutionContext ec) {
        return Response.ok("I'm sorry. Can't count...").build();
    }
}
