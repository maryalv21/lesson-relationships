package com.ironhack.relationshipsdemo.model;

import com.ironhack.relationshipsdemo.enums.House;
import com.ironhack.relationshipsdemo.enums.Wing;

import javax.persistence.*;

@Entity
public class HouseAssignment {
//    id BIGINT NOT NULL AUTO_INCREMENT,
//    house VARCHAR(255),
//    wing VARCHAR(255),
//    room_number INT,
//    PRIMARY KEY(id)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private House house;
    @Enumerated(EnumType.STRING)
    private Wing wing;
    private int roomNumber;
    @OneToOne(mappedBy = "houseAssignment")
    private Student student;

    public HouseAssignment() {
    }

    public HouseAssignment(House house, Wing wing, int roomNumber) {
        this.house = house;
        this.wing = wing;
        this.roomNumber = roomNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Wing getWing() {
        return wing;
    }

    public void setWing(Wing wing) {
        this.wing = wing;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
