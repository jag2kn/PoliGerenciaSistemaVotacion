package poligran.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poligran.gerencia.dao.*;
import poligran.gerencia.jpa.entities.*;

@Service
public class EleccionServiceImpl implements EleccionService {

	@Autowired
	private EleccionDao eleccionDao;

	@Transactional
	public List<Eleccion> loadAll() {
		return eleccionDao.loadAll();
	}

	@Transactional
	public Eleccion getEleccion(int id) {
		eleccionDao.getEleccion(id);
		return null;
	}

	@Transactional
	public void registrarEleccion(Eleccion c) {
		eleccionDao.registrarEleccion(c);

	}

	@Transactional
	public void actualizarEleccion(Eleccion c) {
		eleccionDao.actualizarEleccion(c);
	}

}
