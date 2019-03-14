package com.lab.weblab.service.admin.impl;

import com.lab.weblab.dao.admin.UserDao;
import com.lab.weblab.dao.base.GenericDAO;
import com.lab.weblab.service.admin.UserService;
import com.lab.weblab.service.base.impl.BaseServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService
{
    @Setter
    @Autowired
    private UserDao userDao;

    @Override
    protected GenericDAO getDAO()
    {
        return userDao;
    }

}
