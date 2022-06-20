package com.ironhack.relationshipsdemo.repository;

import com.ironhack.relationshipsdemo.model.HouseAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseAssignmentRepository extends JpaRepository<HouseAssignment, Long> {
}
