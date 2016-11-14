package beer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import beer.Beer;
import beer.service.RedisService;

@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/redis/set")
    public void send(@RequestParam(value="key", defaultValue="beer") String key,@RequestParam(value="value", defaultValue="I.P.A") String value) {
        redisService.setValue(key, value);
    }

    @RequestMapping("/redis/get")
    public Beer send(@RequestParam(value="key", defaultValue="beer") String key) {
        return new Beer(1l,(String) redisService.getValue(key));
    }

}
