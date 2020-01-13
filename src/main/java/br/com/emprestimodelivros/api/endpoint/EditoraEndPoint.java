package br.com.emprestimodelivros.api.endpoint;

import br.com.emprestimodelivros.api.model.Editora;
import br.com.emprestimodelivros.api.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editora")
public class EditoraEndPoint {
    EditoraRepository editoraRepository;

    @Autowired
    public EditoraEndPoint(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    @PostMapping
    public ResponseEntity<?> saveEditora(@RequestBody Editora editora){
        editoraRepository.save(editora);
        return new ResponseEntity<>(editora, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAllEditoras(){
        return new ResponseEntity<>(editoraRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        if(editoraRepository.existsById(id)){
            return new ResponseEntity<>(editoraRepository.findById(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Editora editora){
        editoraRepository.save(editora);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAutorById(@PathVariable Long id){
        editoraRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
