package it.infocube.usermanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import it.infocube.usermanager.repository.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/users") // This means URL's starting with  /users (after Application path)
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/{Id}")
    public @ResponseBody String getUser(@PathVariable("Id") Long id) {
        return userRepository.findById(id).toString();
    }
}
