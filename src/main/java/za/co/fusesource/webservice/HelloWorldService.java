package za.co.fusesource.webservice;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/02/15.
 */

@Controller
@RequestMapping("service")
public class HelloWorldService {

    public static final String HELLO_SERVICE_ENDPOINT = "direct://hello";
    public static final String HELLO_ROUTE_ID = "HelloRoute";

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private CamelContext camelContext;

    @PostMapping(value = "/hello", consumes = {MediaType.TEXT_PLAIN_VALUE}, produces = {MediaType.TEXT_PLAIN_VALUE})
    @ResponseBody
    public ResponseEntity<?> hello(final HttpServletRequest request, @RequestBody String requestBody) {


        final Exchange requestExchange  = ExchangeBuilder.anExchange(camelContext).withBody(requestBody).build();
        System.out.println(">>>>>>>>>>>>>>> "+requestExchange.getIn().getBody().toString());
        final Exchange responseExchanger = producerTemplate.send(HELLO_SERVICE_ENDPOINT,requestExchange);
        String responseBddy = responseExchanger.getOut().getBody(String.class);
        return ResponseEntity.status(HttpStatus.OK).body(responseBddy);
    }
}
