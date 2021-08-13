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

import br.univille.pameladsi2021.model.Fornecedor;
import br.univille.pameladsi2021.model.Movimentacao;
import br.univille.pameladsi2021.service.FornecedorService;
import br.univille.pameladsi2021.service.MovimentacaoService;

import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public ModelAndView index(){
        List<Movimentacao> listaMovimentacao = service.getAll();
        return new ModelAndView("movimentacao/index","listaMovimentacao", listaMovimentacao);
      

    }
    
    
}


