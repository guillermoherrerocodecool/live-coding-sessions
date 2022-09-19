package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.api.exception.ElementNotFoundException;
import com.codecool.hogwartshouses.logic.RoomService;
import com.codecool.hogwartshouses.persistence.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomEndpoint {
    private final RoomService roomService;

    @GetMapping
    List<Room> getAll() {
        return roomService.findAll();
    }

    @GetMapping("{id}")
    Room get(@PathVariable long id) {
        return roomService.findOne(id)
                .orElseThrow(ElementNotFoundException::new);
    }

    @PostMapping
    Room post(@RequestBody Room room) {
        return roomService.save(room);
    }

    @PutMapping
    Room put(@RequestBody Room room) {
        return roomService.save(room);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable long id) {
        roomService.delete(id);

    }

    @GetMapping("available")
    List<Room> getAvailable() {
        return roomService.findAvailable();
    }
    
    @GetMapping("rat-owners")
    List<Room> getRatOwners(){
        return roomService.findForRatOwners();
    }
}
