package com.ironhack.relationshipsdemo.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Spell {

    private int id;

    private String name;

    private String level;

    @ManyToMany(mappedBy = "spellList")
    private List<Student> studentList;

    public Spell() {
    }

    public Spell(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
