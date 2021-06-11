package br.univille.pameladsi2021.controller;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView index(){

        HashMap<String,String>listaDeParzinho = new HashMap<>();
        listaDeParzinho.put("nome", "Sistema de DSI 2021");
        listaDeParzinho.put("nomeEmpresa", "Univille");

        return new ModelAndView("Home/index",listaDeParzinho);
    }
    
}
