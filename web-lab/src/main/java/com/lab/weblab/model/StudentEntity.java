package com.lab.weblab.model;

import com.lab.weblab.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student", schema = "mydb")
@ToString( of = "id")
@EqualsAndHashCode(of = "id")
public class StudentEntity extends BaseEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "STUDENT_ID", nullable = false)
    private Integer studentId;

    @Column(name = "STUDENTNUMBER", nullable = true)
    private Integer studentnumber;

    @Column(name = "PASSWORD", nullable = true, length = 45)
    private String password;

    @Column(name = "NAME", nullable = true, length = 45)
    private String name;

    @Column(name = "SURNAME", nullable = true, length = 30)
    private String surname;

    @Column(name = "TITLE", nullable = true, length = 25)
    private String title;

    @Column(name = "DEPARTMENT_ID", nullable = true)
    private Integer departmentId;

    }




