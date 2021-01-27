package br.com.fernando.leticia.casamento.dto;

import br.com.fernando.leticia.casamento.model.ListaPresente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ListaPresenteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;
    private String descricao;
    private Double valor;
    private Integer quantidade;
    private String[] link;
    private Boolean ativo;


    public ListaPresenteDTO(ListaPresente listaPresente){
        id = listaPresente.getId();
        titulo = listaPresente.getTitulo();
        descricao = listaPresente.getDescricao();
        valor = listaPresente.getValor();
        quantidade = listaPresente.getQuantidade();
        link = listaPresente.getLink();
        ativo = listaPresente.getAtivo();
    }

}
