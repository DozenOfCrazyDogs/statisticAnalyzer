package statisticanalyzer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import statisticanalyzer.domain.Message;

/**
 * Created by Igor on 24.06.2016.
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/main/")
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping("/main/hello/{player}")
    public Message message(@PathVariable String player) {//REST Endpoint.

        Message msg = new Message(player, "Hello " + player);
        return msg;
    }

    @RequestMapping("/main/hello")
    public Message wow(@PathVariable String player) {

        Message msg = new Message(player, "Hello " + player);
        return msg;
    }

    @RequestMapping("/main/matrix")
    public double[][] returnMatrix() {//REST Endpoint.
        return new double[][]{{0, 1, 3}, {2, 3, 5}};
    }

}
