package com.fabricio.bflprototipo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fabricio.bflprototipo.models.Usuario;
import com.fabricio.bflprototipo.repository.BflRepository;



@Controller
public class IndexController {
	@Autowired
	private BflRepository bfl;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String formCadastro( Usuario usuario){
		bfl.save(usuario);
		return "redirect:/";
	}
	
	@RequestMapping(value="/painel", method=RequestMethod.GET)
	public ModelAndView view(){
		ModelAndView mv = new ModelAndView("painel");
		Iterable<Usuario> usuarios = bfl.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	@RequestMapping("/delete/{codigo}")
	public String delete(@PathVariable("codigo") Long codigo) {
		bfl.deleteById(codigo);
		return "redirect:/painel";
		
	}
}
