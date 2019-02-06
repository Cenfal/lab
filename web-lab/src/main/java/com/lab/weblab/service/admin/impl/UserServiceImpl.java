package com.lab.weblab.service.admin.impl;

import com.lab.weblab.dao.base.GenericDAO;
import com.lab.weblab.service.admin.UserService;
import com.lab.weblab.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService
{
    @Override
    protected GenericDAO getDAO() {
        return null;
    }
}
