package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Proyecto;
import pe.edu.upc.serviceinterface.IEmprendedorService;
import pe.edu.upc.serviceinterface.IProyectoService;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {

	@Autowired
	private IProyectoService pService;
	
	@Autowired
	private IEmprendedorService eService;
	
	@GetMapping("/new")
	public String newProyecto(Model model) {
		model.addAttribute("listaEmprendedores", eService.list());
		model.addAttribute("proyecto", new Proyecto());
		return "proyecto/proyecto";	
	}
	
	@GetMapping("/list")
	public String listProyectos(Model model) {
		try {
			model.addAttribute("proyecto", new Proyecto());

		}catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "proyecto/listProyectos";
	}
	
	@PostMapping("/save")
	public String saveProyecto(@Validated Proyecto proyecto, BindingResult result, Model model, SessionStatus status ) throws Exception {
		if(result.hasErrors()) {
			return "proyecto/proyecto";
		} else {
			int rpta = pService.insert(proyecto);
			if(rpta>0) {
				model.addAttribute("mensaje","Se guardó correctamente");
				status.setComplete();
			}
			model.addAttribute("proyecto", new Proyecto());
			return "redirect:/proyectos/list";
		}
	}
}
