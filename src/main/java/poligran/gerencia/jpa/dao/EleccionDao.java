package poligran.gerencia.dao;

import poligran.gerencia.jpa.entities.*;
import java.util.List;

//import javax.persistence.PersistenceException;

/**
* @author Rodrigo Torres
*
*/
public interface EleccionDao {
        
        public List<Eleccion> loadAll();//throws PersistenceException;
        
        public Eleccion getEleccion(int id);//throws PersistenceException;
        
        public void registrarEleccion(Eleccion e);// throws PersistenceException;
        
        public void actualizarEleccion(Eleccion e);// throws PersistenceException;

}
