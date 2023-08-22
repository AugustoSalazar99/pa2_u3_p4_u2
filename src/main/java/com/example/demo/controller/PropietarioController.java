package com.example.demo.controller;

import org.apache.log4j.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios") // nombre debe estar en plural
public class PropietarioController {

	private static final Logger LOG = Logger.getLogger(PropietarioController.class);
	
	
	@Autowired
	private IPropietarioService propietarioService;

	// todos los metodos del controoler va a direccionaar a la vista
	// http://localhost:8081/concesionar/propietarios/buscar

	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		LOG.info("Info");
		LOG.error("Info");
		LOG.warn("Info");
		LOG.debug("Info");
		List<Propietario> lista = this.propietarioService.reporteTodos();
		modelo.addAttribute("propietarios", lista);
		return "vistaListaPropietario";

	}

	// http://localhost:8081/concesionario/propietarios/buscarPorID/datoquetengo

	@GetMapping("/buscarPorID/{idPropietario}")//hay que decirle que es un dato pathvariable
	public String buscarPorId(@PathVariable("idPropietario") Integer id, Model model) {
		
		Propietario prop=this.propietarioService.buscar(id);
		//quiero mandar a mi pag web debo mandar en un modelo
		
		model.addAttribute("propietario",prop);
		
		
		return "vistaPropietario";
	}
	
//http://localhost:8081/concesionario/propietarios/actualizar/7
	// necesito recibir un objeto para este metodo entonces id y objeto
	@GetMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(@PathVariable("idPropietario") Integer id,Propietario propietario) {
		this.propietarioService.actualizar(propietario);
		return "redirect:/propietarios/buscar";
		
	}
	//http://localhost:8081/consecionario/propietarios/borrar/1
	
	@DeleteMapping("/borrar/{idPropietario}")
	public String eliminarPorID(@PathVariable("idPropietario") Integer id) {
		this.propietarioService.eliminar(id);
		return "redirect:/propietarios/buscar";
	}
	
	@PostMapping("/guardar")
	public String insertarPropietario(Propietario propietario) {
		this.propietarioService.guardar(propietario);
		return"redirect:/propietarios/buscar";
	}
	
	@GetMapping("/nuevo")
	public String paginaNuevoPropietario(Propietario propietario) {
		
		return "vistaNuevoPropietario";
	}
	

}
