package br.com.fernando.leticia.casamento.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="TB_PRESENTES")
@Getter
@Setter
@NoArgsConstructor
public class ListaPresente {

    @Id
    @Column(name="ID_PRESENTE", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="TITULO", length = 45, nullable = false)
    private String titulo;

    @Column(name="DESCRICAO", length = 200)
    private String descricao;

    @Column(name="VALOR")
    private Double valor;

    @Column(name="QUANTIDADE")
    private Integer quantidade;

    @Column(name="LINK", length = 2000)
    private String[] link;

    @Column(name="ATIVO")
    private Boolean ativo;

}
