package br.univille.pameladsi2021.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.pameladsi2021.model.Movimentacao;
import br.univille.pameladsi2021.repository.MovimentacaoRepository;
import br.univille.pameladsi2021.service.MovimentacaoService;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{

    @Autowired
    private MovimentacaoRepository repository; 
    @Override
    public List<Movimentacao> getAll() {
        return repository.findAll();

    }
    
}
