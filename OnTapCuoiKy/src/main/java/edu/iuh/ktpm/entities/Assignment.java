package edu.iuh.ktpm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Assignment")
public class Assignment {
    @EmbeddedId
    private AssignmentKey key;

    @ManyToOne
    @MapsId("idProject")
    @JoinColumn(name = "idProject")
    private Project project;

    @ManyToOne
    @MapsId("idEmployee")
    @JoinColumn(name = "idEmployee")
    private Employee employee;

    public Assignment() {
    }

    public Assignment(AssignmentKey key, Project project, Employee employee) {
        this.key = key;
        this.project = project;
        this.employee = employee;
    }
}
