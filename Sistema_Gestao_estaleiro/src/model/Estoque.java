package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nelson Matsinhe
 */
import javax.persistence.*;
import java.util.List;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Material> materiais;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Producao> blocos;

    // Construtor padrão
    public Estoque() {}

    public void adicionarMaterial(Material material) {
        this.materiais.add(material);
    }

    public void removerMaterial(Material material) {
        this.materiais.remove(material);
    }

    public void adicionarProducao(Producao bloco) {
        this.blocos.add(bloco);
    }

    public void removerProducao(Producao bloco) {
        this.blocos.remove(bloco);
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

    public List<Producao> getProducaos() {
        return blocos;
    }

    public void setProducaos(List<Producao> blocos) {
        this.blocos = blocos;
    }
}

