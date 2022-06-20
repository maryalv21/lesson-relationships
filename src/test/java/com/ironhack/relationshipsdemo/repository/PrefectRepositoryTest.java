package com.ironhack.relationshipsdemo.repository;

import com.ironhack.relationshipsdemo.enums.House;
import com.ironhack.relationshipsdemo.enums.Wing;
import com.ironhack.relationshipsdemo.model.HouseAssignment;
import com.ironhack.relationshipsdemo.model.Prefect;
import com.ironhack.relationshipsdemo.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrefectRepositoryTest {

    @Autowired
    private PrefectRepository prefectRepository;

    @Autowired
    private StudentRepository studentRepository;

    private Student harry, draco;

    private Prefect percy;
    private HouseAssignment harryAssignment, dracoAssignment;
    @BeforeEach
    void setUp() {
        harryAssignment = new HouseAssignment(House.GRYFFINDOR, Wing.EAST, 1050);
        dracoAssignment = new HouseAssignment(House.SLYTHERIN, Wing.WEST, 55);

//        houseAssignmentRepository.save(harryAssignment);
//        houseAssignmentRepository.save(dracoAssignment);

        percy = new Prefect("Percy", "Weasley", House.GRYFFINDOR);
        harry = new Student("Harry", "Potter");
        harry.setPrefect(percy);
        harry.setHouseAssignment(harryAssignment);
        draco = new Student("Draco", "Malfoy");
        draco.setPrefect(percy);
        draco.setHouseAssignment(dracoAssignment);

        List<Student> students = List.of(harry, draco);
        percy.setStudents(students);

        prefectRepository.save(percy);

    }

    @AfterEach
    void tearDown() {
        prefectRepository.deleteAll();
//        studentRepository.deleteAll();
//        houseAssignmentRepository.deleteAll();
    }

    @Test
    void findById_percyId_percyWithStudents() {
        Optional<Prefect> optionalPrefect = prefectRepository.findByIdWithStudents(percy.getId());
        assertTrue(optionalPrefect.isPresent()); // ¿La query de arriba me trajo un valor distinto de NULL?
        assertEquals("Percy", optionalPrefect.get().getFirstName());
        assertEquals(2, optionalPrefect.get().getStudents().size());

    }
}