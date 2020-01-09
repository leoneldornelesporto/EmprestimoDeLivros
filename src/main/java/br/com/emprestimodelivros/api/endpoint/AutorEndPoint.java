package br.com.emprestimodelivros.api.endpoint;

import br.com.emprestimodelivros.api.model.Autor;
import br.com.emprestimodelivros.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("autores")
public class AutorEndPoint {
    AutorService autorService;

    @Autowired
    public AutorEndPoint(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(autorService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        if(autorService.buscarPorId(id).equals(false)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(autorService.buscarPorId(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Autor autor) {
        autorService.salvarAutor(autor);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Autor autor) {
        if(autorService.autorExiste(autor.getId())){
            autorService.salvarAutor(autor);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (autorService.deletarAutor(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/")
    public String irParHome(){
        return "index";
    }
}