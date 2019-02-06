package com.lab.weblab.dao.student.impl;

import com.lab.weblab.dao.base.impl.GenericDAOImpl;
import com.lab.weblab.dao.student.StudentDao;
import org.springframework.stereotype.Repository;

@Repository(value = "studentDao")
public class StudentDaoImpl  extends GenericDAOImpl implements StudentDao
{

}
