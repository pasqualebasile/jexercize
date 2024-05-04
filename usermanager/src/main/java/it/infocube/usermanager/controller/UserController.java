package it.infocube.usermanager.controller;

import it.infocube.usermanager.dto.UserRolesDto;
import it.infocube.usermanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import it.infocube.usermanager.repository.UserRepository;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{Id}")
    public @ResponseBody UserRolesDto getUser(@PathVariable("Id") Long id) {
        return userService.getUserRoles(id);
    }

}
