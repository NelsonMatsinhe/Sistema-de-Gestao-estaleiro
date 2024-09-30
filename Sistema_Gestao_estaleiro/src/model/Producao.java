/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author Nelson Matsinhe
 */
import javax.persistence.*;
import java.util.Date;

@Entity
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Bloco bloco;

    private int quantidadeProduzida;

    @Temporal(TemporalType.DATE)
    private Date dataProducao;

    private int diasParaCura; // Dias necessários para o bloco estar pronto para uso
    private boolean prontaParaUso;

    // Construtor padrão
    public Producao() {}

    public Producao(Bloco bloco, int quantidadeProduzida, Date dataProducao, int diasParaCura) {
        this.bloco = bloco;
        this.quantidadeProduzida = quantidadeProduzida;
        this.dataProducao = dataProducao;
        this.diasParaCura = diasParaCura;
        this.prontaParaUso = false;
    }

    public void verificarCura() {
        // Verifica se o bloco já está curado com base na data de produção e dias para cura
        Date hoje = new Date();
        long diferencaDias = (hoje.getTime() - dataProducao.getTime()) / (1000 * 60 * 60 * 24);
        if (diferencaDias >= diasParaCura) {
            this.prontaParaUso = true;
        }
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public int getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(int quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public Date getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(Date dataProducao) {
        this.dataProducao = dataProducao;
    }

    public int getDiasParaCura() {
        return diasParaCura;
    }

    public void setDiasParaCura(int diasParaCura) {
        this.diasParaCura = diasParaCura;
    }

    public boolean isProntaParaUso() {
        return prontaParaUso;
    }

    public void setProntaParaUso(boolean prontaParaUso) {
        this.prontaParaUso = prontaParaUso;
    }
}

