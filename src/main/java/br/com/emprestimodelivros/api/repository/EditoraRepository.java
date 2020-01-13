package br.com.emprestimodelivros.api.repository;

import br.com.emprestimodelivros.api.model.Editora;
import org.springframework.data.repository.CrudRepository;

public interface EditoraRepository extends CrudRepository<Editora,Long> {
}
