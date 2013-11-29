package poligran.gerencia.service;
import java.util.List;

import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.entities.*;

public interface EleccionService {
	 public List<Eleccion> loadAll();
     
     public Eleccion getEleccion(int id);
     
     public void registrarEleccion(Eleccion c);
     
     public void actualizarEleccion(Eleccion c);	 
}
