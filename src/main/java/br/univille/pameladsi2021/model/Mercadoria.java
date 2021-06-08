package br.univille.pameladsi2021.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nome;
    private int data;
    private int valuni;
    private int quantmin;
    private int quantmax;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Fornecedor fornecedor;
    

    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public int getValuni() {
        return valuni;
    }
    public void setValuni(int valuni) {
        this.valuni = valuni;
    }
    
    public int getQuantmin() {
        return quantmin;
    }
    public void setQuantmin(int quantmin) {
        this.quantmin = quantmin;
    }
    public int getQuantmax() {
        return quantmax;
    }
    public void setQuantmax(int quantmax) {
        this.quantmax = quantmax;
    }

    
}