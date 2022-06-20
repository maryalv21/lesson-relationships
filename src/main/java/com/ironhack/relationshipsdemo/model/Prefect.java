package com.ironhack.relationshipsdemo.model;

import com.ironhack.relationshipsdemo.enums.House;

import javax.persistence.*;
import java.util.List;

@Entity
public class Prefect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private House house;
//    @OneToMany(mappedBy = "prefect", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  // MAPPED BY -> Significa que la relación YA está mapeada del otro lado. Usa ESA relación
    @OneToMany(mappedBy = "prefect", cascade = CascadeType.ALL)
    private List<Student> students;

    public Prefect() {
    }

    public Prefect(String firstName, String lastName, House house) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.house = house;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
