package br.com.emprestimodelivros.api.repository;

import br.com.emprestimodelivros.api.model.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor,Long> {
}
