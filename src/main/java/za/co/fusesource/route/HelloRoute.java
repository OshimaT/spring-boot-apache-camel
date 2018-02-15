package za.co.fusesource.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import za.co.fusesource.processor.HelloWorldProcessor;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/02/15.
 */
@Component
public class HelloRoute extends RouteBuilder {

    public static final String HELLO_SERVICE_ENDPOINT = "direct://hello";
    public static final String HELLO_ROUTE_ID = "HelloRoute";

    @Override
    public void configure() throws Exception {
        from(HELLO_SERVICE_ENDPOINT)
                .id(HELLO_ROUTE_ID)
                .log("I'm in the Camel Route!")
                .process(new HelloWorldProcessor());
    }

}
