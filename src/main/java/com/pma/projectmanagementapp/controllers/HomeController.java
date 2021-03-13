package com.pma.projectmanagementapp.controllers;

import com.pma.projectmanagementapp.dao.EmployeeRepository;
import com.pma.projectmanagementapp.dao.ProjectRepository;
import com.pma.projectmanagementapp.entities.Employee;
import com.pma.projectmanagementapp.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Project> projects = proRepo.findAll();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        return "main/home";
    }
}
