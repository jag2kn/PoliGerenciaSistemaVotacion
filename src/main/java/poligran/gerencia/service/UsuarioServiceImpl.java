package poligran.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poligran.gerencia.dao.*;
import poligran.gerencia.jpa.entities.*;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Transactional
	public List<Usuario> loadAll() {
		return usuarioDao.loadAll();
	}

	@Transactional
	public Usuario getUsuario(int id) {
		usuarioDao.getUsuario(id);
		return null;
	}

	@Transactional
	public void registrarUsuario(Usuario u) {
		usuarioDao.registrarUsuario(u);

	}

	@Transactional
	public void actualizarUsuario(Usuario u) {
		usuarioDao.actualizarUsuario(u);
	}

	@Transactional
	public Usuario buscarUsuario(String nombre) {
		usuarioDao.buscarUsuario(nombre);
		return null;
	}

	@Override
	public Usuario autenticar(String usuario, String clave) {
		return usuarioDao.autenticar(usuario, clave);
	}

}
