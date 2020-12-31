package com.cxcs.manger.controller;

import com.cxcs.manger.entity.User;
import com.cxcs.manger.service.IUserService;
import com.cxcs.manger.service.impl.UserService;
import com.cxcs.manger.vo.CommonException;
import com.cxcs.manger.vo.CommonRequest;
import com.cxcs.manger.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public CommonResponse<List<User>> getAllUsers(){
        // TODO: 2020/12/29 分页处理
        return  userService.getAllUsers();

    }


    @PostMapping("")
    public CommonResponse<List<User>> query(@RequestBody CommonRequest<User> commonRequest)  {
        commonRequest.setOrderId(String.valueOf(System.currentTimeMillis()));
        User user = commonRequest.getParam();
        if(user.getId()<0){
            log.info("输入的用户ID【"+user.getId()+"】不合规");
            throw new CommonException("500","id is 1");
        }
        return userService.query(user);
    }


    @PutMapping("")
    public CommonResponse<Integer> addUser(@RequestBody CommonRequest<User> commonRequest){
        commonRequest.setOrderId(String.valueOf(System.currentTimeMillis()));
        return userService.addtUser(commonRequest.getParam());
    }


    @DeleteMapping("/{id}")
    public CommonResponse<Integer> deleteUser(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }


}
