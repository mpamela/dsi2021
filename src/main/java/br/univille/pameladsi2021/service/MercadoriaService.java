package br.univille.pameladsi2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.pameladsi2021.model.Mercadoria;

@Service
public interface MercadoriaService {
    public List<Mercadoria> getAll();
    public void save(Mercadoria mercadoria);
    public void delete(Mercadoria mercadoria);
    public int getTotalizador(Mercadoria mercadoria);
    
}

