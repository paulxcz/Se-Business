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

import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.serviceinterface.IMercadologoService;

@Controller
@RequestMapping("/mercadologos")
public class MercadologoController {

	@Autowired
	private IMercadologoService mService;

	@GetMapping("/new")
	public String newMercadologo(Model model) {
		model.addAttribute("mercadologo", new Mercadologo());
		return "mercadologo/mercadologo";
	}

	@GetMapping("/list")
	public String listMercadologos(Model model) {
		try {
			model.addAttribute("mercadologo", new Mercadologo());
			model.addAttribute("listaMercadologos", mService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());

		}
		return "mercadologo/listMercadologo";
	}

	@PostMapping("/save")
	public String saveMercadologo(@Validated Mercadologo mercadologo, BindingResult result, Model model,
			SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "mercadologo/mercadologo";
		} else {
			int rpta = mService.insert(mercadologo);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "mercadologo/mercadologo";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
			model.addAttribute("mercadologo", new Mercadologo());
			return "redirect:/mercadologos/list";
		}
	}
}
