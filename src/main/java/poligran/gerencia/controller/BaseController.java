package poligran.gerencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



//import poligran.gerencia.jpa.entities.*;
import poligran.gerencia.service.CandidatoService;
import poligran.gerencia.service.CandidatoServiceImpl;
import poligran.gerencia.dao.CandidatoDao;
import poligran.gerencia.jpa.entities.Candidato;
import poligran.gerencia.jpa.entities.Eleccion;
import poligran.gerencia.service.*;

@Controller
@RequestMapping("/")
public class BaseController {
/*	@Autowired
	public CandidatoService candidatoService;
*/
	@Autowired
	public EleccionService eleccionService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {

		model.addAttribute("message",
				"Sistema de Votaciones - Poligran");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";

	}

	@RequestMapping(value = "/testEleccion", method = RequestMethod.GET)
	public String index2(ModelMap model) {

		model.addAttribute("message",
				"Test almacenamiento nueva eleccion");
		
		Eleccion e = new Eleccion();
		e.setDescripcion("Presidenciales 2014");
		e.setNombre("Eleccion2014");
		eleccionService.registrarEleccion(e);
		
		
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";

	}
	

}
