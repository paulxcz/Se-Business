package pe.edu.upc.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Secured({ "ROLE_ADMIN", "ROLE_EMPRENDEDORES" })
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
			model.addAttribute("listaProyectos", pService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "proyecto/listProyectos";
	}

	@RequestMapping("/save")
	public String saveProyecto(@ModelAttribute @Validated Proyecto objPro, BindingResult binRes, Model model,
			SessionStatus status) throws Exception {
		if (binRes.hasErrors()) {
			model.addAttribute("listaEmprendedores", eService.list());
			return "proyecto/proyecto";
		} else {
			boolean flag = pService.insert(objPro);
			if (flag) {
				return "redirect:/proyectos/list";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect://proyectos/new";
			}
		}
	}

	@RequestMapping("/reporte1")
	public String proyectosXempre(Map<String, Object> model) {
		model.put("listProyectosXempre", pService.proyectosXempre());
		return "reports/proyectosOrdenados";
	}

	@RequestMapping("/reports")
	public String listReports(Model model) {
		return "/reports/reports";
	}

	@RequestMapping(value = "/reporte4/{salario}")
	public String reporteMayor(@PathVariable(value = "salario") Double salario, Map<String, Object> model) {
		// double value = 1200.00;
		if (salario == null) {
			model.put("ProyectosMayores", pService.getCantidadMayor(1200.00));
			model.put("ProyectosMenores", pService.getCantidadMenor(1200.00));
		} else {
			model.put("ProyectosMayores", pService.getCantidadMayor(salario));
			model.put("ProyectosMenores", pService.getCantidadMenor(salario));
		}
		return "reports/ProyectosPagos";
	}
}
