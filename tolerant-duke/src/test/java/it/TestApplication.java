package it;

import org.junit.Test;

public class TestApplication extends EndpointTest {

    @Test
    public void testDeployment() {
        testEndpoint("/index.html", "<h1>Welcome to your Liberty Application</h1>");
    }

}
