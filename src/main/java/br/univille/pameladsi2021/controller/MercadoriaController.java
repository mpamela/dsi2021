package br.univille.pameladsi2021.controller;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.univille.pameladsi2021.model.Mercadoria;
import br.univille.pameladsi2021.service.MercadoriaService;
import org.springframework.web.bind.annotation.RequestParam;
import br.univille.pameladsi2021.service.StorageFilesService;
import br.univille.pameladsi2021.viewmodel.MercadoriaViewModel;




@Controller
@RequestMapping("/mercadoria")
public class MercadoriaController {

    @Autowired
    private MercadoriaService service;

    @Autowired
    private StorageFilesService storageFilesService;

    @GetMapping
    public ModelAndView index(){
        List<Mercadoria> listaMercadoria = service.getAll();
        List<MercadoriaViewModel> listaMercadoriaViewModel = new ArrayList<>();

        for(Mercadoria umaMercadoria:listaMercadoria){
            int total = service.getTotalizador(umaMercadoria);
            listaMercadoriaViewModel.add(new MercadoriaViewModel(umaMercadoria, total));
        }

        return new ModelAndView("mercadoria/index","listaMercadoriaViewModel", listaMercadoriaViewModel);
      

    }
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Mercadoria mercadoria){
        return new ModelAndView("mercadoria/form");

    }
    @PostMapping(params = "form")
    public ModelAndView save(Mercadoria mercadoria, @RequestParam("file") MultipartFile file){
        if(file.getSize() != 0){
            String caminho = storageFilesService.save(file);
            mercadoria.setFoto(caminho);
        }
        service.save(mercadoria);
        return new ModelAndView("redirect:/mercadoria");        
    }

    @GetMapping(value = "/image/{id}")
    public @ResponseBody byte[] getImage(@PathVariable("id") Mercadoria mercadoria){
        try{
            File file = new File(mercadoria.getFoto());
            byte[] bytes = new byte[(int) file.length()];
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            dis.readFully(bytes);
            return bytes;   
        }catch (Exception e){
            return new byte[0];
        }
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





