package com.mycompany.project_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="DETAIL_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class DetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name="DETAIL_NAME",nullable = false)
    private String name;
    @Column(name="DETAIL_DESCRIPTION",nullable = false)
    private String description;
    @Column(name="DETAIL_PRICE",nullable = false)
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
