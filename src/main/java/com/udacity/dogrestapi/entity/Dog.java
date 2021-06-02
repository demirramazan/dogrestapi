package com.udacity.dogrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DOG")
public class Dog {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String breed;
    private String origin;
}
