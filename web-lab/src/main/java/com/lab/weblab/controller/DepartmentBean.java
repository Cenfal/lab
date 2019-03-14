package com.lab.weblab.controller;

import com.lab.weblab.model.DepartmentEntity;
import com.lab.weblab.service.admin.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(value="session")
public class DepartmentBean
{
    @Autowired
    private UserService userService;

    @Getter
    @Setter
    private DepartmentEntity department = new DepartmentEntity();
    @Getter
    @Setter
    ArrayList<DepartmentEntity> departmentEntityArrayList = new ArrayList<DepartmentEntity>();
    @Getter
    @Setter
    public List<DepartmentEntity> departmentEntityList;

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
