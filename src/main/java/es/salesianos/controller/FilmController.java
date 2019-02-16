package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Film;
import es.salesianos.service.FilmService;

@Controller
public class FilmController {

	@Autowired
	private FilmService service;

	@PostMapping("/insertFilm")
	protected ModelAndView insertFilm(Film film) {
		service.insert(film);
		loadList();
		return loadList();
	}

	@GetMapping("/deleteFilm")
	protected ModelAndView deleteFilm(@RequestParam Integer cod) {
		service.delete(cod);
		loadList();
		return loadList();
	}

	@GetMapping("/film")
	private ModelAndView loadList() {
		List<Film> listAllFilm = service.selectAllFilm();
		ModelAndView model = new ModelAndView("film");
		model.addObject("listAllFilm", listAllFilm);
		return model;
	}

}