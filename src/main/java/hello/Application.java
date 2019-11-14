package hello;

import  java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * SpringApplication Class can be used to bootstrap and launch a Spring application from a Java main method. 
	 * By default class will perform the following steps to bootstrap yourapplication: 
		--Create an appropriate ApplicationContext instance (depending on yourclasspath)
		--Register a CommandLinePropertySource to expose command line arguments asSpring properties
		--Refresh the application context, loading all singleton beans
		--Trigger any CommandLineRunner beans
	 */
    public static void main(String[] args) { //Application, REST, etc
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");
            log.info("----- Logger logged this---- ");	
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            log.warn("----- Logger logged this warning ---- ");
            log.debug("----- Logger logged this debug ---- ");
        };
    }

}