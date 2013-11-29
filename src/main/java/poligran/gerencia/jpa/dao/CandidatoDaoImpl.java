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
public class CandidatoDaoImpl implements CandidatoDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	@Transactional
	public List<Candidato> loadAll() throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Candidato").list();
	}
	@Transactional
	public List<Candidato> loadByElection(Eleccion e)
			throws PersistenceException {
		/*
		Query q = em.createNamedQuery("candidato.loadByElection", Candidato.class);
		q.setParameter("idEleccion", e.getIdEleccion());
		return q.getResultList();*/
		Session s = sessionFactory.getCurrentSession();
		Query q = s.getNamedQuery("candidato.loadByElection");
		//ToDo: falta pasar el parametro e
		return q.list();
	}
	@Transactional
	public Candidato getCandidato(int id) throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Candidato where id = :id");
		q.setParameter("id", id);
		return (Candidato) q.list().get(0);
	}
	@Transactional
	public void registrarCandidato(Candidato e) throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		s.save(e);
	}
	@Transactional
	public void actualizarCandidato(Candidato e) throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		s.update(e);
	}
}
