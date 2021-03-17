package com.pma.projectmanagementapp.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;

    private String name;
    private String stage;
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name="project_employee",
                joinColumns=@JoinColumn(name="project_id"),
                inverseJoinColumns = @JoinColumn(name="employee_id"))
    private List<Employee> employees;

    public Project() {
    }

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Project setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    public long getProjectId() {
        return projectId;
    }

    public Project setProjectId(long projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getStage() {
        return stage;
    }

    public Project setStage(String stage) {
        this.stage = stage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public void addEmployee(Employee emp){
        if(employees == null) employees = new ArrayList<Employee>();
        employees.add(emp);
    }
}
