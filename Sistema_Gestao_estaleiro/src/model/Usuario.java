package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private long codigoUsuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "userName", unique = true)
    private String userName;

    @Column(name = "senha")
    private String senha;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "perfil")
    private String perfil;

    public Usuario() {
        this.codigoUsuario = 0;
        this.nome = "";
        this.userName = "";
        this.senha = "";
        this.perfil = "";
    }

    public Usuario(int codigo) {
        this.codigoUsuario = codigo;
        this.nome = "";
        this.userName = "";
        this.senha = "";
        this.perfil = "";
    }

    // Getters e Setters
    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
