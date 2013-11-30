package poligran.gerencia.service;
import java.util.List;

import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.entities.*;

public interface UsuarioService {
	 public List<Usuario> loadAll();
     
     public Usuario getUsuario(int id);
     
     public void registrarUsuario(Usuario c);
     
     public void actualizarUsuario(Usuario c);	 
     
     public Usuario buscarUsuario(String nombre);

	public Usuario autenticar(String usuario, String clave);
}
