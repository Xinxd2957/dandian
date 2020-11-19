package com.system.demo.service;


import com.system.demo.model.User;

import java.util.List;

public interface IUserService   {

    List<User>  listUserName(String name);

    List<User>  listUser();

    int addUser(User user);

    int updateUser(User user);

    int delUser(Long id);

}
