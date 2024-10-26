/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.sun.istack.NotNull;
import java.math.BigDecimal;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * class do produtos
 *
 * @author Nelson Matsinhe
 */
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private int tempoCura;

    private int quantidade;

    public Produto() {
    }

    public Produto(int id, String nome, Categoria categoria, int tempoCura, int quantidade, Date dataRegistro, BigDecimal preco, List<Maquina> maquinas) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.tempoCura = tempoCura;
        this.quantidade = quantidade;
        this.dataRegistro = dataRegistro;
        this.preco = preco;
        this.maquinas = maquinas;
    }

    @Column(name = "data_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;

    @NotNull
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @OneToMany(mappedBy = "produto")
    private List<Maquina> maquinas;

// Getter e Setter
    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public Produto(int id, String nome, Categoria categoria, int tempoCura, int quantidade, Date dataRegistro, BigDecimal preco) {
        this.id = id;
        this.nome = "";
        this.categoria = categoria;
        this.tempoCura = tempoCura;
        this.quantidade = 0;
        this.dataRegistro = new Date();
        this.preco = new BigDecimal("0.00");
    }

    public Produto(int codProduto) {
        this.id = codProduto;
        this.nome = "";

        this.dataRegistro = new Date();
        this.preco = new BigDecimal("0.00");

    }

    public void atualizarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

    public int getTempoCura() {
        return tempoCura;
    }

    public void setTempoCura(int tempoCura) {
        this.tempoCura = tempoCura;
    }

    // Getters e Setters
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            Produto p = (Produto) o;
            if (p.getId() == this.getId()) {
                return true;
            }
        }
        return false;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
