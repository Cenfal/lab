package com.lab.weblab.service.student.impl;

import com.lab.weblab.dao.base.GenericDAO;
import com.lab.weblab.dao.student.StudentDao;
import com.lab.weblab.service.base.impl.BaseServiceImpl;
import com.lab.weblab.service.student.StudentService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "studentService")
public class StudentServiceImpl extends BaseServiceImpl implements StudentService
{
    @Setter
    @Autowired
    private StudentDao studentDao;

    @Override
    protected GenericDAO getDAO()
    {
        return studentDao;
    }
}
