package pe.edu.upc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Contrato;
import pe.edu.upc.serviceinterface.IContratoService;
import pe.edu.upc.serviceinterface.IMercadologoService;
import pe.edu.upc.serviceinterface.IProyectoService;

@Controller
@Secured({"ROLE_ADMIN","ROLE_SOPORTE"})
@RequestMapping("/contratos")
public class ContratoController {
	
	@Autowired
	private IContratoService cService;
	@Autowired
	private IProyectoService pService;
	@Autowired
	private IMercadologoService mService;
	
	@GetMapping("/new")
	public String newContrato(Model model) {
		model.addAttribute("listaProyectos", pService.list());
		model.addAttribute("listaMercadologos", mService.list());
		model.addAttribute("contrato", new Contrato());
		return "contrato/contrato";		
	}	
	
	@GetMapping("/list")
	public String listContratos(Model model) {
		try {
			model.addAttribute("contrato", new Contrato());
			model.addAttribute("listaContratos", cService.list());
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}
		return "contrato/listContratos";
	}
	
	@RequestMapping("/save")
	public String saveContrato(@Validated Contrato contrato, BindingResult result, Model model, SessionStatus status) throws Exception{
		if(result.hasErrors()){
			model.addAttribute("listaProyectos", pService.list());
			model.addAttribute("listaMercadologos", mService.list());
			return "contrato/contrato";
		}else {
			int rpta = cService.insert(contrato);
			if(rpta>0) {
				model.addAttribute("mensaje", "Ya existe");
				return "contrato/contrato";
			}else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
			model.addAttribute("contrato", new Contrato());
			return "redirect:/contratos/list";
		}
	}
	
	@Secured({"ROLE_ADMIN","ROLE_EMPRENDEDOR"})
	@RequestMapping("/reporte6")
	public String mercadologosConMasProyectos(Map<String, Object> model) {
		model.put("listMercadologosConMasProyecto", cService.mercadologosConMasProyectos());
		return "reports/mercadologosConMasProyectos";
	}
	
}
