package com.bkap.Entity;

import javax.persistence.*;


@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public EmployeeEntity() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
