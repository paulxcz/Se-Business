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

import pe.edu.upc.entities.ReviewEmprendedor;
import pe.edu.upc.serviceinterface.IEmprendedorService;
import pe.edu.upc.serviceinterface.IReviewEmprendedorService;

@Controller
@RequestMapping("/reviewEmprendedores")
public class ReviewEmprendedorController {

	@Autowired
	private IReviewEmprendedorService rService;
	
	@Autowired
	private IEmprendedorService eService;
	
	@GetMapping("/new")
	public String newReviewEmprendedor(Model model) {
		model.addAttribute("listaEmprendedores", eService.list());
		model.addAttribute("reviewEmprendedor", new ReviewEmprendedor());
		return "reviewEmprendedor/reviewEmprendedor";
	}
	
	@GetMapping("/list")
	public String listReviewEmprendedores(Model model) {
		try {
			model.addAttribute("reviewEmprendedor", new ReviewEmprendedor());
			model.addAttribute("listaReviewEmprendedor", rService.list());

		}catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "reviewEmprendedor/listReviewEmprendedor";
	}
	
	@PostMapping("/save")
	public String saveReviewEmprendedor(@Validated ReviewEmprendedor reviewEmprendedor, BindingResult result, Model model, SessionStatus status ) throws Exception {
		if(result.hasErrors()) {
			return "reviewEmprendedor/reviewEmprendedor";
		} else {
			int rpta = rService.insert(reviewEmprendedor);
			if(rpta>0) {
				model.addAttribute("mensaje","Se guardó correctamente");
				status.setComplete();
			}
			model.addAttribute("reviewEmprendedor", new ReviewEmprendedor());
			return "redirect:/reviewEmprendedores/list";
		}
	}
}
