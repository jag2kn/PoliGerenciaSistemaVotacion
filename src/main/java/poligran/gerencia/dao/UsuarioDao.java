package poligran.gerencia.dao;

import poligran.gerencia.jpa.entities.*;

import java.util.List;

import javax.persistence.PersistenceException;

/**
* @author Rodrigo Torres
*
*/
public interface UsuarioDao {
        
        public List<Usuario> loadAll() throws PersistenceException;
        
        public Usuario getUsuario(int id) throws PersistenceException;
        
        public void registrarUsuario(Usuario u) throws PersistenceException;
        
        public void actualizarUsuario(Usuario u) throws PersistenceException;

		public Usuario buscarUsuario(String nombre) throws PersistenceException;

		public Usuario autenticar(String usuario, String clave) throws PersistenceException;

}
