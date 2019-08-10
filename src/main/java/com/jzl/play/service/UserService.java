package com.jzl.play.service;

import com.jzl.play.model.User;

import java.util.List;

public interface UserService {
    List<User> selectUsers(User user);

    int updateUser(User user);
}
