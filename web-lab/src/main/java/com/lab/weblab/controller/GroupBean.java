package com.lab.weblab.controller;


import com.lab.weblab.model.GroupEntity;
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
public class GroupBean  {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentBean departmentBean;

    @Getter
    @Setter
    private GroupEntity group = new GroupEntity();

    ArrayList<GroupEntity> groupEntityArrayList = new ArrayList<GroupEntity>();
    private List<GroupEntity> rolesList;

    public void save() {
        try {
            this.userService.save(group);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void create() {
        group = new GroupEntity();
    }


}


