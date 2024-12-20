package model;

import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */
@Entity
@Table(name = "producao")
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
    // Variável estática para manter um contador de lotes
    private static int contadorLote = 1;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProducao;

    @OneToMany(mappedBy = "producao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoteProducao> lotes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "producao_material",
            joinColumns = @JoinColumn(name = "producao_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<Material> materiais;

    @Column(name = "estado")
    private Boolean estado;

    // Construtor padrão
    public Producao() {
        this.dataProducao = new Date();
        this.estado = true;
        this.lotes = new ArrayList<>();
    }

    // Método para criar novo lote
    public LoteProducao criarLote(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        LoteProducao lote = new LoteProducao();
        lote.setProducao(this);
        lote.setQuantidadeInicial(quantidade);
        lote.setQuantidadeAtual(quantidade);
        lote.setNumeroLote(gerarNumeroLote());

        // Calcula a data de final de cura com base no tempoCura do produto
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, produto.getTempoCura());
        lote.setDataFinalCura(calendar.getTime());

        lotes.add(lote);
        this.quantidadeProduzida += quantidade;
        return lote;
    }

// Método para gerar número de lote de forma simples
    // Variável estática para manter um contador de lotes


// Método para gerar número de lote com o nome do produto
private String gerarNumeroLote() {
    String nomeProdutoFormatado = produto.getNome().replace(" ", "_");
    return String.format("LOTE-%s-%d-%03d", nomeProdutoFormatado, produto.getId(), contadorLote++);
}


    // Método para obter quantidade total pronta para uso
    public int getQuantidadeProntaParaUso() {
        return lotes.stream()
                .filter(LoteProducao::isProntaParaUso)
                .mapToInt(LoteProducao::getQuantidadeAtual)
                .sum();
    }

    // Método para obter quantidade total em cura
    public int getQuantidadeEmCura() {
        return lotes.stream()
                .filter(lote -> !lote.isProntaParaUso())
                .mapToInt(LoteProducao::getQuantidadeAtual)
                .sum();
    }

    // Método para obter total de quebras
    public int getTotalQuebras() {
        return lotes.stream()
                .mapToInt(LoteProducao::getQuantidadeQuebrada)
                .sum();
    }

    // Método para calcular percentual total de quebras
    public double getPercentualTotalQuebras() {
        if (quantidadeProduzida == 0) {
            return 0;
        }
        return (double) getTotalQuebras() / quantidadeProduzida * 100;
    }

    // Método para atualizar status de cura de todos os lotes
    public void atualizarStatusCura() {
        lotes.forEach(LoteProducao::verificarCura);
    }

    // Método para alocar máquina
    public void alocarMaquina(Maquina maquina) {
        if (maquina != null && maquina.isDisponivel()) {
            this.maquina = maquina;
            maquina.setAlocada(true);
        } else {
            throw new IllegalArgumentException("Máquina não disponível");
        }
    }

    // Método para registrar produção
    public void registrarProducao(Funcionario funcionario, int quantidade, List<Material> materiaisUtilizados) {
        if (this.maquina == null) {
            throw new IllegalStateException("Máquina não alocada para produção");
        }

        this.funcionario = funcionario;
        this.materiais = materiaisUtilizados;

        // Atualiza estoque de materiais
        for (Material material : materiaisUtilizados) {
            material.removerEstoque(calcularQuantidadeNecessaria(material, quantidade));
        }

        // Cria lote com a quantidade produzida
        criarLote(quantidade);
    }

    // Método para calcular quantidade necessária de material
    private double calcularQuantidadeNecessaria(Material material, int quantidade) {
        // Implementar lógica específica de cálculo baseada no material e quantidade
        return material.getQuantidade() * quantidade;
    }

    // Getters e Setters
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

    public List<LoteProducao> getLotes() {
        return lotes;
    }

    public void setLotes(List<LoteProducao> lotes) {
        this.lotes = lotes;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
