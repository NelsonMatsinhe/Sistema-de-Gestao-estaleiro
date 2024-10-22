/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import javax.persistence.*;
/**
 *
 * @author Nelson Matsinhe
 */
@Entity

@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "endereco")
    private String endereco;



    public Cliente() {
       
        this.id = 0;
        this.nome = "";
         this.telefone =  "";
        this.endereco =  "";
        
    }

    public Cliente(int id) {
        this.id = id;
        this.nome = "";
        this.telefone = "";
        this.endereco = "";
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
      @Override
    public String toString() {
        return getNome();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Cliente) {
            Cliente c = (Cliente) o;
            if (c.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }
    
}
