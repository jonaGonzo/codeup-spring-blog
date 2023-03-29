package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "int(11)")
    private long id;

    @Column(name = "age", nullable = false, columnDefinition = "tinyint(3)")
    private Short age;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "reside_state", nullable = true, columnDefinition = "char(2) default 'XX' ")
    private String reside_state;

    public Dog() {
    }

    public Dog(long id, Short age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Dog(long id, Short age, String name, String reside_state) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReside_state() {
        return reside_state;
    }

    public void setReside_state(String reside_state) {
        this.reside_state = reside_state;
    }
}
