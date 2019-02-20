package com.lab.weblab.model;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student", schema = "mydb")
@ToString( of = "id")
@EqualsAndHashCode(of = "id")
public class StudentEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "STUDENT_ID", nullable = false)
    private Integer studentId;

    @Basic
    @Column(name = "STUDENTNUMBER", nullable = true)
    private Integer studentnumber;

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 45)
    private String password;

    @Basic
    @Column(name = "NAME", nullable = true, length = 45)
    private String name;

    @Basic
    @Column(name = "SURNAME", nullable = true, length = 30)
    private String surname;

    @Basic
    @Column(name = "TITLE", nullable = true, length = 25)
    private String title;

    @Basic
    @Column(name = "DEPARTMENT_ID", nullable = true)
    private Integer departmentId;



    }




