package edu.iuh.ktpm.repositories;

import edu.iuh.ktpm.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,String> {
}
