package za.co.fusesource.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Peter Tlholoe (f5238390) on 2018/02/15.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "za.co.fusesource")
public class HelloWorldServiceLauncher {


    public static void main(String[] args) {
        SpringApplication.run(HelloWorldServiceLauncher.class, args);
    }

}
