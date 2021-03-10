package stackstock.greet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final GreetingProps props;

    public GreetingController(GreetingProps props) {
        this.props = props;
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/hello")
    public String message() {
        return props.getMessage();
    }
}
