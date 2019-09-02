package com.jzl.play.service;

import com.jzl.play.model.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface UserService {
    Integer save(User user);

    User selectById(Integer id);

    List<User> selectByName(String name);

    List<User> selectUsers(User user);

    int updateUser(User user);

    int delete(Integer id);
}
