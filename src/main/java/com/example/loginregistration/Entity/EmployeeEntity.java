package com.example.loginregistration.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class EmployeeEntity {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeID;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "employee_email")
    private String email;
    @Column(name = "employee_password")
    private String password;

    public EmployeeEntity(int employeeID, String employeeName, String email, String password) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.email = email;
        this.password = password;
    }

    public EmployeeEntity() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
