package br.univille.pameladsi2021.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.pameladsi2021.model.Fornecedor;
import br.univille.pameladsi2021.service.FornecedorService;


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
    public ModelAndView novo(@ModelAttribute Fornecedor forncedor){
        return new ModelAndView("fornecedor/form");

    }
    @PostMapping(params = "form")
    public ModelAndView save(Fornecedor forncedor){
        System.out.println(forncedor.getNome());
        return new ModelAndView("forncedor/form");
    }
}



