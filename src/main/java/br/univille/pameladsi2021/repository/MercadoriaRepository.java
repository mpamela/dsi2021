package br.univille.pameladsi2021.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.pameladsi2021.model.Mercadoria;

@Repository
public interface MercadoriaRepository extends JpaRepository<Mercadoria,Long>{
    List<Mercadoria> findByNomeContains(String nome);
    
}
