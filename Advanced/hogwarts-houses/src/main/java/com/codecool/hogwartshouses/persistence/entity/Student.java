package com.codecool.hogwartshouses.persistence.entity;

import com.codecool.hogwartshouses.data.Pet;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Pet pet;
}
