@RestController
class Example {
    @RequestMapping("/helloGroovy")
    @ResponseBody
    public String hello() {
        "Hello World from Groovy"
    }
}