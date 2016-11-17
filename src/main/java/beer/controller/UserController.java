package beer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import beer.entity.User;
import beer.service.UserService;

/**
 * We are creating a resource User.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody User persist(@RequestParam(value = "username", defaultValue = "xile") String username, @RequestParam(value = "password", defaultValue = "abcd1234") String password) {
        User user = new User(username, password);
        return userService.save(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<User> get(@RequestParam(value = "username", defaultValue = "xile") String username) {
        return userService.findByUserName(username);
    }
}
