package br.univille.pameladsi2021.controller;


import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import br.univille.pameladsi2021.model.Fornecedor;
import br.univille.pameladsi2021.service.FornecedorService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ModelAndView index(){
        List<Fornecedor> listaFornecedor = service.getAll();
        return new ModelAndView("fornecedor/index","listaFornecedor", listaFornecedor);
      

    }
    @GetMapping("/novo")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView novo(@ModelAttribute Fornecedor fornecedor){
        return new ModelAndView("fornecedor/form");

    }
    @PostMapping(params = "form")
    public ModelAndView save(Fornecedor fornecedor){
        service.save(fornecedor);
        return new ModelAndView("redirect:/fornecedor");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Fornecedor fornecedor ){
        System.out.println(fornecedor.getNome());
        return new ModelAndView("/fornecedor/form","fornecedor",fornecedor);

    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Fornecedor fornecedor){
        service.delete(fornecedor);
        return new ModelAndView("redirect:/fornecedor");
    }
    
}



