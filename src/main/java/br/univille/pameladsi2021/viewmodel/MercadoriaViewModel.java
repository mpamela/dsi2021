package br.univille.pameladsi2021.viewmodel;

import br.univille.pameladsi2021.model.Mercadoria;

public class MercadoriaViewModel {
    private Mercadoria mercadoria;
    private int quantidadeTotal;

    public MercadoriaViewModel(Mercadoria mercadoria, int quantidadeTotal) {
        this.mercadoria = mercadoria;
        this.quantidadeTotal = quantidadeTotal;
    }
    public Mercadoria getMercadoria() {
        return mercadoria;
    }
    public void setMercadoria(Mercadoria mercadoria) {
        this.mercadoria = mercadoria;
    }
    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }
    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    
    
}
