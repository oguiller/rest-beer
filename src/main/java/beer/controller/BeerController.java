package beer.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import beer.Beer;

@RestController
public class BeerController {

    private static final String template = "Beer Type is: %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/beer")
    public Beer beer(@RequestParam(value="type", defaultValue="I.P.A") String type) {
        return new Beer(counter.incrementAndGet(),
                            String.format(template, type));
    }
}
