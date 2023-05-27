package edu.iuh.ktpm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AssignmentKey implements Serializable {
    @Column(name = "idProject")
    private String idProject;

    @Column(name = "idEmployee")
    private String idEmployee;

    public AssignmentKey() {
    }

    public AssignmentKey(String idProject, String idEmployee) {
        this.idProject = idProject;
        this.idEmployee = idEmployee;
    }
}
