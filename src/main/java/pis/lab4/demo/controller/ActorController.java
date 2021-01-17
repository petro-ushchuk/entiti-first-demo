package pis.lab4.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pis.lab4.demo.api.ActorApi;
import pis.lab4.demo.dto.ActorDto;
import pis.lab4.demo.model.Actor;
import pis.lab4.demo.service.MappingService;
import pis.lab4.demo.service.ActorService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ActorController implements ActorApi {

    private final ActorService actorService;

    @Override
    public ActorDto createActor(ActorDto actorDto) {
        log.info("createActor: with name {}", actorDto.getFirstName());
        ActorDto actor = actorService.createActor(actorDto);
        return actor;
    }

    @Override
    public ActorDto getActor(Long id) {
        log.info("getActor: with id {}", id);
        ActorDto actorDto = actorService.getActor(id);;
        return actorDto;
    }

    @Override
    public ActorDto updateActor(ActorDto actorDto) {
        log.info("updateActor controller is called");
        ActorDto actor = actorService.updateActor(actorDto);
        return actor;
    }

    @Override
    public ResponseEntity<Void> deleteActor(Long id) {
        log.info("deleteActor: with id {}",id);
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }

}
