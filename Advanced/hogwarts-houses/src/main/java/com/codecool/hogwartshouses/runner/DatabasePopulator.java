package com.codecool.hogwartshouses.runner;

import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.persistence.entity.Student;
import com.codecool.hogwartshouses.persistence.repository.RoomRepository;
import com.codecool.hogwartshouses.persistence.repository.StudentRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("datasets")
public class DatabasePopulator {
    private List<Room> rooms;
    private List<Student> students;

    @Bean
    ApplicationRunner populator(StudentRepository studentRepository, RoomRepository roomRepository) {
        return args -> {
            roomRepository.saveAll(rooms);
            studentRepository.saveAll(students);

            Room room1 = rooms.get(0);
            Room room2 = rooms.get(1);
            Student student1 = students.get(0);
            Student student2 = students.get(1);
            
            room1.setStudent(student1);
            room2.setStudent(student2);
            
            roomRepository.save(room1);
            roomRepository.save(room2);
        };
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
