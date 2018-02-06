package com.va.content.controller;

import com.va.content.models.User;
import com.va.content.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by eli on 2/1/2018.
 */
@EnableAutoConfiguration
@RestController
public class VAController {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserService userService;

    @GetMapping(path = "/status", produces = "text/plain")
    public String test() {return "The service is running";}

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String add(User user) throws Exception {
        logger.info("Call to register new user: {}", user);
        user.setUsername(user.getUsername().toLowerCase().trim());
        user.setEnabled(0);
        logger.info("Registering user: {}", user);
        User createdUser = userService.createUser(user);
        return "saved";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginView() {

        //return back to index.jsp
        ModelAndView model = new ModelAndView("login");

        return model;

    }


//        @GetMapping(path="/all")
//    public @ResponseBody
//        Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return userRepository.findAll();
//    }







}
