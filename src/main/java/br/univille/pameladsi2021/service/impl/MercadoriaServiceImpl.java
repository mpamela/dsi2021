package br.univille.pameladsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.pameladsi2021.model.Mercadoria;
import br.univille.pameladsi2021.repository.MercadoriaRepository;
import br.univille.pameladsi2021.service.MercadoriaService;

@Service
public class MercadoriaServiceImpl implements MercadoriaService {

    @Autowired
    private MercadoriaRepository repository; 
    @Override
    public List<Mercadoria> getAll() {
        return repository.findAll();
    }
    @Override
    public void save(Mercadoria mercadoria) {
        repository.save(mercadoria);
        
    }
    @Override
    public void delete(Mercadoria mercadoria){
        repository.delete(mercadoria);
    }
    @Override
    public int getTotalizador(Mercadoria mercadoria) {
        try{

        
        return repository.getTotalizador(mercadoria);
        }catch(Exception e){
            return 0;

        }
    }
    
}



