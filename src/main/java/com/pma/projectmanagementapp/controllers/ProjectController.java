package com.pma.projectmanagementapp.controllers;

import com.pma.projectmanagementapp.dao.ProjectRepository;
import com.pma.projectmanagementapp.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @GetMapping("/new")
    public String displayProjectFrom(Model model){
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        proRepo.save(project);
        //use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }

    @GetMapping("/current-projects")
    public String currentProjects(Model model){
        List<Project> projectsList = proRepo.findAll();
        model.addAttribute("projectsList", projectsList);
        return "/projects/current-projects";
    }
}
