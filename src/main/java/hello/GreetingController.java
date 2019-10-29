package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GreetingController {
	//static Logger logger = Loger.getLogger(GreetingController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass()); //LoggerFactory.getLogger(GreetingController.class);
	
    private static String template = "Hello from REST API, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@RequestMapping("/greeting")
    @RequestMapping(
    		value = "/greeting", 
    		method = RequestMethod.GET, 
    		produces = "application/json"
    )
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	log.info("==== TEST Loggong 1 info ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    /**
     * This changes the greeting message by passeing a new phrase as a query parameter: 
     * localhost:9090/changeGreeting?phrase=HelloThere
     */
    @RequestMapping(
    		value = "/changeGreeting", 
    		method = RequestMethod.PUT, 
    		produces = "application/json"
    )
    public Greeting changeGreeting( @RequestParam(value="phrase", defaultValue="Default Greeting") String phrase) {
    	log.info("==== TEST Loggong 2 info====");
        template = phrase+", %s!";
        Greeting gr = new Greeting(counter.incrementAndGet(), String.format(template, "Man"));
        System.out.println("---- GreetingController::changeGreeting returns = "+gr.getContent());
        return gr;
    }
    
    
     //	consumes = MediaType.APPLICATION_JSON_VALUE
      //@PutMapping("/employees/{id}")
      //Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    /**
     * This changes greeting again as a PUT request but passes new greeting message in the RequestBody 
     * @param JSON representation of ChangeGreetingModel salut
     * @return Greeting object
     */
    @RequestMapping(
    		value = "/changeGreetings", 
    		method = RequestMethod.PUT, 
    		produces = "application/json",
    		consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Greeting changeGreetings( @RequestBody ChangeGreetingModel salut ) {
    	log.info("==== TEST Loggong 3 info====");
    	  	//Get it from Request Body if available
        	if(salut != null) {
        		template = salut.getStatement()+", %s!";
        	}     
        Greeting gr = new Greeting(counter.incrementAndGet(), String.format(template, "Man"));
        System.out.println("---- GreetingController::changeGreeting returns = "+gr.getContent());
        return gr;
    }
     
}