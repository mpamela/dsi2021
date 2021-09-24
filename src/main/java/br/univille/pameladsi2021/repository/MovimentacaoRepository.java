package br.univille.pameladsi2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.univille.pameladsi2021.model.Movimentacao;

@Repository
public interface MovimentacaoRepository  extends JpaRepository<Movimentacao,Long>{
    


}
