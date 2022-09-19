package com.codecool.hogwartshouses.persistence.repository;

import com.codecool.hogwartshouses.data.Pet;
import com.codecool.hogwartshouses.persistence.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByStudentIsNull();

    List<Room> findByStudentIsNullOrStudentIsNotNullAndStudentPetIsNotIn(List<Pet> exclusions);
}
