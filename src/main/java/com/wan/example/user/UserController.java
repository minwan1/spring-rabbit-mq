package com.wan.example.user;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User createCustomer(@RequestBody final User user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getCustomer(@PathVariable final long id){
        return userService.findById(id);
    }
}
