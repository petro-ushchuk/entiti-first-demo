package pis.lab4.demo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pis.lab4.demo.dto.ActorDto;
import pis.lab4.demo.exception.NotFoundException;
import pis.lab4.demo.model.Actor;
import pis.lab4.demo.repository.ActorRepository;
import pis.lab4.demo.service.ActorService;
import pis.lab4.demo.service.MappingService;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final MappingService mappingService;

    @Override
    public ActorDto getActor(Long id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        if(!optionalActor.isPresent())
            throw new NotFoundException("Actor not found exception");
        Actor actor = optionalActor.get();
        log.info("About to get Actor {}", actor);
        return mappingService.mapActorToActorDto(actor);
    }

    @Override
    public ActorDto createActor(ActorDto actorDto) {
        Actor actor = mappingService.mapActorDtoToActor(actorDto);
        log.info("About to create Actor {}", actor);
        actor = actorRepository.save(actor);
        log.info("Used with id {} successfully created", actor.getId());
        return mappingService.mapActorToActorDto(actor);
    }

    @Override
    public ActorDto updateActor(ActorDto actorDto) {
        Actor actor = mappingService.mapActorDtoToActor(actorDto);
        log.info("About to update Actor {}", actor);
        actor = actorRepository.save(actor);
        log.info("Used with id {} successfully updated", actor.getId());
        return mappingService.mapActorToActorDto(actor);
    }

    @Override
    public void deleteActor(Long id) {
        log.info("deleteActor: about to delete Actor with id {}", id);
        SecurityContextHolder.clearContext();
        actorRepository.deleteById(id);
    }

}
