package com.lab.weblab.controller;


import com.lab.weblab.model.StudentEntity;
import com.lab.weblab.service.student.StudentService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


@ViewScoped
@ManagedBean(value = "studentBean")
public class StudentBean
{

    @Setter
    @ManagedProperty("#{studentService}")
    private StudentService studentService;

    @Getter @Setter
    private StudentEntity student = new StudentEntity();

    public void save(StudentEntity student)
    {
        try
        {
            this.studentService.save(student);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

