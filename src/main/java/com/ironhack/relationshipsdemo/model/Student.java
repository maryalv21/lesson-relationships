package com.ironhack.relationshipsdemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
//            id BIGINT NOT NULL AUTO_INCREMENT,
//            first_name VARCHAR(255),
//    last_name VARCHAR(255),
//    house_assignment_id BIGINT,
//    PRIMARY KEY(id),
//    FOREIGN KEY(house_assignment_id) REFERENCES house_assignment(id)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL) // relación es one to one
    @JoinColumn(name = "house_assignment_id") // solamente si la fk es distinto a house_assignment_id
    private HouseAssignment houseAssignment; // house_assignment_id

    @ManyToOne
    @JoinColumn(name = "prefect_id")
    private Prefect prefect;

    @ManyToMany
    @JoinTable(name ="students_spell", joinColumns = {@JoinColumn(name = "student_id")},
    inverseJoinColumns = {@JoinColumn(name = "spell_id")})
    private List <Spell> spellList;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public HouseAssignment getHouseAssignment() {
        return houseAssignment;
    }

    public void setHouseAssignment(HouseAssignment houseAssignment) {
        this.houseAssignment = houseAssignment;
    }

    public Prefect getPrefect() {
        return prefect;
    }

    public void setPrefect(Prefect prefect) {
        this.prefect = prefect;
    }
}
