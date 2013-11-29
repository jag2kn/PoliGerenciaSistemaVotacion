package poligran.gerencia.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.entities.*;

/**
*
* @author Rodrigo Torres
*
*/
public interface VotoDao {
        
        public List<Voto> loadByElection(int idEleccion)throws PersistenceException;
        
        public List<Voto> loadByCandidateElection(int idEleccion, int IdCandidato)throws PersistenceException;
        
        public Voto getVoto(int id)throws PersistenceException;
        
        public void registrarVoto(Voto v) throws PersistenceException;
        
        public void actualizarVoto(Voto v) throws PersistenceException;
}
