USE relationships_demo;

CREATE TABLE spell(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    level VARCHAR(255),
    PRIMARY KEY(id)
    
);

CREATE TABLE student(
  id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  house_assignment_id INT,
  PRIMARY KEY(id)
  
);

CREATE TABLE student_spell(
	student_id BIGINT,
    spell_id INT,
    PRIMARY KEY(student_id),
    FOREIGN KEY(student_id) REFERENCES student(id),
	FOREIGN KEY(spell_id) REFERENCES spell(id)
    );
    
SELECT * FROM student;
 