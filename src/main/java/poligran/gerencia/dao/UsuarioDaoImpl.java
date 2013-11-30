package poligran.gerencia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.entities.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	@Autowired
	private SessionFactory sessionFactory;
	Session s;
	/*
	public UsuarioDaoImpl(){
		try{
			s = sessionFactory.getCurrentSession();
		}catch(java.lang.NoSuchMethodError e){
			s = sessionFactory.openSession();
		}
	}
	*/

	@Transactional
	public List<Usuario> loadAll() throws PersistenceException {
		s = sessionFactory.getCurrentSession();
		return s.createQuery("from Usuario").list();
	}
	@Transactional
	public Usuario getUsuario(int id) throws PersistenceException {
		s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Usuario where id = :id");
		q.setParameter("id", id);
		List<Usuario> resultado = q.list();
		if (resultado.size()>0){
			return (Usuario) q.list().get(0);
		}else{
			return null;
		}
	}
	@Transactional
	public void registrarUsuario(Usuario e) throws PersistenceException {
		s = sessionFactory.getCurrentSession();
		s.save(e);
	}
	@Transactional
	public void actualizarUsuario(Usuario e) throws PersistenceException {
		s = sessionFactory.getCurrentSession();
		s.update(e);
	}
	@Transactional
	public Usuario buscarUsuario(String nombre) throws PersistenceException {
		s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Usuario where username = :nombre");
		q.setParameter("nombre", nombre);
		List<Usuario> resultado = q.list();
		if (resultado.size()>0){
			return (Usuario) q.list().get(0);
		}else{
			return null;
		}
	}
	@Override
	public Usuario autenticar(String usuario, String clave)
			throws PersistenceException {
		s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Usuario where username = :usuario AND password = :clave");
		q.setParameter("usuario", usuario);
		q.setParameter("clave", clave);
		List<Usuario> resultado = q.list();
		if (resultado.size()>0){
			return (Usuario) q.list().get(0);
		}else{
			return null;
		}
	}
}
