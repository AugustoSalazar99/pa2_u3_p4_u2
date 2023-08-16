package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Propietario;


public interface IPropietarioService  {
	public void guardar(Propietario propietario);
	public void actualizar(Propietario propietario);
	public void eliminar(Propietario propietario);
	public List<Propietario> reporteTodos();
	

}
