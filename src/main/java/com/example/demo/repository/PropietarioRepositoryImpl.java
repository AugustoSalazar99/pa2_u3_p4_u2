package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}

	@Override
	
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(propietario);
	}

	@Override
	
	public void eliminar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.remove(propietario);
	}

	@Override
	public List<Propietario> buscarTodos() {
		// TODO Auto-generated method stub
		
		TypedQuery<Propietario> myQuery=this.entityManager.createQuery("SELECT p FROM Propietario p",Propietario.class);
		return myQuery.getResultList();
		
	}



	
	
	

}
