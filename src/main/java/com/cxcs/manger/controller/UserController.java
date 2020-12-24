package com.cxcs.manger.controller;

import com.cxcs.manger.entity.User;
import com.cxcs.manger.service.IUserService;
import com.cxcs.manger.service.impl.UserService;
import com.cxcs.manger.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ResponseBody
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/users")
    public CommonResponse<List<User>> getAllUsers(){
        return  userService.getAllUsers();
    }
    @PostMapping("/user/query")
    public CommonResponse<List<User>> query(@RequestBody User user){
        return userService.query(user);
    }
    @PutMapping("/user")
    public CommonResponse<Integer> addUser(User user){
        return userService.addtUser(user);
    }
    @DeleteMapping("/user/{id}")
    public CommonResponse<Integer> deleteUser(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }


}
