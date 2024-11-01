/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
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
    private String nome;
    private String tipo;
    @Column(name = "estado")
    private boolean estado;
    @Column(nullable = false)
    private boolean alocada;

    @OneToMany(mappedBy = "maquinaAlocada", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public Maquina() {
    }

    public Maquina(Long id, String nome, String tipo, boolean estado, boolean alocada, List<Funcionario> funcionarios) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.estado = true;
        this.alocada = false;
        this.funcionarios = funcionarios;
    }

    public void alocar(Funcionario funcionario) {
        if (!this.isAlocada()) {
            this.setAlocada(true);
            if (this.funcionarios == null) {
                this.funcionarios = new ArrayList<>();
            }
            this.funcionarios.add(funcionario);
        } else {
            throw new IllegalStateException("Máquina já está alocada.");
        }
    }

    // Método para verificar se a máquina está disponível
    public boolean isDisponivel() {
        return !this.alocada;  // Retorna true se a máquina não estiver alocada
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

    public String getNome() {
        return nome;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return nome;
    }

}
