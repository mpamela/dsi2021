package br.univille.pameladsi2021.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.pameladsi2021.model.Mercadoria;
import br.univille.pameladsi2021.service.MercadoriaService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/mercadoria")
public class MercadoriaController {

    @Autowired
    private MercadoriaService service;

    @GetMapping
    public ModelAndView index(){
        List<Mercadoria> listaMercadoria = service.getAll();
        return new ModelAndView("mercadoria/index","listaMercadoria", listaMercadoria);
      

    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Mercadoria mercadoria){
        return new ModelAndView("mercadoria/form");

    }
    @PostMapping(params = "form")
    public ModelAndView save(Mercadoria mercadoria){
        service.save(mercadoria);
        return new ModelAndView("redirect:/mercadoria");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Mercadoria mercadoria){
        System.out.println(mercadoria.getNome());
        return new ModelAndView("/mercadoria/form","mercadoria",mercadoria);

    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Mercadoria mercadoria){
        service.delete(mercadoria);
        return new ModelAndView("redirect:/mercadoria");
    }
    
}





