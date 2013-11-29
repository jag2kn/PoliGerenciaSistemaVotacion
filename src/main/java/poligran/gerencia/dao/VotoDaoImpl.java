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


/**
 * @author Bosz2013
 *
 */
@Repository
public class VotoDaoImpl implements VotoDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#loadByElection(int)
	 */
	@Transactional
	public List<Voto> loadByElection(int idEleccion)
			throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		Query q = s.getNamedQuery("voto.loadByElection");
		q.setParameter("idEleccion", idEleccion);
		//ToDo: falta pasar el parametro e
		return q.list();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#loadByCandidateElection(int, int)
	 */
	@Transactional
	public List<Voto> loadByCandidateElection(int idEleccion, int IdCandidato)
			throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		Query q = s.getNamedQuery("voto.loadByCandidateElection");
		q.setParameter("idEleccion", idEleccion);
		q.setParameter("numID", IdCandidato);
		//ToDo: falta pasar el parametro e
		return q.list();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#getVoto(int)
	 */
	@Transactional
	public Voto getVoto(int id) throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Voto where id = :id");
		q.setParameter("id", id);
		return (Voto) q.list().get(0);
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#registrarVoto(poligran.gerencia.jpa.entities.Voto)
	 */
	@Transactional
	public void registrarVoto(Voto v) throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		s.save(v);
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#actualizarVoto(poligran.gerencia.jpa.entities.Voto)
	 */
	@Transactional
	public void actualizarVoto(Voto v) throws PersistenceException {
		Session s = sessionFactory.getCurrentSession();
		s.update(v);
	}

}
