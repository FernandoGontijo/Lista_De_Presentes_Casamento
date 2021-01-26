package br.com.fernando.leticia.casamento.repository;

import br.com.fernando.leticia.casamento.model.ListaPresente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaPresenteRepository extends JpaRepository<ListaPresente, Long> {
}
