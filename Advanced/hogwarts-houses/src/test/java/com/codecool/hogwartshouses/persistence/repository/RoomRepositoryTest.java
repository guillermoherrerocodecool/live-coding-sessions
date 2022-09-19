package com.codecool.hogwartshouses.persistence.repository;

import com.codecool.hogwartshouses.data.Pet;
import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.persistence.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@DataJpaTest
class RoomRepositoryTest {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    StudentRepository studentRepository;

    @AfterEach
    void after() {
        roomRepository.deleteAll();
        studentRepository.deleteAll();
    }

    @Test
    void findByStudentIsNull() {
        Student student = Student.builder().build();
        studentRepository.save(student);
        Room room1 = Room.builder().number(1).student(student).build();
        Room room2 = Room.builder().number(2).student(null).build();
        roomRepository.saveAll(List.of(room1, room2));

        List<Room> result = roomRepository.findByStudentIsNull();

        List<Room> expected = List.of(room2);
        assertIterableEquals(expected, result);
    }

    @Test
    void findByStudentIsNullOrStudentIsNotNullAndStudentPetIsNotIn() {
        Student studentCat = Student.builder().pet(Pet.CAT).build();
        Student studentRat = Student.builder().pet(Pet.RAT).build();
        Student studentOwl = Student.builder().pet(Pet.OWL).build();
        studentRepository.save(studentCat);
        studentRepository.save(studentRat);
        studentRepository.save(studentOwl);
        Room room1 = Room.builder().number(1).student(null).build();
        Room room2 = Room.builder().number(2).student(studentCat).build();
        Room room3 = Room.builder().number(3).student(studentRat).build();
        Room room4 = Room.builder().number(4).student(studentOwl).build();
        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);
        roomRepository.save(room4);

        assertAll(
                () -> test(List.of(room1), List.of()),
                () -> test(List.of(room1, room3, room4), List.of(Pet.CAT)),
                () -> test(List.of(room1, room2, room4), List.of(Pet.RAT)),
                () -> test(List.of(room1, room2, room3), List.of(Pet.OWL)),
                () -> test(List.of(room1, room4), List.of(Pet.CAT, Pet.RAT)),
                () -> test(List.of(room1), List.of(Pet.CAT, Pet.RAT, Pet.OWL))
        );
    }

    private void test(List<Room> expected, List<Pet> exclusions) {
        List<Room> result = roomRepository.findByStudentIsNullOrStudentIsNotNullAndStudentPetIsNotIn(exclusions);
        assertIterableEquals(expected, result);
    }
}