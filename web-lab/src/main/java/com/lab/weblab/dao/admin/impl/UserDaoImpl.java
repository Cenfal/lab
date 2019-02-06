package com.lab.weblab.dao.admin.impl;


import com.lab.weblab.dao.base.impl.GenericDAOImpl;
import com.lab.weblab.dao.admin.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl extends GenericDAOImpl implements UserDao
{
}
