package com.lab.weblab.model;

import com.lab.weblab.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"departmentId"})
@EqualsAndHashCode(of = {"departmentId"})
@Entity
@Table(name = "department", schema = "mydb")
public class DepartmentEntity extends BaseEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "DEPARTMENT_ID", nullable = false)
    private Integer departmentId;

    @Column(name = "DESCRIPTION", nullable = true, length = 100)
    private String description;
}
