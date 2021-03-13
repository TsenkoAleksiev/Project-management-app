package com.pma.projectmanagementapp.dao;

import com.pma.projectmanagementapp.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();
}
