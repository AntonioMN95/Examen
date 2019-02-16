package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Actor;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	private ActorRepository repository;

	public Actor assembleActorFromRequest(HttpServletRequest req) {
		return ActorAssembler.assembleActorFrom(req);
	}

	public List<Actor> listAllActor() {
		return repository.selectAllActor();
	}

	public void insert(Actor actor) {
		repository.insert(actor);
	}

	public void delete(int code) {
		repository.delete(code);
	}

	public Actor findByCod(int code) {
		return repository.findByCod(code);
	}

	public List<Actor> filterActor(int startYear, int endYear) {
		return repository.filterActor(startYear, endYear);
	}

}