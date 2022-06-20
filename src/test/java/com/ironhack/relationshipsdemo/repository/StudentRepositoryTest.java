package com.ironhack.relationshipsdemo.repository;

import com.ironhack.relationshipsdemo.enums.House;
import com.ironhack.relationshipsdemo.enums.Wing;
import com.ironhack.relationshipsdemo.model.HouseAssignment;
import com.ironhack.relationshipsdemo.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private HouseAssignmentRepository houseAssignmentRepository;

    private Student harry, draco;
    private HouseAssignment harryAssignment, dracoAssignment;
    @BeforeEach
    void setUp() {
        harryAssignment = new HouseAssignment(House.GRYFFINDOR, Wing.EAST, 1050);
        dracoAssignment = new HouseAssignment(House.SLYTHERIN, Wing.WEST, 55);

//        houseAssignmentRepository.save(harryAssignment);
//        houseAssignmentRepository.save(dracoAssignment);

        harry = new Student("Harry", "Potter");
        harry.setHouseAssignment(harryAssignment);
        draco = new Student("Draco", "Malfoy");
        draco.setHouseAssignment(dracoAssignment);

        studentRepository.save(harry);
        studentRepository.save(draco);

    }

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
//        houseAssignmentRepository.deleteAll();
    }

    @Test
    void findById_harryId_harry() {
        Optional<Student> optionalHarry = studentRepository.findById(harry.getId());
        assertTrue(optionalHarry.isPresent());
        assertEquals("Harry", optionalHarry.get().getFirstName());
        assertEquals(House.GRYFFINDOR, optionalHarry.get().getHouseAssignment().getHouse());

    }


}