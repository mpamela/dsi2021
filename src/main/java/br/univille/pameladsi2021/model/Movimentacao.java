package br.univille.pameladsi2021.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Movimentacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Mercadoria mercadoria;
    private int quant;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private boolean entrada;
    private boolean saida;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Mercadoria getMercadoria() {
        return mercadoria;
    }
    public void setMercadoria(Mercadoria mercadoria) {
        this.mercadoria = mercadoria;
    }
    public int getQuant() {
        return quant;
    }
    public void setQuant(int quant) {
        this.quant = quant;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public boolean isEntrada() {
        return entrada;
    }
    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }
    public boolean isSaida() {
        return saida;
    }
    public void setSaida(boolean saida) {
        this.saida = saida;
    }

    
}
