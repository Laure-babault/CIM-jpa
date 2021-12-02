package fr.lo.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.lo.cim.entity.Maladie;
import fr.lo.cim.service.MaladieService;

@RestController
public class MaladieController {

	
	@Autowired
    private MaladieService maladieService;
	
	 @GetMapping("/maladies/{code}")
	    public Maladie searchMaladie(@PathVariable String code) {
	        return maladieService.searchService(code);
	    }
	 
	 @GetMapping("/maladies/{code}/enfants")
	public List<Maladie> maladieEnfant(@PathVariable String code){
		 return maladieService.enfantService(maladieService.searchService(code));
	 }
}
