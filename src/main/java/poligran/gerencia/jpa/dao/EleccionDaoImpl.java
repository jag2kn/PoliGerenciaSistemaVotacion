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
public class EleccionDaoImpl implements EleccionDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	@Transactional
	public List<Eleccion> loadAll() throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Eleccion").list();
	}
	@Transactional
	public Eleccion getEleccion(int id) throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Eleccion where id = :id");
		q.setParameter("id", id);
		return (Eleccion) q.list().get(0);
	}
	@Transactional
	public void registrarEleccion(Eleccion e) throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		s.save(e);
	}
	@Transactional
	public void actualizarEleccion(Eleccion e) throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		s.update(e);
	}
}
