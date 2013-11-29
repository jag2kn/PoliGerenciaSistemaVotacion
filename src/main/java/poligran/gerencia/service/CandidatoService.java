package poligran.gerencia.service;
import java.util.List;

import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.entities.*;

public interface CandidatoService {
	 public List<Candidato> loadAll();
     
     public List<Candidato> loadByElection(Eleccion e);
     
     public Candidato getCandidato(int id);
     
     public void registrarCandidato(Candidato c);
     
     public void actualizarCandidato(Candidato c);	 
}
