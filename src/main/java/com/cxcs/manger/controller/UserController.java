package com.cxcs.manger.controller;

import com.cxcs.manger.entity.User;
import com.cxcs.manger.service.IUserService;
import com.cxcs.manger.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/user")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }
}
