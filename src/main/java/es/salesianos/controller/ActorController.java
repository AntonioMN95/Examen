package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Actor;
import es.salesianos.service.IActorService;

@Controller
public class ActorController {

	@Autowired
	private IActorService service;

	@GetMapping("/deleteActor")
	protected ModelAndView deleteActor(@RequestParam Integer cod) {
		service.delete(cod);
		return loadList();
	}

	@GetMapping("/actor")
	private ModelAndView loadList() {
		List<Actor> actorsList = service.listAllActor();
		ModelAndView model = new ModelAndView("actor");
		model.addObject("listAllActors", actorsList);
		return model;
	}

	@PostMapping("/insertActor")
	protected ModelAndView insertActor(Actor actor) {
		return loadList();
	}

	@GetMapping("/filterActors")
	private ModelAndView filterActors(@RequestParam Integer startYear, @RequestParam Integer endYear) {
		List<Actor> filteredActors = service.filterActor(startYear, endYear);
		ModelAndView model = new ModelAndView("actor");
		model.addObject("listAllActors", filteredActors);
		return model;
	}
}
