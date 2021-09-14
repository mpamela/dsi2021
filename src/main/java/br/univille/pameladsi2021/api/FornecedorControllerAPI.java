package br.univille.pameladsi2021.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.pameladsi2021.model.Fornecedor;
import br.univille.pameladsi2021.service.FornecedorService;

@RestController
@RequestMapping("/api/v1/fornecedor")
public class FornecedorControllerAPI {
    
    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAll(){
        return new ResponseEntity<List<Fornecedor>>(service.getAll(), HttpStatus.OK);
    }
}