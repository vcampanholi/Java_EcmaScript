package br.vandersoncamp.eplants.model;import javax.persistence.*;import javax.validation.constraints.NotNull;import javax.validation.constraints.Size;import javax.xml.bind.annotation.XmlRootElement;import java.io.Serializable;@Entity@XmlRootElement@Table(name = "plantas_utilizacao")@SequenceGenerator(name = "seq_plantas_utilizacao", sequenceName = "seq_plantas_utilizacao", initialValue = 1, allocationSize = 1)public class PlantaUtilizacao implements Serializable {    private static final long serialVersionUID = 1L;    @Id    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plantas_utilizacao")    private Long id;    @NotNull    @Size(max = 255)    @Column(name = "descricao", nullable = false)    private String descricao;    @Size(max = 500)    @Column(name = "observacao", nullable = true)    private String observacao;    public PlantaUtilizacao() {        super();    }    public Long getId() {        return id;    }    public void setId(Long id) {        this.id = id;    }    public String getDescricao() {        return descricao;    }    public void setDescricao(String descricao) {        this.descricao = descricao;    }    public String getObservacao() {        return observacao;    }    public void setObservacao(String observacao) {        this.observacao = observacao;    }}