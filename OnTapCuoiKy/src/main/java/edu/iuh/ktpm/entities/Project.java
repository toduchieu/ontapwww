package edu.iuh.ktpm.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "budget")
    private double budget;

    @Column(name = "department")
    private String department;

    @Column(name = "location")
    private String location;

    @Column(name = "name")
    private String name;

    @Column(name = "startDate")
    private Date startDate;

    @OneToMany(mappedBy = "project")
    private List<Assignment> assignments;

    public Project() {
    }

    public Project(String id, double budget, String department, String location, String name, Date startDate, List<Assignment> assignments) {
        this.id = id;
        this.budget = budget;
        this.department = department;
        this.location = location;
        this.name = name;
        this.startDate = startDate;
        this.assignments = assignments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
