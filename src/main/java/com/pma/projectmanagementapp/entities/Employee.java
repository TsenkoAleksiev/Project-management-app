package com.pma.projectmanagementapp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
               fetch = FetchType.LAZY)
    @JoinTable(name="project_employee",
            joinColumns=@JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name="project_id"))
    private List<Project> projects;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Employee setProjects(List<Project> projects) {
        this.projects = projects;
        return this;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public Employee setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }
}
