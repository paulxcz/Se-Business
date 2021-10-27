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


import pe.edu.upc.entities.Soporte;
import pe.edu.upc.serviceinterface.ISoporteService;

@Controller
@RequestMapping("soportes")
public class SoporteController {

	@Autowired
	private ISoporteService sService;
	
	@GetMapping("/new")
	public String newSoporte(Model model) {
		model.addAttribute("soporte",new Soporte());
		return "soporte/soporte";
	}
	
	@GetMapping("/list")
	public String listSoportes(Model model) {
		try {
			model.addAttribute("soporte", new Soporte());
			model.addAttribute("listaSoportes", sService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "soporte/listSoporte";
	}
	
	@PostMapping("/save")
	public String saveSoporte(@Validated Soporte soporte, BindingResult result, Model model, SessionStatus status) throws Exception {
		if(result.hasErrors()) {
			return "soporte/soporte";
		} else {
			int rpta = sService.insert(soporte);
			if(rpta>0) {
				model.addAttribute("mensaje", "Ya existe");
				return "soporte/soporte";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
			model.addAttribute("soporte", new Soporte());
			return "redirect:/soportes/list";
		}
	}
	
	
}





