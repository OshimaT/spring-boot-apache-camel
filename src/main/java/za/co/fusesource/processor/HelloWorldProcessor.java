package za.co.fusesource.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.http.HttpStatus;


/**
 * Created by Peter Tlholoe (f5238390) on 2018/02/15.
 */
public class HelloWorldProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Am in here >>>>>>>>>>>>>>");
        final String body = exchange.getIn().getBody(String.class);
        exchange.getOut().setBody("Hello from camel processed message! Received payload: " + body);
        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, HttpStatus.ACCEPTED);
    }
}
