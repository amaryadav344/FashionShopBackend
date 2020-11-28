package com.fashionshop.backend.Controllers;

import java.security.Principal;

import com.fashionshop.backend.Util.CustomErrorType;
import com.fashionshop.backend.DTO.User;
import com.fashionshop.backend.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("account")
public class AccountController {

    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // request method to create a new account by a guest
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        if (userService.find(newUser.getUsername()) != null) {
            logger.error("username Already exist " + newUser.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
                    HttpStatus.CONFLICT);
        }
        newUser.setRole("USER");

        return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
    }

    // this is the login api/service
    @CrossOrigin
    @RequestMapping("/login")
    public ResponseEntity<?> user(Principal principal) {
        logger.info("user logged " + principal);
        User user = userService.find(principal.getName());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
