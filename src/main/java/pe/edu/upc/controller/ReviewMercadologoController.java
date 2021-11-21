package pe.edu.upc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.ReviewMercadologo;
import pe.edu.upc.serviceinterface.IMercadologoService;
import pe.edu.upc.serviceinterface.IReviewMercadologoService;

@Controller
@RequestMapping("/reviewMercadologos")
public class ReviewMercadologoController {

	@Autowired
	private IReviewMercadologoService rService;
	
	@Autowired
	private IMercadologoService eService;
	
	@GetMapping("/new")
	public String newReviewEmprendedor(Model model) {
		model.addAttribute("listaMercadologos", eService.list());
		model.addAttribute("reviewMercadologo", new ReviewMercadologo());
		return "reviewMercadologo/reviewMercadologo";
	}
	
	@GetMapping("/list")
	public String listReviewMercadologos(Model model) {
		try {
			model.addAttribute("reviewMercadologo", new ReviewMercadologo());
			model.addAttribute("listaReviewMercadologo", rService.list());

		}catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "reviewMercadologo/listReviewMercadologo";
	}
	
	@PostMapping("/save")
	public String saveReviewMercadologo(@Validated ReviewMercadologo reviewMercadologo, BindingResult result, Model model, SessionStatus status ) throws Exception {
		if(result.hasErrors()) {
			return "reviewMercadologo/reviewMercadologo";
		} else {
			int rpta = rService.insert(reviewMercadologo);
			if(rpta>0) {
				model.addAttribute("mensaje","Se guardó correctamente");
				status.setComplete();
			}
			model.addAttribute("reviewMercadologo", new ReviewMercadologo());
			return "redirect:/reviewMercadologos/list";
		}
	}
	
	
	
	@RequestMapping("/reporte2")
	public String mercadologosXreview(Map<String,Object> model) {
		model.put("listMerXRev",rService.merXrev());
		return "reports/MercadologosMaxReviews";
	}
	
	
	@RequestMapping("/reports")
	public String listReports(Model model) {
		return "/reports/reports";
	}
	
}
