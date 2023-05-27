package edu.iuh.ktpm.services.impl;

import edu.iuh.ktpm.entities.Project;
import edu.iuh.ktpm.repositories.ProjectRepository;
import edu.iuh.ktpm.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }
    @Override
    public List<Project> getAllProject() {
        ArrayList<Project> projects = (ArrayList<Project>) projectRepository.findAll();
        return projects;
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project deleteProject(Project project) {
        projectRepository.delete(project);
        return project;
    }

    @Override
    public Project updateProject(Project project, String id) {
        return null;
    }

    @Override
    public Project findProjectById(String id) {
        return projectRepository.findById(id).orElse(null);
    }
}
