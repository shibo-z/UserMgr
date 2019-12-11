package com.shibo.service.impl;

import com.shibo.mapper.TbUsersMapper;
import com.shibo.pojo.TbUsers;
import com.shibo.pojo.TbUsersExample;
import com.shibo.service.UserService;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shibo
 * @createTime 2019-12-11 23:22
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUsersMapper usersMapper;
    @Override
    public int insert(TbUsers record) {
        return usersMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbUsers record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TbUsers> selectAll() {
        return usersMapper.selectAll();
    }

    @Override
    public List<TbUsers> selectByExample(TbUsersExample example) {
        return usersMapper.selectByExample(example);
    }

    @Override
    public TbUsers selectByPrimaryKey(Long id) {
        return usersMapper.selectByPrimaryKey(id);
    }
}
