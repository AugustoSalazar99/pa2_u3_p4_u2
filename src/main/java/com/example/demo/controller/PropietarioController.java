package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")//nombre debe estar en plural
public class PropietarioController {
	
	@Autowired
	private IPropietarioService propietarioService;

	
	//todos los metodos del controoler va a direccionaar a la vista 
	//http://localhost:8081/concesionar/propietarios/buscar
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Propietario> lista=this.propietarioService.reporteTodos();
		modelo.addAttribute("propietarios",lista);
		return "vistaListaPropietario";
		
	}

	@GetMapping("/buscarPorID/{idPropietario}")//hay que decirle que es un dato pathvariable
	public String buscarPorId(@PathVariable("idPropietario") Integer id, Model model) {
		
		Propietario prop=this.propietarioService.buscar(id);
		//quiero mandar a mi pag web debo mandar en un modelo
		
		model.addAttribute("propietario",prop);
		
		
		return "vistaPropietario";
		
	}
	
	

}
