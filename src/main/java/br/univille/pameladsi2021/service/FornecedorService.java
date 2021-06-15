package br.univille.pameladsi2021.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.pameladsi2021.model.Fornecedor;

@Service
public interface FornecedorService {
    public List<Fornecedor> getAll();
    
}
