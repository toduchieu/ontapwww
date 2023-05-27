package edu.iuh.ktpm.services;

import edu.iuh.ktpm.entities.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> getAllProject();
    public Project addProject(Project project);
    public Project deleteProject(Project project);
    public Project updateProject(Project project, String id);
    public Project findProjectById(String id);
}
