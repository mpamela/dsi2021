package br.univille.pameladsi2021.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        List<Fornecedor> listaFornecedores = service.getAll();
        return new ResponseEntity<List<Fornecedor>>(listaFornecedores, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor fornecedor){
        try{
            fornecedor.setId(0);
            service.save(fornecedor);
            return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/list")
    public ResponseEntity<List<Fornecedor>> insertList(@RequestBody List<Fornecedor> listaFornecedores){
        for(Fornecedor umFornecedor: listaFornecedores){
            umFornecedor.setId(0);
            service.save(umFornecedor);
        }
        return new ResponseEntity<List<Fornecedor>>(listaFornecedores,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable("id") Fornecedor fornecedor){
        return new ResponseEntity<Fornecedor>(fornecedor,HttpStatus.OK);
    }
    @DeleteMapping("/{id")
    public ResponseEntity<Fornecedor> delete(@PathVariable("id")Fornecedor fornecedor){
        service.delete(fornecedor);
        return new ResponseEntity<>(fornecedor,HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@RequestBody Fornecedor fornecedorNovo, @PathVariable("id")Fornecedor fornecedorAntigo){
        fornecedorAntigo.setEndereco(fornecedorNovo.getEndereco());
        fornecedorAntigo.setEmail(fornecedorNovo.getEmail());
        fornecedorAntigo.setTelefone(fornecedorNovo.getTelefone());

        service.save(fornecedorAntigo);

        return new ResponseEntity<>(fornecedorAntigo,HttpStatus.OK);
    }
}