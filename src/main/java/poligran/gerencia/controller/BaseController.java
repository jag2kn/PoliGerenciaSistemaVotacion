package poligran.gerencia.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poligran.gerencia.jpa.entities.*;
import poligran.gerencia.service.*;

@Controller
@RequestMapping("/")
public class BaseController {


	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		HttpSession s = request.getSession();
		Map<String, String> respuesta=new HashMap<String, String>();
		
		Usuario u = (Usuario)s.getAttribute("usuario");
		if (u==null){
			respuesta.put("tipoUsuario", "anonimo");
		}else{
			respuesta.put("tipoUsuario", u.getRol());
		}
		return new ModelAndView("index", respuesta);
	}
	
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView admin(HttpServletRequest request) {
		HttpSession s = request.getSession();
		Map<String, String> respuesta=new HashMap<String, String>();
		
		Usuario u = (Usuario)s.getAttribute("usuario");
		if (u==null){
			respuesta.put("tipoUsuario", "anonimo");
		}else{
			respuesta.put("tipoUsuario", u.getRol());
		}
		return new ModelAndView("admin", respuesta);
	}
	/*
	 * 
	 * @RequestMapping(value = "/testEleccion", method = RequestMethod.GET)
	 * public String index2(ModelMap model) {
	 * 
	 * model.addAttribute("message", "Test almacenamiento nueva eleccion");
	 * 
	 * Eleccion e = new Eleccion(); e.setDescripcion("Presidenciales 2014");
	 * e.setNombre("Eleccion2014"); eleccionService.registrarEleccion(e);
	 * 
	 * Candidato c = new Candidato(); c.setEleccion(e);
	 * c.setNombreCompleto("Pepe Perez"); c.setFechaNacimiento(new Date());
	 * c.setImagen("Imagen_pepe.png"); c.setNumeroLista(1);
	 * 
	 * candidatoService.registrarCandidato(c);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * // Spring uses InternalResourceViewResolver and return back index.jsp
	 * return "index";
	 * 
	 * }
	 */

}
