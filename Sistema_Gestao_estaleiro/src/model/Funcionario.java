/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Nelson Matsinhe
 */
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    
    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "maquina_id")
    private Maquina maquinaAlocada;

    @ManyToMany
    @JoinTable(
            name = "funcionario_material",
            joinColumns = @JoinColumn(name = "funcionario_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<Material> materiaisRecebidos = new ArrayList<>();

    public Funcionario() {
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public Maquina getMaquinaAlocada() {
        return maquinaAlocada;
    }

    public void setMaquinaAlocada(Maquina maquinaAlocada) {
        this.maquinaAlocada = maquinaAlocada;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Material> getMateriaisRecebidos() {
        return materiaisRecebidos;
    }

    public void setMateriaisRecebidos(List<Material> materiaisRecebidos) {
        this.materiaisRecebidos = materiaisRecebidos;
    }

    public void alocarMaquina(Maquina maquina) {
        if (!maquina.isAlocada()) {
            this.maquinaAlocada = maquina;
            maquina.alocar(this);
        } else {
            throw new IllegalStateException("Máquina já está alocada.");
        }
    }

    public void receberMaterial(Material material, double quantidade) {
        material.removerEstoque(quantidade);
        this.materiaisRecebidos.add(material);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
