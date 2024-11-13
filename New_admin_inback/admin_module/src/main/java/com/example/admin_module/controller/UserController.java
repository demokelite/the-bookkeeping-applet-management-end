package com.example.admin_module.controller;

import com.example.admin_module.entity.User;
import com.example.admin_module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/info",produces = {"application/json;charset=UTF-8"})
    public List<User> listUserInfo(){
        return userService.listUser();
    }

    @GetMapping(value = "/info{id}",produces = {"application/json;charset=UTF-8"})
    public User userInfoById(@PathVariable (value = "id")Integer id){
        return userService.selectUserById(id);
    }

    @PostMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    public void addUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @PostMapping(value = "/remove/{id}",produces = {"application/json;charset=UTF-8"})
    public void removeUser(@PathVariable ("id")Integer id){
        userService.deleteUserById(id);
    }

    @PostMapping(value = "/edit",produces = {"application/json;charset=UTF-8"})
    public void removeUser(@RequestBody User user){
        userService.updateUser(user);
    }
}
