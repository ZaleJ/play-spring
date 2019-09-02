package com.jzl.play.mapper;

import com.jzl.play.model.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zalej
 */
@Repository
public interface UserMapper extends Mapper<User> {

    int updateUser(User user);
}