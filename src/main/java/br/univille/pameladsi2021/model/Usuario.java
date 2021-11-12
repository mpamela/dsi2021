package br.univille.pameladsi2021.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usuario;
    private String senha;
    private Papel papel;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Papel> listaPapeis = new ArrayList<Papel>();

    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<Papel> papeis = getListaPapeis();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Papel papel : papeis){
            authorities.add(new SimpleGrantedAuthority(papel.getDescricao()));
        }
        return authorities;
    }

    public List<Papel> getListaPapeis() {
        return listaPapeis;
    }
    public void setListaPapeis(List<Papel> listaPapeis) {
        this.listaPapeis = listaPapeis;
    }

    
    

    public Papel getPapel() {
        return papel;
    }
    public void setPapel(Papel papel) {
        this.papel = papel;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
/*public enum Papel {
    ADMINISTRADOR,
    ALMOXERIFE;
}*/
