package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@SpringBootApplication
public class Pa2U4P4AsJaApplication implements CommandLineRunner{
	
	@Autowired
	private IPropietarioService propietarioService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U4P4AsJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		Propietario prop = new Propietario();
		prop.setNombre("Augusto");
		prop.setApellido("Salazar");
		prop.setCedula("1726600537");
		
		Propietario prop2 = new Propietario();
		prop2.setNombre("Diana");
		prop2.setApellido("Pillajo");
		prop2.setCedula("1726600537");
		
		//this.propietarioService.guardar(prop);
		//this.propietarioService.guardar(prop2);
	}

}
