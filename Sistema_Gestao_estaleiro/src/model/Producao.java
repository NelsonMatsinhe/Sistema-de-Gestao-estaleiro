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
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;
    
    private int quantidadeProduzida;

    @Temporal(TemporalType.DATE)
    private Date dataProducao;

    private int diasParaCura; // Dias necessários para o produto estar pronto para uso
    private boolean prontaParaUso;

    // Construtor padrão
    public Producao() {
    }
  public void registrarProducao(Funcionario funcionario, int quantidade) {
        this.funcionario = funcionario;
        this.quantidadeProduzida = quantidade;
        this.dataProducao = new Date();
        this.produto.atualizarEstoque(quantidade);
    }

 
    public void verificarCura() {
        // Verifica se o produto já está curado com base na data de produção e dias para cura
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
