/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.agilejava.dukes;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

/**
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Liveness
@ApplicationScoped
public class DukeAlive implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("successful-check")
                .up()
                .withData("Duke", "Alive!")
                .build();
    }
}
