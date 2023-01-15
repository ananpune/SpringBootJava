package ca.sheridancollege.ananpune.controllers;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import ca.sheridancollege.ananpune.beans.PlugInEV;
import ca.sheridancollege.ananpune.database.DatabaseAccess;

@Controller
public class PlugInEVController {
	
	@Autowired
	private DatabaseAccess da;
	
	

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("pluginev", new PlugInEV());
		model.addAttribute("pluginevList", da.getPlugInEVs());
		da.insertPlugInEV();
		return "index";
		
	}
	
	@PostMapping("/insertPlugInEV")
	public String insertFlight(Model model, @ModelAttribute PlugInEV pluginev) {
		da.insertPlugInEV(pluginev.getVehiclemake(), pluginev.getVehiclemodel(), pluginev.getEnginetype(),pluginev.getPurchaseDate(), pluginev.getPurchaseTime()+":00");
		model.addAttribute("pluginev", new PlugInEV());
		model.addAttribute("pluginevList", da.getPlugInEVs());
		return "index";
	}
	
	@GetMapping("/deletePlugInEV/{id}")
	public String deletePluginEV(Model model, @PathVariable Long id) {
		da.deletePlugInEV(id);
		model.addAttribute("pluginev", new PlugInEV());
		model.addAttribute("pluginevList", da.getPlugInEVs());
		return "index";
		
	}
	
	@GetMapping("/editPlugInEV/{id}")
	public String editPlugInEV(Model model, @PathVariable Long id) {
		PlugInEV pluginev = da.getPlugInEVById(id).get(0);
		model.addAttribute(pluginev);
		da.deletePlugInEV(id);
		model.addAttribute("pluginevList", da.getPlugInEVs());
		System.out.println("Enter new information");
		return "index";
	}
}
