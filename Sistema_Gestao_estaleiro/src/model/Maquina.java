/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */
@Entity
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @Column(nullable = false)
    private boolean alocada;

    @OneToMany(mappedBy = "maquinaAlocada")
    private List<Funcionario> funcionarios;

      public void alocar(Funcionario funcionario) {
        if (!this.alocada) {
            this.alocada = true;
            this.funcionarios.add(funcionario);
        } else {
            throw new IllegalStateException("Máquina já está alocada.");
        }
    }

    public void desalocar() {
        this.alocada = false;
        this.funcionarios.clear();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAlocada() {
        return alocada;
    }

    public void setAlocada(boolean alocada) {
        this.alocada = alocada;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
