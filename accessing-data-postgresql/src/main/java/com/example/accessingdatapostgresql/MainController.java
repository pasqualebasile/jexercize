package com.example.accessingdatapostgresql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);


    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/findByName/{name}")
    public @ResponseBody Iterable<User> findByName(
            @PathVariable(name = "name") String name
    ) {
        log.info("Requested /find/" + name);
        // return userRepository.findUserByName(name);
        return userRepository.findUserByNameContainingIgnoreCase(name);
    }

    /**
     * Ritorna un utente a partire dal suo ID
     * @param id    ID dell'utente
     * @return un oggetto di tipo User
     */
    @GetMapping(path="/findById/{Id}")
    public @ResponseBody User getUserById(
            @PathVariable(name = "Id") Integer id
    ) {
        log.info("Requested /findById/" + id);
        return userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato")
        );
    }

}


