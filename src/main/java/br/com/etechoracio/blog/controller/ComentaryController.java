package br.com.etechoracio.blog.controller;


import br.com.etechoracio.blog.entity.Comentary;
import br.com.etechoracio.blog.repository.ComentaryRepositary;
import br.com.etechoracio.blog.repository.PostRepository;
import org.apache.coyote.Response;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// DUPLA: VITOR E RAFAEL
@RestController
@RequestMapping("/comentary")
public class ComentaryController {
    @Autowired
    private ComentaryRepositary comentaryRepositary;
    @GetMapping
    public List<Comentary> listar(){return comentaryRepositary.findAll();}
    // DUPLA: VITOR E RAFAEL
    @GetMapping("/{id}")
    public ResponseEntity<Comentary> listarId(@PathVariable Long id){
        var busca = comentaryRepositary.findById(id);
        if (busca.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(busca.get());
    }

    @PostMapping
    public ResponseEntity<Comentary> create(@RequestBody Comentary comentary){
        return ResponseEntity.status(HttpStatus.CREATED).body(comentaryRepositary.save(comentary));
    }

    @PutMapping
    public ResponseEntity<Comentary> update(@RequestBody Comentary comentary, @PathVariable Long id){
        var busca = comentaryRepositary.findById(id);

        if (busca.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(comentaryRepositary.save(comentary));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comentary> delete (@RequestBody Comentary comentary, @PathVariable Long id) {
        var busca = comentaryRepositary.findById(id);
        if (busca.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        comentaryRepositary.deleteById(id);
        return ResponseEntity.ok().build();

    }
    // DUPLA: VITOR E RAFAEL
}
