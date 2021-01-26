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
    private byte[] imagem;
    private String[] link;


    public ListaPresenteDTO(ListaPresente listaPresente){
        id = listaPresente.getId();
        titulo = listaPresente.getTitulo();
        descricao = listaPresente.getDescricao();
        valor = listaPresente.getValor();
        quantidade = listaPresente.getQuantidade();
        imagem = listaPresente.getImagem();
        link = listaPresente.getLink();
    }

}
