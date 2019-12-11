package com.shibo.service;

import com.shibo.pojo.TbUsers;
import com.shibo.pojo.TbUsersExample;

import java.util.List;

public interface UserService {
    int insert(TbUsers record);
    int deleteByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(TbUsers record);
    List<TbUsers> selectAll();
    List<TbUsers> selectByExample(TbUsersExample example);
    TbUsers selectByPrimaryKey(Long id);
}
