package br.com.fernando.leticia.casamento.service;

import br.com.fernando.leticia.casamento.dto.ListaPresenteDTO;
import br.com.fernando.leticia.casamento.model.ListaPresente;
import br.com.fernando.leticia.casamento.repository.ListaPresenteRepository;
import br.com.fernando.leticia.casamento.exceptions.DataIntegrityException;

import br.com.fernando.leticia.casamento.exceptions.ObjectNotFoundException;
import br.com.fernando.leticia.casamento.util.Validador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class ListaPresenteService {

    @Autowired
    private ListaPresenteRepository repo;


    public ListaPresente insert(ListaPresente listaPresente) {
        listaPresente.setId(null);
        return repo.save(listaPresente);
    }

    public ListaPresente find(Long id) throws ObjectNotFoundException {

        Optional<ListaPresente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Presente não encontrado! Id: " + id + ", Nome: " + ListaPresente.class.getName()));
    }

    public ListaPresente update(ListaPresente lista) {
        ListaPresente listaPresente = find(lista.getId());
        updateData(listaPresente, lista);
        return repo.save(listaPresente);
    }

    public void delete(Long id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir");
        }
    }

    public List<ListaPresente> findAll(){
        return repo.findAll();
    }


    public ListaPresente fromDTO(ListaPresenteDTO listaDTO) {

        ListaPresente listaPresente = new ListaPresente();

        listaPresente.setId(listaDTO.getId());
        listaPresente.setTitulo(listaDTO.getTitulo());
        listaPresente.setDescricao(listaDTO.getDescricao());
        listaPresente.setValor(listaDTO.getValor());
        listaPresente.setQuantidade(listaDTO.getQuantidade());
        listaPresente.setImagem(listaDTO.getImagem());
        listaPresente.setLink(listaDTO.getLink());

        return listaPresente;
    }

    public ListaPresente PreencherObjeto(ListaPresente listaPresente){

        String[] linkFake = {"link"};

        if(Validador.isNull(listaPresente.getTitulo())){
            listaPresente.setTitulo("");
        }
        if(Validador.isNull(listaPresente.getDescricao())){
            listaPresente.setDescricao("");
        }
        if(Validador.isNull(listaPresente.getValor())){
            listaPresente.setValor(0D);
        }
        if(Validador.isNull(listaPresente.getQuantidade())){
            listaPresente.setQuantidade(0);
        }
        if(Validador.isNull(listaPresente.getImagem())){
            listaPresente.setImagem("null".getBytes(StandardCharsets.UTF_8));
        }
        if(Validador.isNull(listaPresente.getLink())){
            listaPresente.setLink(linkFake);
        }

        return listaPresente;

    }


    private void updateData(ListaPresente listaPresente, ListaPresente lista) {

        if(Validador.isNotNull(lista.getTitulo())){
            listaPresente.setTitulo(lista.getTitulo());
        }
        if(Validador.isNotNull(lista.getDescricao())){
            listaPresente.setDescricao(lista.getDescricao());
        }
        if(Validador.isNotNull(lista.getValor())){
            listaPresente.setValor(lista.getValor());
        }
        if(Validador.isNotNull(lista.getQuantidade())){
            listaPresente.setQuantidade(lista.getQuantidade());
        }
        if(Validador.isNotNull(lista.getImagem())){
            listaPresente.setImagem(lista.getImagem());
        }
        if(Validador.isNotNull(lista.getLink())){
            listaPresente.setLink(lista.getLink());
        }

    }


}
