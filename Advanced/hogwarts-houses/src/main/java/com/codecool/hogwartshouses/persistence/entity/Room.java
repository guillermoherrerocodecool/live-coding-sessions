package com.codecool.hogwartshouses.persistence.entity;

import com.codecool.hogwartshouses.data.House;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Room {
    @Id
    @GeneratedValue
    private long id;
    private int number;
    @Enumerated(value = EnumType.STRING)
    private House house;
    @OneToOne
    private Student student;
}
