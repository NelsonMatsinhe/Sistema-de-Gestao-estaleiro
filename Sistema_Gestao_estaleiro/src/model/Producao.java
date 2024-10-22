package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "maquina_id", nullable = false)
    private Maquina maquina;

    private int quantidadeProduzida;

    @Temporal(TemporalType.DATE)
    private Date dataProducao;

    private boolean prontaParaUso;

    private int diasParaCura;  // Dias necessários para o produto curar

    @ManyToMany
    @JoinTable(
        name = "producao_material",
        joinColumns = @JoinColumn(name = "producao_id"),
        inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<Material> materiais;  // Lista de materiais usados na produção

    // Construtor padrão
    public Producao() {
    }

    // Método para alocar a máquina antes de iniciar a produção
    public void alocarMaquina(Maquina maquina) {
        if (maquina != null && maquina.isDisponivel()) {
            this.maquina = maquina;
            maquina.setAlocada(true);  // Marcando a máquina como alocada
        } else {
            throw new IllegalArgumentException("A máquina não está disponível.");
        }
    }

    // Método para registrar a produção
    public void registrarProducao(Funcionario funcionario, int quantidade, List<Material> materiaisUtilizados) {
        if (this.maquina == null) {
            throw new IllegalStateException("A máquina não foi alocada para a produção.");
        }
        this.funcionario = funcionario;
        this.quantidadeProduzida = quantidade;
        this.dataProducao = new Date();
        this.produto.atualizarEstoque(quantidade);  // Atualiza o estoque do produto
        this.materiais = materiaisUtilizados;
        for (Material material : materiaisUtilizados) {
            material.removerEstoque(calcularQuantidadeNecessaria(material));  // Atualiza o estoque do material
        }
        this.prontaParaUso = false;  // Marca inicialmente como não pronta para uso
        this.diasParaCura = produto.getTempoCura();  // Define os dias de cura do produto
    }

    // Verifica se o produto já passou pelos dias de cura
    public void verificarCura() {
        Date hoje = new Date();
        long diferencaDias = (hoje.getTime() - dataProducao.getTime()) / (1000 * 60 * 60 * 24);
        if (diferencaDias >= diasParaCura) {  // Verificação com base no tempo de cura do produto
            this.prontaParaUso = true;
        }
    }

    // Método auxiliar para calcular a quantidade de material necessária para a produção
    private double calcularQuantidadeNecessaria(Material material) {
        // Implemente a lógica de cálculo da quantidade necessária com base no tipo de material
        return material.getQuantidade(); // Exemplo simples, pode ser modificado
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

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
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

    public boolean isProntaParaUso() {
        return prontaParaUso;
    }

    public void setProntaParaUso(boolean prontaParaUso) {
        this.prontaParaUso = prontaParaUso;
    }

    public int getDiasParaCura() {
        return diasParaCura;
    }

    public void setDiasParaCura(int diasParaCura) {
        this.diasParaCura = diasParaCura;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }
}
