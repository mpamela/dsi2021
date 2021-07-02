package br.univille.pameladsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.pameladsi2021.model.Fornecedor;
import br.univille.pameladsi2021.repository.FornecedorRepository;
import br.univille.pameladsi2021.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository repository; 
    @Override
    public List<Fornecedor> getAll() {
        return repository.findAll();
    }
    @Override
    public void save(Fornecedor fornecedor) {
        repository.save(fornecedor);
        
    }
    @Override
    public void delete(Fornecedor fornecedor){
        repository.delete(fornecedor);
    }
    
}

