package br.org.serratec.biblioteca.controller;

import br.org.serratec.biblioteca.domain.Livro;
import br.org.serratec.biblioteca.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")

public class BibliotecaController {

    @Autowired
    private LivroRepository lR;

    @GetMapping
    public List<Livro> listarTodosLivros() {
        List<Livro> listaDeLivros = lR.findAll();
        return listaDeLivros;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Long id) {
        Optional<Livro> livroOpt = lR.findById(id);
        if (livroOpt.isPresent()) {
            return ResponseEntity.ok(livroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro inserirLivro(@Valid @RequestBody Livro livros) {
        livros = lR.save(livros);
        return livros;
    }

    @PutMapping("{id}")
    public ResponseEntity<Livro> alterarLivros(@PathVariable Long id, @Valid @RequestBody Livro livros) {

        if (!lR.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        livros.setId(id);
        livros = lR.save(livros);

        return ResponseEntity.ok(livros);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        if (!lR.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lR.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    //Adicional
    @DeleteMapping("/remover-todos")
    public ResponseEntity<Void> removerTodos() {
        lR.deleteAll();
        return ResponseEntity.noContent().build();

    }
}


