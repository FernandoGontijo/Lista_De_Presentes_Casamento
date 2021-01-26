package br.com.fernando.leticia.casamento.controller;

import br.com.fernando.leticia.casamento.dto.ListaPresenteDTO;
import br.com.fernando.leticia.casamento.model.ListaPresente;
import br.com.fernando.leticia.casamento.service.ListaPresenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/presentes")
public class ListaPresenteController {

    @Autowired
    private ListaPresenteService service;


    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody ListaPresenteDTO listaPresenteDTO){
        ListaPresente listaPresente = service.fromDTO(listaPresenteDTO);
        listaPresente = service.PreencherObjeto(listaPresente);
        listaPresente = service.insert(listaPresente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(listaPresente.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<ListaPresente> find(@PathVariable Long id) {
        ListaPresente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ListaPresenteDTO listaPresenteDTO, @PathVariable Long id){
        ListaPresente listaPresente = service.fromDTO(listaPresenteDTO);
        listaPresente.setId(id);
        listaPresente = service.update(listaPresente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<ListaPresenteDTO>> findAll() {

        List<ListaPresente>  list = service.findAll();
        List<ListaPresenteDTO> listDto = list.stream().map(obj -> new ListaPresenteDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

}
