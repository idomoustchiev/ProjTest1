@Problem
The mvn build "mvn package" fails with:
"package org.springframework.boot.test.context does not exist"
@Solution:
The problem is in your dependency, remove test scope <scope>test</scope> from it:
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
         <scope>test</scope>  <----- //Remove
    </dependency>
 
 ---------------------------------------------------------------------------------------------------------------------
 
    
@Problem
When creating a PUT controller, POSTMAN request fails with:
"HTTP-415"
    
@Solution
Problem was that POSTMAN should have header Content-type: application/json also 'consume=MediaType.APPLICATION_JSON_VALUE' must be specified:
   
    @RequestMapping(
    		value = "/changeGreetings", 
    		method = RequestMethod.PUT, 
    		produces = "application/json",
    		consumes = MediaType.APPLICATION_JSON_VALUE  <---- Must be here
    )
    public Greeting changeGreetings( @RequestBody ChangeGreetingModel salut ) 
    
 May use @PutMapping("/employees/{id}") annotation which is a wrapper for @RequestMapping
 
 
 ------------------------------------------------------------------------------------------------------------------------
 
 @Problem
 How to send the PUT request from curl as POSTMAN consumes 170MB of RAM ?
 
 @Solution:
 curl -i -X PUT  http://localhost:9090/changeGreetings -H "content-type: application/json" -d "{\"statement\": \"Hey from Curl\", \"date\": \"2019-05-10\"}"
 
 -------------------------------------------------------------------------------------------------------------------------
 
 @Problem:
 Eclipse underlines some symbols with RED color even though they exist
 
 @Solution:
 Highlight the project name, Go to "Projects" on main bar and pick "Clean"
 
 
 
 TODO:
 -- integrate with GitHub and upload my project
 -- learn how to use @Component and create actual services - @Service, @Repository, and @Controller are specializations of @Component. 
    Same as @Bean. To be managed by Spring container during configuration stage.
 -- learn how to run inside Docker
 
 
 
 Java Threads and syncronization:
 Syncronized method lock on this, while synchronized block can lock on any object.
 Java has no mutes, use semaphore of count 1 like: Semaphore s = new Semaphore(1);
 Thread can be created by 