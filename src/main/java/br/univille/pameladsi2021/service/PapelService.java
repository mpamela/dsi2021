package br.univille.pameladsi2021.service;

import org.springframework.stereotype.Service;

import br.univille.pameladsi2021.model.Papel;

@Service
public interface PapelService {
    Papel findByDescricao(String descricao);
    void save(Papel papel);
}