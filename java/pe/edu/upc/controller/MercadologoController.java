package pe.edu.upc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.serviceinterface.IMercadologoService;

@Controller
@Secured({"ROLE_ADMIN","ROLE_MERCADOLOGO"})
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
		}
		model.addAttribute("mercadologo", new Mercadologo());
		return "redirect:/mercadologos/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Map<String, Object>model, @RequestParam(value = "id")Integer id) {
		try {
			if(id != null && id>0) {
				mService.delete(id);
				model.put("mensaje", "Se elimino correctamente");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puedo eliminar el mercadologo");
		}
		return "redirect:/mercadologos/list";
	}
	
	
	@GetMapping("/detalle/{id}")
	public String detailsMercadologo(@PathVariable(value="id") int idMercadologo, Model model) {
		try {
			Optional<Mercadologo> mercadologo = mService.listarId(idMercadologo);
			if (!mercadologo.isPresent()) {
				model.addAttribute("info", "mercadologo no existe");
				return "redirect:/mercadologo/list";
			}else {
				model.addAttribute("mercadologo", mercadologo.get());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		
		return "/mercadologo/update";
	}
	
	@RequestMapping("/find")
	public String find(Map<String, Object> model, @ModelAttribute Mercadologo mercadologo) throws ParseException {

		List<Mercadologo> listMercadologo;

		mercadologo.setNombreMercadologo(mercadologo.getNombreMercadologo());
		listMercadologo = mService.findByName(mercadologo.getNombreMercadologo());

		if (listMercadologo.isEmpty()) {
			listMercadologo = mService.findByNameMercadologoLikeIgnoreCase(mercadologo.getNombreMercadologo());
		}

		if (listMercadologo.isEmpty()) { 
			 
			model.put("mensaje", "No se encontró");
		}
		model.put("listMercadologo", listMercadologo);
		return "mercadologo/find";

	}
}
