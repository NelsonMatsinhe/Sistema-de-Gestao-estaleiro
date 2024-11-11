/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Nelson Matsinhe
 */
@Entity
@Table(name = "lotes_producao")
public class LoteProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producao_id", nullable = false)
    private Producao producao;

    @Column(nullable = false)
    private String numeroLote;

    private int quantidadeInicial;
    private int quantidadeAtual;
    private int quantidadeQuebrada;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinalCura;

    private boolean prontaParaUso;

    // Construtor padrão
    public LoteProducao() {
        this.dataCriacao = new Date();
        this.quantidadeQuebrada = 0;
        this.prontaParaUso = false;
    }

    // Construtor com parâmetros
    public LoteProducao(Producao producao, String numeroLote, int quantidadeInicial, Date dataFinalCura) {
        this();
        this.producao = producao;
        this.numeroLote = numeroLote;
        this.quantidadeInicial = quantidadeInicial;
        this.quantidadeAtual = quantidadeInicial;
        this.dataFinalCura = dataFinalCura;
    }

    // Método para registrar quebras
    public void registrarQuebra(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        if (quantidade > this.quantidadeAtual) {
            throw new IllegalArgumentException("Quantidade de quebra maior que quantidade disponível");
        }
        this.quantidadeQuebrada += quantidade;
        this.quantidadeAtual -= quantidade;
    }

    // Método para verificar se o lote está pronto para uso
    public void verificarCura() {
        if (new Date().after(dataFinalCura)) {
            this.prontaParaUso = true;
        }
    }

    // Método para calcular o percentual de quebra
    public double getPercentualQuebra() {
        return (double) quantidadeQuebrada / quantidadeInicial * 100;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public int getQuantidadeInicial() {
        return quantidadeInicial;
    }

    public void setQuantidadeInicial(int quantidadeInicial) {
        this.quantidadeInicial = quantidadeInicial;
        if (this.quantidadeAtual == 0) {
            this.quantidadeAtual = quantidadeInicial;
        }
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public int getQuantidadeQuebrada() {
        return quantidadeQuebrada;
    }

    public void setQuantidadeQuebrada(int quantidadeQuebrada) {
        this.quantidadeQuebrada = quantidadeQuebrada;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataFinalCura() {
        return dataFinalCura;
    }

    public void setDataFinalCura(Date dataFinalCura) {
        this.dataFinalCura = dataFinalCura;
    }

    public boolean isProntaParaUso() {
        return prontaParaUso;
    }

    public void setProntaParaUso(boolean prontaParaUso) {
        this.prontaParaUso = prontaParaUso;
    }

    @Override
    public String toString() {
        return "LoteProducao{"
                + "numeroLote='" + numeroLote + '\''
                + ", quantidadeAtual=" + quantidadeAtual
                + ", prontaParaUso=" + prontaParaUso
                + '}';
    }
}
 