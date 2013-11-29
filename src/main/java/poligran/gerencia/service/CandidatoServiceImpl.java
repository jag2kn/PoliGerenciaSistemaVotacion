package poligran.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poligran.gerencia.dao.*;
import poligran.gerencia.jpa.entities.*;

@Service
public class CandidatoServiceImpl implements CandidatoService {

	@Autowired
	private CandidatoDao candidatoDao;

	@Transactional
	public List<Candidato> loadAll() {
		return candidatoDao.loadAll();
	}

	@Transactional
	public List<Candidato> loadByElection(Eleccion e) {
		candidatoDao.loadByElection(e);
		return null;
	}

	@Transactional
	public Candidato getCandidato(int id) {
		candidatoDao.getCandidato(id);
		return null;
	}

	@Transactional
	public void registrarCandidato(Candidato c) {
		candidatoDao.registrarCandidato(c);

	}

	@Transactional
	public void actualizarCandidato(Candidato c) {
		candidatoDao.actualizarCandidato(c);
	}

}
