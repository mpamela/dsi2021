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
public class Mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int codigo;
    private String nome;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private float valuni;
    private int quantmin;
    private int quantmax;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Fornecedor fornecedor;
    

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public float getValuni() {
        return valuni;
    }
    public void setValuni(float valuni) {
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
