package com.codecool.hogwartshouses.logic;

import com.codecool.hogwartshouses.data.Pet;
import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.persistence.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> findOne(long id) {
        return roomRepository.findById(id);
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public void delete(long id) {
        roomRepository.deleteById(id);
    }

    public List<Room> findAvailable() {
        return roomRepository.findByStudentIsNull();
    }

    public List<Room> findForRatOwners() {
        return roomRepository.findByStudentIsNullOrStudentIsNotNullAndStudentPetIsNotIn(List.of(Pet.CAT, Pet.OWL));
    }
}
