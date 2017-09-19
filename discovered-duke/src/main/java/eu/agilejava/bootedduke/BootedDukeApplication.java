package eu.agilejava.bootedduke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BootedDukeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootedDukeApplication.class, args);
	}
}
