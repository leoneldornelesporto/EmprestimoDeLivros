package br.com.emprestimodelivros.api.service;

import br.com.emprestimodelivros.api.model.Autor;
import br.com.emprestimodelivros.api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public void salvarAutor(Autor autor){
        autorRepository.save(autor);
    }

    public Iterable<Autor> buscarTodos(){
      Iterable<Autor> autores = autorRepository.findAll();
      return autores;
    }

    public Object buscarPorId(Long id){
        if(autorExiste(id)) {
            Optional<Autor> autor = autorRepository.findById(id);
            return autor;
        }
        return false;
    }

    public Boolean deletarAutor(Long id){
        if(autorExiste(id)){
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean autorExiste(Long id){
        if(autorRepository.existsById(id)){
            return true;
        }
        return false;
    }
}
