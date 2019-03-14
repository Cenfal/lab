package com.lab.weblab.controller;

import com.lab.weblab.model.DepartmentEntity;
import com.lab.weblab.service.admin.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.List;


@Component
@Scope(value="session")
@ManagedBean(name = "departmentBean")
public class DepartmentBean
{
    @Autowired
    private UserService userService;

    @Getter
    @Setter
    private DepartmentEntity department = new DepartmentEntity();


    @Getter
    @Setter
    private List<String> departments;





    public void save()
    {
        try
        {
            this.userService.save(department);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void create()
    {
        department = new DepartmentEntity();
    }
}
