package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	
	@Autowired
	private IPropietarioRepository propietarioRepository;
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepository.insertar(propietario);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepository.actualizar(propietario);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.propietarioRepository.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Propietario> reporteTodos() {
		// TODO Auto-generated method stub
		return this.propietarioRepository.buscarTodos();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Propietario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.propietarioRepository.buscar(id);
	}
	

}
