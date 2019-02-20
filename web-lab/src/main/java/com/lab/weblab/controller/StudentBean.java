package com.lab.weblab.controller;


import com.lab.weblab.model.StudentEntity;
import com.lab.weblab.service.student.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value="session")
public class StudentBean
{
    @Autowired
    private StudentService studentService;

    @Getter @Setter
    private StudentEntity student = new StudentEntity();

    public void save()
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

