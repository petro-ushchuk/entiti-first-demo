package pis.lab4.demo.service;

import pis.lab4.demo.dto.ActorDto;

public interface ActorService {

  ActorDto getActor(Long id);

  ActorDto createActor(ActorDto actorDto);

  ActorDto updateActor(ActorDto actorDto);

  void deleteActor(Long id);

}
