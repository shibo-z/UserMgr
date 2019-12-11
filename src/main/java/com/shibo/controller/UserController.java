package com.shibo.controller;

import com.shibo.pojo.TbUsers;
import com.shibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shibo
 * @createTime 2019-12-11 23:25
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    @ResponseBody
    public Object insertUser(TbUsers user){
        int res = userService.insert(user);
        return res;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object deleteUser(Long id){
        int res = userService.deleteByPrimaryKey(id);
        return res;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object updateUser(TbUsers user){
        int res = userService.updateByPrimaryKeySelective(user);
        return res;
    }

    @RequestMapping("/select/all")
    @ResponseBody
    public Object selectAllUser(){
        List<TbUsers> tbUsers = userService.selectAll();
        return tbUsers;
    }
}
