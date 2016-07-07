package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Igor on 24.06.2016.
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/")
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable() String player) {//REST Endpoint.

        Message msg = new Message(player, "Hello " + player);
        return msg;
    }

    @RequestMapping("/hello")
    public Message wow(@PathVariable String player) {//REST Endpoint.

        Message msg = new Message(player, "Hello " + player);
        return msg;
    }

}
