package com.cxcs.manger.service;

import com.cxcs.manger.entity.User;
import com.cxcs.manger.vo.CommonResponse;

import java.util.List;

public interface IUserService {
    CommonResponse<List<User>> getAllUsers();
    CommonResponse<List<User>> query(User user);
    CommonResponse<Integer> addtUser(User user);
    CommonResponse<Integer> updateUser(User user);
    CommonResponse<Integer> deleteUser(Integer id);

}
