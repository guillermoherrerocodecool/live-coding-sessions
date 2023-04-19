package com.codecool.cats.endpoint;

import com.codecool.cats.data.Cat;
import com.codecool.cats.service.CatStorage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cats")
public class CatEndpoint {
    private final CatStorage catStorage;

    public CatEndpoint(CatStorage catStorage) {
        this.catStorage = catStorage;
    }

    @PostMapping
    public Cat create(@RequestBody Cat cat) {
        catStorage.create(cat);
        return cat;
    }

    @GetMapping
    public List<Cat> readAll() {
        return catStorage.readAll();
    }

    @GetMapping("{name}")
    public Cat readOneByName(@PathVariable String name) throws CatNotFoundException {
        return catStorage.readOneByName(name)
                .orElseThrow(CatNotFoundException::new);
    }

    @PatchMapping
    public Cat update(@RequestBody Cat cat) {
        return catStorage.update(cat);
    }

    @DeleteMapping("{name}")
    public void delete(@PathVariable String name) {
        catStorage.delete(name);
    }
}
