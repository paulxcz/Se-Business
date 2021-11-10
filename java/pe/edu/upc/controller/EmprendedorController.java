package pe.edu.upc.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Emprendedor;
import pe.edu.upc.serviceinterface.IEmprendedorService;

@Controller
@RequestMapping("/emprendedores")
public class EmprendedorController {

	@Autowired
	private IEmprendedorService eService;
	
	@GetMapping("/new")
	public String newEmprendedor(Model model) {
		model.addAttribute("emprendedor", new Emprendedor());
		return "emprendedor/emprendedor";
	}
	
	@GetMapping("/list")
	public String listEmprendedores(Model model) {
		try {
			model.addAttribute("emprendedor", new Emprendedor());
			model.addAttribute("listaEmprendedores", eService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "emprendedor/listEmprendedores";
	}
	
	@RequestMapping("/delete")
	public String delete(Map<String, Object>model, @RequestParam(value = "id")Integer id) {
		try {
			if(id != null && id>0) {
				eService.delete(id);
				model.put("mensaje", "Se elimino correctamente");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puedo eliminar el emprendedor");
		}
		return "/emprendedor/listEmprendedores";
	}
	
	@GetMapping("/detalle/{id}")
	public String detailsCategory(@PathVariable(value="id")int id, Model model) {
		try {
			Optional<Emprendedor> emprendedor = eService.listarId(id);
			if(!emprendedor.isPresent()) {
				model.addAttribute("info", "Emprendedor no existe");
				return "redirect:/emprendedor/list";
			}
			else {
				model.addAttribute("emprendedor", emprendedor.get());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/emprendedor/update";
	}
	
	
	@PostMapping("/save")
	public String saveEmprendedor(@Validated Emprendedor emprendedor, BindingResult result, Model model, SessionStatus status) throws Exception {
		if(result.hasErrors()) {
			return "emprendedor/emprendedor";
		} else {
			int rpta = eService.insert(emprendedor);
			if(rpta>0) {
				model.addAttribute("mensaje", "Ya existe");
				return "emprendedor/emprendedor";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
			model.addAttribute("emprendedor", new Emprendedor());
			return "redirect:/emprendedores/list";
		}
	}
}
