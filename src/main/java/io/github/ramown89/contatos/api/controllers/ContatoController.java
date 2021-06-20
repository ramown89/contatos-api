package io.github.ramown89.contatos.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.ramown89.contatos.api.models.Contato;
import io.github.ramown89.contatos.api.repositories.ContatoRepository;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	ContatoRepository repositorio;
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> adicionarContato(@RequestBody Contato contato) {
		Contato contatoSalvo = repositorio.save(contato);
		
		return ResponseEntity.ok().body("Contato criado com sucesso!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarContato(@PathVariable long id, @RequestBody Contato contato){
		if (repositorio.existsById(id)){
			contato.setId(id);
			Contato contatoAtualizado = repositorio.save(contato);
			return ResponseEntity.ok().body("Contato Atualizado com Sucesso!");
		}
		return ResponseEntity.ok().body("Contato não encontrado!");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaContato(@PathVariable long id){
		if (repositorio.existsById(id)){
			repositorio.deleteById(id);
			return ResponseEntity.ok().body("Excluido com sucesso!");
		}
		return ResponseEntity.ok().body("Contato não encontrado!");
	}	
	
	@GetMapping
	public ResponseEntity<List<Contato>> listaContatos(){
		return ResponseEntity.ok().body(repositorio.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contato> buscarPorId(@PathVariable long id){
		return ResponseEntity.ok().body(repositorio.findById(id).get());
	}
	
	

}
