package com.jzl.play.controller;

import com.github.pagehelper.PageInfo;
import com.jzl.play.common.Result;
import com.jzl.play.model.User;
import com.jzl.play.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zalej
 */
@RestController
@RequestMapping("/jzl/user")
@Api(tags = "用户api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("selectUser")
    @ApiOperation("查询用户")
    public Result<List<User>> selectUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        return Result.success(userService.selectUsers(user));
    }

    @PostMapping("updateUser")
    @ApiOperation("更新用户")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query", required = false),

            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "query", required = true),
    })
    public Result<Integer> updateUser(User user) {
        int effectRows = userService.updateUser(user);
        return Result.success(effectRows);
    }

}
