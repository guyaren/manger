package com.cxcs.manger.dao;

import com.cxcs.manger.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "username", column = "name"),
//            @Result(property = "password", column = "pwd")
//    })
//    @Select("select id as id,name as username,pwd as password from user_t")
    List<User> getAllUsers();

    List<User> query(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);


}
