package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.logic.RoomService;
import com.codecool.hogwartshouses.persistence.entity.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RoomEndpointTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    RoomService roomService;

    String uri = "/rooms";

    @Test
    void getAll() {
        webTestClient.get()
                .uri(uri)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        verify(roomService).findAll();
    }

    @Test
    void getOneFindsEntity() {
        long id = 1;
        Room room = Room.builder().id(id).build();
        String getOneUri = uri + "/" + id;
        when(roomService.findOne(id)).thenReturn(Optional.of(room));

        webTestClient.get()
                .uri(getOneUri)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        verify(roomService).findOne(id);
    }

    @Test
    void getOneDoesNotFindEntity() {
        long id = 1;
        String getOneUri = uri + "/" + id;

        webTestClient.get()
                .uri(getOneUri)
                .exchange()
                .expectStatus()
                .isNotFound();

        verify(roomService).findOne(id);
    }

    @Test
    void post() {
        int number = 1;
        Room room = Room.builder().number(number).build();

        webTestClient.post()
                .uri(uri)
                .bodyValue(room)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        verify(roomService).save(room);
    }

    @Test
    void put() {
        long id = 1;
        Room room = Room.builder().id(id).build();

        webTestClient.put()
                .uri(uri)
                .bodyValue(room)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        verify(roomService).save(room);
    }

    @Test
    void delete() {
        long id = 1;
        String deleteUri = uri + "/" + id;

        webTestClient.delete()
                .uri(deleteUri)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        verify(roomService).delete(id);
    }
}