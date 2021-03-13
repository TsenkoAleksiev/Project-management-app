package com.pma.projectmanagementapp.controllers;

import com.pma.projectmanagementapp.dao.EmployeeRepository;
import com.pma.projectmanagementapp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        empRepo.save(employee);
        return "redirect:/employees/new";
    }

    @GetMapping("/current-employees")
    public String currentEmployees(Model model){
        List<Employee> employeesList = empRepo.findAll();
        model.addAttribute("employeesList", employeesList);
        return "employees/current-employees";
    }
}
