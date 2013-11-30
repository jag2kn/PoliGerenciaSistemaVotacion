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
public class UsuarioController {

	@Autowired
	public UsuarioService usuarioService;

	@RequestMapping(value = "login", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(HttpServletRequest request) {
		HttpSession s = request.getSession();
		

		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		System.out.println("Usuario: " + usuario);
		System.out.println("Clave:   " + clave);

		System.out.println("Buscando el usuario "+usuario);
		Usuario u = usuarioService.autenticar(usuario, clave);
		
		if (u!=null){
			s.setAttribute("usuario", u);
			System.out.println("Bienvenido: " + u.getUsername());
			return new ModelAndView("redirect:/");
			
		}
		Map<String, String> respuesta=new HashMap<String, String>();
		respuesta.put("mensaje", "Usuario o clave incorrectos");
		return new ModelAndView("general/login", respuesta);

	}
	
	@RequestMapping(value = "registro", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView registro(HttpServletRequest request) {

		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		String rol="usuario";
		Map<String, String> respuesta=new HashMap<String, String>();
		respuesta.put("mensaje", "");
		
		System.out.println(usuarioService);
		
		
		if (usuario!=null){
			System.out.println("Buscando el usuario "+usuario);
			Usuario u = usuarioService.buscarUsuario(usuario);
	
			if (u==null){
				u= new Usuario();
				u.setUsername(usuario);
				u.setPassword(clave);
				u.setRol(rol);
				usuarioService.registrarUsuario(u);
				return new ModelAndView("redirect:/login");
			}
			respuesta.put("mensaje", "El usuario ya existe");
		}
		return new ModelAndView("general/registro", respuesta);

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
