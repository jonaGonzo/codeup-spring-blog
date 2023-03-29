package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
//@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int costInCents;

    public Product() {
    }

    public Product(String name, int costInCents) {
        this.name = name;
        this.costInCents = costInCents;
    }

    public Product(long id, String name, int costInCents) {
        this.id = id;
        this.name = name;
        this.costInCents = costInCents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCostInCents() {
        return costInCents;
    }

    public void setCostInCents(int costInCents) {
        this.costInCents = costInCents;
    }
}
