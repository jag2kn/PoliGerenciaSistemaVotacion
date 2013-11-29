package poligran.gerencia.dao;

import poligran.gerencia.jpa.entities.*;

import java.util.List;

import javax.persistence.PersistenceException;

/**
*
* @author Rodrigo Tores
*
*/
public interface CandidatoDao {
        
        public List<Candidato> loadAll()throws PersistenceException;
        
        public List<Candidato> loadByElection(Eleccion e)throws PersistenceException;
        
        public Candidato getCandidato(int id)throws PersistenceException;
        
        public void registrarCandidato(Candidato c) throws PersistenceException;
        
        public void actualizarCandidato(Candidato c) throws PersistenceException;
}