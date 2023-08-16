package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")//nombre debe estar en plural
public class PropietarioController {
	@Autowired
	private IPropietarioService propietarioService;

	
	//todos los metodos del controoler va a direccionaar a la vista 
	//http://localhost:8080/concesionar/propietario/buscar
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Propietario> lista=this.propietarioService.reporteTodos();
		modelo.addAttribute("propietarios",modelo);
		return "vistaListaPropietario";
		
	}

	
	
	

}
