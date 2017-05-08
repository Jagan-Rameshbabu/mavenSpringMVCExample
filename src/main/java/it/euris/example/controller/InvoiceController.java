package it.euris.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.euris.example.config.AppConfig;
import it.euris.example.utils.NameTransformer;

@Controller
public class InvoiceController {
	
	@Autowired NameTransformer nt;
	
	@GetMapping("/hello")
	public String hello() {
		return "welcome";
	}
	
	
	@RequestMapping("/greetings")
	public String Greetings(){
		return "ciao";
	}
	
	
	@RequestMapping(value="/greets", method=RequestMethod.GET)
	public ModelAndView Greets(@RequestParam("name") String name){
		ModelAndView modelAndView = new ModelAndView("greetings");
		modelAndView.addObject(name);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/greetz", method=RequestMethod.GET)
	public ModelAndView Greetz(@RequestParam("name") String name){
		//inject a bean that transform the received parameter
		String namex = nt.ChangeName(name);
				
		ModelAndView modelAndView = new ModelAndView("greetings");
		modelAndView.addObject("namex", namex);
		
		return modelAndView;
	}
	

}
